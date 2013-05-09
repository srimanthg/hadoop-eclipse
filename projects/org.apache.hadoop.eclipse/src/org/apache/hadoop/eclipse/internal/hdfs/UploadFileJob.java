/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.hadoop.eclipse.internal.hdfs;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URI;

import org.apache.hadoop.eclipse.Activator;
import org.apache.log4j.Logger;
import org.eclipse.core.filesystem.EFS;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;

/**
 * @author Srimanth Gunturi
 * 
 */
public class UploadFileJob extends Job {

	private final static Logger logger = Logger.getLogger(UploadFileJob.class);
	private final HDFSFileStore store;
	private final IResource resource;

	/**
	 * @throws CoreException
	 * 
	 */
	public UploadFileJob(IResource resource) throws CoreException {
		super("Uploading " + resource.getLocationURI());
		this.resource = resource;
		this.store = (HDFSFileStore) EFS.getStore(resource.getLocationURI());;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.core.resources.IWorkspaceRunnable#run(org.eclipse.core.runtime
	 * .IProgressMonitor)
	 */
	@Override
	public IStatus run(IProgressMonitor monitor) {
		IStatus status = Status.OK_STATUS;
		if (store != null) {
			URI uri = store.toURI();
			try {
				File localFile = store.getLocalFile();
				if (logger.isDebugEnabled())
					logger.debug("[" + uri + "]: Uploading from " + (localFile == null ? "(null)" : localFile.toString()));
				HDFSManager.INSTANCE.startServerOperation(uri.toString());
				if (localFile != null && localFile.exists()) {
					boolean uploaded = false;
					monitor.beginTask("Uploading " + localFile.getAbsolutePath(), (int) localFile.length());
					FileInputStream fis = new FileInputStream(localFile);
					OutputStream fos = store.openRemoteOutputStream(EFS.NONE, new NullProgressMonitor());
					try {
						if (!monitor.isCanceled()) {
							byte[] data = new byte[8 * 1024];
							int read = fis.read(data);
							int totalRead = 0;
							while (read > -1) {
								if (monitor.isCanceled())
									throw new InterruptedException();
								fos.write(data, 0, read);
								totalRead += read;
								monitor.worked(read);
								read = fis.read(data);
								if (logger.isDebugEnabled())
									logger.debug("Uploaded " + totalRead + " out of " + localFile.length() + " [" + (((float)totalRead*100.0f) / (float)localFile.length())
											+ "]");
							}
							uploaded = true;
						}
					} catch (InterruptedException e) {
						throw e;
					} finally {
						try {
							fis.close();
						} catch (Throwable t) {
						}
						try {
							fos.close();
						} catch (Throwable t) {
						}
						if (uploaded) {
							// Delete parent folders if empty.
							File parentFolder = localFile.getParentFile();
							localFile.delete();
							deleteFoldersIfEmpty(parentFolder);
						}
						monitor.done();
					}
				} else
					status = new Status(IStatus.ERROR, Activator.BUNDLE_ID, "Local file not found [" + localFile + "]");
				resource.refreshLocal(IResource.DEPTH_ONE, new NullProgressMonitor());
			} catch (InterruptedException e) {
				logger.debug("Uploading file [" + uri + "] cancelled by user");
			} catch (IOException e) {
				status = new Status(IStatus.ERROR, Activator.BUNDLE_ID, "Error uploading file " + uri, e);
			} catch (CoreException e) {
				status = new Status(IStatus.ERROR, Activator.BUNDLE_ID, e.getMessage(), e);
				;
			} finally {
				HDFSManager.INSTANCE.stopServerOperation(uri.toString());
			}
		}
		return status;
	}

	/**
	 * Will attempt to delete the provided folder and its parents provided they
	 * are empty.
	 * 
	 * @param localFile
	 */
	public static void deleteFoldersIfEmpty(File folder) {
		File toDeleteFolder = folder;
		String[] children = toDeleteFolder.list();
		while (children == null || children.length < 1) {
			// Empty folder
			folder = toDeleteFolder.getParentFile();
			toDeleteFolder.delete();
			toDeleteFolder = folder;
			children = folder.list();
		}
	}
}
