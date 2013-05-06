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
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;

import org.apache.hadoop.eclipse.Activator;
import org.apache.log4j.Logger;
import org.eclipse.core.filesystem.EFS;
import org.eclipse.core.filesystem.IFileInfo;
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
public class DownloadFileJob extends Job {

	private final static Logger logger = Logger.getLogger(DownloadFileJob.class);
	private final HDFSFileStore store;

	/**
	 * 
	 */
	public DownloadFileJob(HDFSFileStore store) {
		super("Downloading " + store.toURI().toString());
		this.store = store;
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
					logger.debug("[" + uri + "]: Downloading to " + (localFile == null ? "(null)" : localFile.toString()));
				HDFSManager.INSTANCE.startServerOperation(uri.toString());
				final IFileInfo serverInfo = store.fetchInfo();
				if (serverInfo.exists()) {
					monitor.beginTask("Downloading " + uri.toString(), (int) serverInfo.getLength());
					if (!localFile.exists()) {
						localFile.getParentFile().mkdirs();
						localFile.createNewFile();
					}
					InputStream openInputStream = store.openRemoteInputStream(EFS.NONE, new NullProgressMonitor());
					FileOutputStream fos = new FileOutputStream(localFile);
					try {
						if (!monitor.isCanceled()) {
							byte[] data = new byte[8 * 1024];
							int totalRead = 0;
							int read = openInputStream.read(data);
							while (read > -1) {
								if (monitor.isCanceled())
									throw new InterruptedException();
								fos.write(data, 0, read);
								totalRead += read;
								monitor.worked(read);
								read = openInputStream.read(data);
								if (logger.isDebugEnabled())
									logger.debug("Downloaded " + totalRead + " out of " + serverInfo.getLength() + " [" + (((float)totalRead*100.0f) / (float)serverInfo.getLength())
											+ "]");
							}
						}
					} catch (IOException e) {
						throw e;
					} catch (InterruptedException e) {
						throw e;
					} finally {
						try {
							openInputStream.close();
						} catch (Throwable t) {
						}
						try {
							fos.close();
						} catch (Throwable t) {
						}
						monitor.done();
					}
				} else {
					throw new CoreException(new Status(IStatus.ERROR, Activator.BUNDLE_ID, "Server resource not found [" + uri + "]"));
				}
			} catch (InterruptedException e) {
				logger.warn(e);
			} catch (CoreException e) {
				logger.warn(e);
				status = e.getStatus();
			} catch (FileNotFoundException e) {
				logger.warn(e);
				status = new Status(IStatus.ERROR, Activator.BUNDLE_ID, "Local file not found for writing server content [" + uri + "]", e);
			} catch (IOException e) {
				logger.warn(e);
				status = new Status(IStatus.ERROR, Activator.BUNDLE_ID, "Error downloading file content [" + uri + "]", e);
			} finally {
				HDFSManager.INSTANCE.stopServerOperation(uri.toString());
			}
		}
		return status;
	}
}
