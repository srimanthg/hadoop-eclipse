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
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import org.apache.hadoop.eclipse.Activator;
import org.apache.hadoop.eclipse.hdfs.HDFSClient;
import org.apache.hadoop.eclipse.hdfs.ResourceInformation;
import org.apache.hadoop.eclipse.internal.model.HDFSServer;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.eclipse.core.filesystem.EFS;
import org.eclipse.core.filesystem.IFileInfo;
import org.eclipse.core.filesystem.IFileStore;
import org.eclipse.core.filesystem.provider.FileInfo;
import org.eclipse.core.filesystem.provider.FileStore;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.URIUtil;

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
	private IFileInfo serverFileInfo = null;
	private ResourceInformation serverResourceInfo = null;
	private HDFSServer hdfsServer;
	private ResourceInformation.Permissions effectivePermissions = null;
	private List<String> systemDefaultUserIdAndGroupIds = null;

	public HDFSFileStore(HDFSURI uri) {
		this.uri = uri;
	}

	protected HDFSServer getServer() {
		if (hdfsServer == null) {
			hdfsServer = HDFSManager.INSTANCE.getServer(this.uri.getURI().toString());
		}
		return hdfsServer;
	}

	@Override
	public String[] childNames(int options, IProgressMonitor monitor) throws CoreException {
		List<String> childNamesList = new ArrayList<String>();
		if (getServer() != null) {
			try {
				List<ResourceInformation> listResources = getClient().listResources(uri.getURI(), getServer().getUserId());
				for (ResourceInformation lr : listResources) {
					if (lr != null)
						childNamesList.add(lr.getName());
				}
			} catch (IOException e) {
				throw new CoreException(new Status(IStatus.ERROR, Activator.BUNDLE_ID, e.getMessage(), e));
			} catch (InterruptedException e) {
				throw new CoreException(new Status(IStatus.ERROR, Activator.BUNDLE_ID, e.getMessage(), e));
			}
		}
		if (logger.isDebugEnabled())
			logger.debug("[" + uri + "]: childNames():" + childNamesList);
		return childNamesList.toArray(new String[childNamesList.size()]);
	}

	@Override
	public IFileInfo fetchInfo(int options, IProgressMonitor monitor) throws CoreException {
		if (serverFileInfo == null) {
			serverResourceInfo = null;
			this.effectivePermissions = new ResourceInformation.Permissions();
			FileInfo fi = new FileInfo(getName());
			HDFSServer server = getServer();
			if (server != null) {
				try {
					if (".project".equals(getName())) {
						fi.setExists(getLocalFile().exists());
						fi.setLength(getLocalFile().length());
					} else {
						ResourceInformation fileInformation = getClient().getResourceInformation(uri.getURI(), server.getUserId());
						if (fileInformation != null) {
							serverResourceInfo = fileInformation;
							fi.setDirectory(fileInformation.isFolder());
							fi.setExists(true);
							fi.setLastModified(fileInformation.getLastModifiedTime());
							fi.setLength(fileInformation.getSize());
							fi.setName(fileInformation.getName());
							String userId = server.getUserId();
							List<String> groupIds = server.getGroupIds();
							if (userId == null) {
								userId = getDefaultUserId();
								groupIds = getDefaultGroupIds();
							}
							fileInformation.updateEffectivePermissions(userId, groupIds);
							this.effectivePermissions.copy(fileInformation.getEffectivePermissions());
							fi.setAttribute(EFS.ATTRIBUTE_OWNER_READ, fileInformation.getUserPermissions().read);
							fi.setAttribute(EFS.ATTRIBUTE_OWNER_WRITE, fileInformation.getUserPermissions().write);
							fi.setAttribute(EFS.ATTRIBUTE_OWNER_EXECUTE, fileInformation.getUserPermissions().execute);
							fi.setAttribute(EFS.ATTRIBUTE_GROUP_READ, fileInformation.getGroupPermissions().read);
							fi.setAttribute(EFS.ATTRIBUTE_GROUP_WRITE, fileInformation.getGroupPermissions().write);
							fi.setAttribute(EFS.ATTRIBUTE_GROUP_EXECUTE, fileInformation.getGroupPermissions().execute);
							fi.setAttribute(EFS.ATTRIBUTE_OTHER_READ, fileInformation.getOtherPermissions().read);
							fi.setAttribute(EFS.ATTRIBUTE_OTHER_WRITE, fileInformation.getOtherPermissions().write);
							fi.setAttribute(EFS.ATTRIBUTE_OTHER_EXECUTE, fileInformation.getOtherPermissions().execute);
						}
					}
				} catch (IOException e) {
					throw new CoreException(new Status(IStatus.ERROR, Activator.BUNDLE_ID, e.getMessage(), e));
				} catch (InterruptedException e) {
					throw new CoreException(new Status(IStatus.ERROR, Activator.BUNDLE_ID, e.getMessage(), e));
				} finally {
				}
			} else {
				// No server definition
				fi.setExists(false);
			}
			serverFileInfo = fi;
		}
		if (logger.isDebugEnabled())
			logger.debug("[" + uri + "]: fetchInfo(): " + HDFSUtilites.getDebugMessage(serverFileInfo));
		return serverFileInfo;
	}

	protected String getDefaultUserId() {
		if (systemDefaultUserIdAndGroupIds == null) {
			try {
				this.systemDefaultUserIdAndGroupIds = getClient().getDefaultUserAndGroupIds();
			} catch (IOException e) {
				logger.debug(e.getMessage(), e);
			} catch (CoreException e) {
				logger.debug(e.getMessage(), e);
			}
		}
		if (this.systemDefaultUserIdAndGroupIds != null && this.systemDefaultUserIdAndGroupIds.size() > 0)
			return this.systemDefaultUserIdAndGroupIds.get(0);
		return null;
	}

	protected List<String> getDefaultGroupIds() {
		if (systemDefaultUserIdAndGroupIds == null) {
			try {
				this.systemDefaultUserIdAndGroupIds = getClient().getDefaultUserAndGroupIds();
			} catch (IOException e) {
				logger.debug(e.getMessage(), e);
			} catch (CoreException e) {
				logger.debug(e.getMessage(), e);
			}
		}
		if (this.systemDefaultUserIdAndGroupIds != null && this.systemDefaultUserIdAndGroupIds.size() > 1)
			return this.systemDefaultUserIdAndGroupIds.subList(1, this.systemDefaultUserIdAndGroupIds.size() - 1);
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.core.filesystem.provider.FileStore#putInfo(org.eclipse.core
	 * .filesystem.IFileInfo, int, org.eclipse.core.runtime.IProgressMonitor)
	 */
	@Override
	public void putInfo(IFileInfo info, int options, IProgressMonitor monitor) throws CoreException {
		try {
			ResourceInformation ri = new ResourceInformation();
			ri.setFolder(info.isDirectory());
			ri.setLastModifiedTime(info.getLastModified());
			HDFSServer server = getServer();
			getClient().setResourceInformation(uri.getURI(), ri, server == null ? null : server.getUserId());
		} catch (IOException e) {
			throw new CoreException(new Status(IStatus.ERROR, Activator.BUNDLE_ID, e.getMessage(), e));
		} catch (InterruptedException e) {
			throw new CoreException(new Status(IStatus.ERROR, Activator.BUNDLE_ID, e.getMessage(), e));
		}
	}

	/**
	 * When this file store makes changes which obsolete the server information,
	 * it should clear the server information.
	 */
	protected void clearServerFileInfo() {
		if (logger.isDebugEnabled())
			logger.debug("[" + uri + "]: clearServerFileInfo()");
		this.serverFileInfo = null;
	}

	@Override
	public IFileStore getChild(String name) {
		if (logger.isDebugEnabled())
			logger.debug("[" + uri + "]: getChild():" + name);
		return new HDFSFileStore(uri.append(name));
	}

	@Override
	public String getName() {
		String lastSegment = uri.lastSegment();
		if (lastSegment == null)
			lastSegment = "/";
		if (logger.isDebugEnabled())
			logger.debug("[" + uri + "]: getName():" + lastSegment);
		return lastSegment;
	}

	@Override
	public IFileStore getParent() {
		if (logger.isDebugEnabled())
			logger.debug("[" + uri + "]: getParent()");
		try {
			return new HDFSFileStore(uri.removeLastSegment());
		} catch (URISyntaxException e) {
			logger.log(Level.WARN, e.getMessage(), e);
		}
		return null;
	}

	@Override
	public InputStream openInputStream(int options, IProgressMonitor monitor) throws CoreException {
		if (logger.isDebugEnabled())
			logger.debug("[" + uri + "]: openInputStream()");
		if (".project".equals(getName())) {
			try {
				final File localFile = getLocalFile();
				if (!localFile.exists())
					localFile.createNewFile();
				return new FileInputStream(localFile);
			} catch (FileNotFoundException e) {
				throw new CoreException(new Status(IStatus.ERROR, Activator.BUNDLE_ID, e.getMessage(), e));
			} catch (IOException e) {
				throw new CoreException(new Status(IStatus.ERROR, Activator.BUNDLE_ID, e.getMessage(), e));
			}
		} else {
			File lFile = getLocalFile();
			if (lFile.exists()) {
				try {
					return new FileInputStream(lFile);
				} catch (FileNotFoundException e) {
					throw new CoreException(new Status(IStatus.ERROR, Activator.BUNDLE_ID, e.getMessage(), e));
				}
			} else {
				HDFSServer server = getServer();
				return openRemoteInputStream(options, monitor);
			}
		}
	}

	public InputStream openRemoteInputStream(int options, IProgressMonitor monitor) throws CoreException {
		if (logger.isDebugEnabled())
			logger.debug("[" + uri + "]: openRemoteInputStream()");
		if (".project".equals(getName())) {
			return null;
		} else {
			try {
				HDFSServer server = getServer();
				return getClient().openInputStream(uri.getURI(), server == null ? null : server.getUserId());
			} catch (IOException e) {
				throw new CoreException(new Status(IStatus.ERROR, Activator.BUNDLE_ID, e.getMessage(), e));
			} catch (InterruptedException e) {
				throw new CoreException(new Status(IStatus.ERROR, Activator.BUNDLE_ID, e.getMessage(), e));
			}
		}
	}

	@Override
	public URI toURI() {
		return uri.getURI();
	}

	public static HDFSClient getClient() throws CoreException {
		IConfigurationElement[] elementsFor = Platform.getExtensionRegistry().getConfigurationElementsFor("org.apache.hadoop.eclipse.hdfsclient");
		try {
			return (HDFSClient) elementsFor[0].createExecutableExtension("class");
		} catch (CoreException t) {
			throw t;
		}
	}

	/**
	 * @return the localFile
	 * @throws CoreException
	 */
	public File getLocalFile() throws CoreException {
		if (localFile == null) {
			final HDFSManager hdfsManager = HDFSManager.INSTANCE;
			final String uriString = uri.getURI().toString();
			HDFSServer server = hdfsManager.getServer(uriString);
			if (server != null) {
				File workspaceFolder = ResourcesPlugin.getWorkspace().getRoot().getLocation().toFile();
				try {
					URI relativeURI = URIUtil.makeRelative(uri.getURI(), new URI(server.getUri()));
					String relativePath = hdfsManager.getProjectName(server) + "/" + relativeURI.toString();
					localFile = new File(workspaceFolder, relativePath);
				} catch (URISyntaxException e) {
					throw new CoreException(new Status(IStatus.ERROR, Activator.BUNDLE_ID, e.getMessage(), e));
				}
			} else
				logger.error("No server associated with uri: " + uriString);
		}
		if (logger.isDebugEnabled())
			logger.debug("[" + uri + "]: getLocalFile():" + localFile);
		return localFile;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.core.filesystem.provider.FileStore#mkdir(int,
	 * org.eclipse.core.runtime.IProgressMonitor)
	 */
	@Override
	public IFileStore mkdir(int options, IProgressMonitor monitor) throws CoreException {
		if (logger.isDebugEnabled())
			logger.debug("[" + uri + "]: mkdir()");
		try {
			clearServerFileInfo();
			HDFSServer server = getServer();
			if (getClient().mkdirs(uri.getURI(), server == null ? null : server.getUserId())) {
				return this;
			} else {
				return null;
			}
		} catch (IOException e) {
			logger.error("Unable to mkdir: " + uri);
			throw new CoreException(new Status(IStatus.ERROR, Activator.BUNDLE_ID, e.getMessage(), e));
		} catch (InterruptedException e) {
			logger.error("Unable to mkdir: " + uri);
			throw new CoreException(new Status(IStatus.ERROR, Activator.BUNDLE_ID, e.getMessage(), e));
		}
	}

	public boolean isLocalFile() {
		try {
			File localFile = getLocalFile();
			return localFile != null && localFile.exists();
		} catch (CoreException e) {
			logger.debug("Unable to determine if file is local", e);
		}
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.core.filesystem.provider.FileStore#openOutputStream(int,
	 * org.eclipse.core.runtime.IProgressMonitor)
	 */
	@Override
	public OutputStream openOutputStream(int options, IProgressMonitor monitor) throws CoreException {
		if (logger.isDebugEnabled())
			logger.debug("[" + uri + "]: openOutputStream()");
		if (".project".equals(getName())) {
			try {
				File dotProjectFile = getLocalFile();
				if (!dotProjectFile.exists()) {
					dotProjectFile.getParentFile().mkdirs();
					dotProjectFile.createNewFile();
				}
				return new FileOutputStream(dotProjectFile);
			} catch (FileNotFoundException e) {
				throw new CoreException(new Status(IStatus.ERROR, Activator.BUNDLE_ID, e.getMessage(), e));
			} catch (IOException e) {
				throw new CoreException(new Status(IStatus.ERROR, Activator.BUNDLE_ID, e.getMessage(), e));
			}
		} else {
			File lFile = getLocalFile();
			if (lFile.exists()) {
				try {
					return new FileOutputStream(lFile);
				} catch (FileNotFoundException e) {
					throw new CoreException(new Status(IStatus.ERROR, Activator.BUNDLE_ID, e.getMessage(), e));
				}
			} else {
				return openRemoteOutputStream(options, monitor);
			}
		}
	}

	public OutputStream openRemoteOutputStream(int options, IProgressMonitor monitor) throws CoreException {
		if (logger.isDebugEnabled())
			logger.debug("[" + uri + "]: openRemoteOutputStream()");
		try {
			HDFSServer server = getServer();
			if (fetchInfo().exists()) {
				clearServerFileInfo();
				return getClient().openOutputStream(uri.getURI(), server == null ? null : server.getUserId());
			} else {
				clearServerFileInfo();
				return getClient().createOutputStream(uri.getURI(), server == null ? null : server.getUserId());
			}
		} catch (IOException e) {
			throw new CoreException(new Status(IStatus.ERROR, Activator.BUNDLE_ID, e.getMessage(), e));
		} catch (InterruptedException e) {
			throw new CoreException(new Status(IStatus.ERROR, Activator.BUNDLE_ID, e.getMessage(), e));
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.core.filesystem.provider.FileStore#delete(int,
	 * org.eclipse.core.runtime.IProgressMonitor)
	 */
	@Override
	public void delete(int options, IProgressMonitor monitor) throws CoreException {
		if (logger.isDebugEnabled())
			logger.debug("[" + uri + "]: delete()");
		try {
			final HDFSServer server = getServer();
			if (server != null) {
				if (server.getUri().equals(uri.getURI().toString())) {
					// Server location is the same as the project - so we just
					// disconnect instead of actually deleting the root folder
					// on HDFS.
				} else {
					clearServerFileInfo();
					getClient().delete(uri.getURI(), server == null ? null : server.getUserId());
				}
			} else {
				// Not associated with any server, we just disconnect.
			}
		} catch (IOException e) {
			logger.error("Unable to delete: " + uri);
			throw new CoreException(new Status(IStatus.ERROR, Activator.BUNDLE_ID, e.getMessage(), e));
		} catch (InterruptedException e) {
			logger.error("Unable to delete: " + uri);
			throw new CoreException(new Status(IStatus.ERROR, Activator.BUNDLE_ID, e.getMessage(), e));
		}
	}

	/**
	 * @return the effectivePermissions
	 */
	public ResourceInformation.Permissions getEffectivePermissions() {
		if (effectivePermissions == null) {
			fetchInfo();
			if (effectivePermissions == null)
				effectivePermissions = new ResourceInformation.Permissions();
		}
		return effectivePermissions;
	}

	/**
	 * @return the serverResourceInfo
	 */
	public ResourceInformation getServerResourceInfo() {
		return serverResourceInfo;
	}
}
