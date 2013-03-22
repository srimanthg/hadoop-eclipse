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

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import org.apache.hadoop.eclipse.Activator;
import org.apache.hadoop.eclipse.hdfs.HDFSClient;
import org.apache.hadoop.eclipse.hdfs.ResourceInformation;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.eclipse.core.filesystem.IFileInfo;
import org.eclipse.core.filesystem.IFileStore;
import org.eclipse.core.filesystem.provider.FileInfo;
import org.eclipse.core.filesystem.provider.FileStore;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;

/**
 * Represents a file or folder in the Hadoop Distributed File System. This
 * {@link IFileStore} knows about the remote HDFS resource, and the local
 * resource. Based on this, it is able to tell a lot about each file and its
 * sync status.
 * 
 * @author Srimanth Gunturi
 */
public class HDFSFileStore extends FileStore {

	private static final Logger logger = Logger.getLogger(HDFSFileStore.class);
	private final HDFSURI uri;
	private File localFile = null;
	private String DOT_PROJECT_CONTENT = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><projectDescription><name>HDFS</name><comment></comment><projects></projects></projectDescription>";

	public HDFSFileStore(HDFSURI uri) {
		this.uri = uri;
	}

	@Override
	public String[] childNames(int options, IProgressMonitor monitor) throws CoreException {
		List<String> childNamesList = new ArrayList<String>();
		try {
			List<ResourceInformation> listResources = getClient().listResources(uri.getURI());
			for (ResourceInformation lr : listResources) {
				if (lr != null)
					childNamesList.add(lr.getName());
			}
		} catch (IOException e) {
			throw new CoreException(new Status(IStatus.ERROR, Activator.BUNDLE_ID, e.getMessage(), e));
		}
		return childNamesList.toArray(new String[childNamesList.size()]);
	}

	@Override
	public IFileInfo fetchInfo(int options, IProgressMonitor monitor) throws CoreException {
		FileInfo fi = new FileInfo(getName());
		try {
			if (".project".equals(getName())) {
				fi.setExists(true);
				fi.setLength(DOT_PROJECT_CONTENT.length());
			} else {
				ResourceInformation fileInformation = getClient().getResource(uri.getURI());
				if (fileInformation != null) {
					fi.setDirectory(fileInformation.isFolder());
					fi.setExists(true);
					fi.setLastModified(fileInformation.getLastModifiedTime());
					fi.setLength(fileInformation.getSize());
					fi.setName(fileInformation.getName());
				}
			}
		} catch (IOException e) {
			throw new CoreException(new Status(IStatus.ERROR, Activator.BUNDLE_ID, e.getMessage(), e));
		}
		return fi;
	}

	@Override
	public IFileStore getChild(String name) {
		return new HDFSFileStore(uri.append(name));
	}

	@Override
	public String getName() {
		String lastSegment = uri.lastSegment();
		if (lastSegment == null)
			lastSegment = "/";
		return lastSegment;
	}

	@Override
	public IFileStore getParent() {
		try {
			return new HDFSFileStore(uri.removeLastSegment());
		} catch (URISyntaxException e) {
			logger.log(Level.WARN, e.getMessage(), e);
		}
		return null;
	}

	@Override
	public InputStream openInputStream(int options, IProgressMonitor monitor) throws CoreException {
		if (".project".equals(getName())) {
			try {
				return new ByteArrayInputStream(DOT_PROJECT_CONTENT.getBytes("UTF-8"));
			} catch (UnsupportedEncodingException e) {
				throw new CoreException(new Status(IStatus.ERROR, Activator.BUNDLE_ID, e.getMessage(), e));
			}
		} else {
			try {
				return getClient().openInputStream(uri.getURI(), monitor);
			} catch (IOException e) {
				throw new CoreException(new Status(IStatus.ERROR, Activator.BUNDLE_ID, e.getMessage(), e));
			}
		}
	}

	@Override
	public URI toURI() {
		return uri.getURI();
	}

	protected HDFSClient getClient() throws CoreException {
		IConfigurationElement[] elementsFor = Platform.getExtensionRegistry().getConfigurationElementsFor("org.apache.hadoop.eclipse.hdfsclient");
		try {
			return (HDFSClient) elementsFor[0].createExecutableExtension("class");
		} catch (CoreException t) {
			System.err.println(t.getMessage());
			throw t;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.core.filesystem.provider.FileStore#mkdir(int,
	 * org.eclipse.core.runtime.IProgressMonitor)
	 */
	@Override
	public IFileStore mkdir(int options, IProgressMonitor monitor) throws CoreException {
		// TODO Auto-generated method stub
		return super.mkdir(options, monitor);
	}

	public boolean isLocalFile() {
		return localFile != null && localFile.exists();
	}
}
