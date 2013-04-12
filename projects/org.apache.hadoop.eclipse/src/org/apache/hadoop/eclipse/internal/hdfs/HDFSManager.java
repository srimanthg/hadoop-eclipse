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
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.hadoop.eclipse.Activator;
import org.apache.hadoop.eclipse.internal.model.HDFSServer;
import org.apache.hadoop.eclipse.internal.model.HadoopFactory;
import org.apache.hadoop.eclipse.internal.model.ServerStatus;
import org.apache.hadoop.eclipse.internal.model.Servers;
import org.apache.log4j.Logger;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.osgi.framework.Bundle;

/**
 * Manages workspace files with server files.
 * 
 * @author Srimanth Gunturi
 * 
 */
public class HDFSManager {

	public static HDFSManager INSTANCE = new HDFSManager();
	private static final Logger logger = Logger.getLogger(HDFSManager.class);
	private static final String MODEL_FILE_NAME = "servers.xmi";

	private Servers servers = null;
	private Map<HDFSServer, String> serverToProjectMap = new HashMap<HDFSServer, String>();
	private Map<String, HDFSServer> projectToServerMap = new HashMap<String, HDFSServer>();
	/**
	 * URI should always end with a '/'
	 */
	private Map<String, HDFSServer> uriToServerMap = new HashMap<String, HDFSServer>();
	private HashSet<String> serverOperationURIs = new HashSet<String>();

	private Map<String, HDFSServer> uriToServerCacheMap = new LinkedHashMap<String, HDFSServer>() {
		private static final long serialVersionUID = 1L;
		private int MAX_ENTRIES = 1 << 10;

		protected boolean removeEldestEntry(Map.Entry<String, HDFSServer> eldest) {
			return size() > MAX_ENTRIES;
		};
	};

	/**
	 * Singleton
	 */
	private HDFSManager() {
	}

	public Servers getServers() {
		if (servers == null)
			loadServers();
		if (servers == null)
			servers = HadoopFactory.eINSTANCE.createServers();
		return servers;
	}

	public void loadServers() {
		final IWorkspaceRoot workspaceRoot = ResourcesPlugin.getWorkspace().getRoot();
		Bundle bundle = Platform.getBundle(Activator.BUNDLE_ID);
		File serversFile = bundle.getBundleContext().getDataFile(MODEL_FILE_NAME);
		if (serversFile.exists()) {
			ResourceSet resSet = new ResourceSetImpl();
			Resource resource = resSet.getResource(URI.createFileURI(serversFile.getPath()), true);
			servers = (Servers) resource.getContents().get(0);
			for (HDFSServer server : servers.getHdfsServers()) {
				uriToServerMap.put(server.getUri(), server);
				final IProject project = workspaceRoot.getProject(server.getName());
				if (!project.exists()) {
					server.setStatusCode(ServerStatus.NO_PROJECT_VALUE);
				}
				serverToProjectMap.put(server, server.getName());
				projectToServerMap.put(server.getName(), server);
			}
		}
		IProject[] projects = workspaceRoot.getProjects();
		if (projects != null) {
			for (IProject p : projects) {
				if (p.getLocationURI() != null && HDFSFileSystem.SCHEME.equals(p.getLocationURI().getScheme())) {
					if (!projectToServerMap.keySet().contains(p)) {
						logger.error("HDFS project with no server associated being closed:" + p.getName());
						try {
							p.close(new NullProgressMonitor());
							logger.error("HDFS project with no server associated closed:" + p.getName());
						} catch (CoreException e) {
							logger.error("HDFS project with no server associated cannot be closed:" + p.getName(), e);
						}
					}
				}
			}
		}
	}

	public void saveServers() {
		Bundle bundle = Platform.getBundle(Activator.BUNDLE_ID);
		File serversFile = bundle.getBundleContext().getDataFile(MODEL_FILE_NAME);
		ResourceSet resSet = new ResourceSetImpl();
		Resource resource = resSet.createResource(URI.createFileURI(serversFile.getPath()));
		resource.getContents().add(getServers());
		try {
			resource.save(Collections.EMPTY_MAP);
		} catch (IOException e) {
			logger.error("Unable to persist Hadoop servers model", e);
		}
	}

	/**
	 * Creates and adds an HDFS server definition. This also creates a local
	 * project which represents server file system via EFS.
	 * 
	 * @param hdfsURI
	 * @return
	 * @throws CoreException
	 */
	public HDFSServer createServer(String name, java.net.URI hdfsURI) throws CoreException {
		if (hdfsURI.getPath().length() < 1) {
			try {
				hdfsURI = new java.net.URI(hdfsURI.toString() + "/");
			} catch (URISyntaxException e) {
			}
		}

		HDFSServer hdfsServer = HadoopFactory.eINSTANCE.createHDFSServer();
		hdfsServer.setName(name);
		hdfsServer.setUri(hdfsURI.toString());
		hdfsServer.setLoaded(true);
		hdfsServer.setWorkspaceProjectName(name);
		getServers().getHdfsServers().add(hdfsServer);
		saveServers();
		uriToServerMap.put(hdfsServer.getUri(), hdfsServer);
		serverToProjectMap.put(hdfsServer, name);
		projectToServerMap.put(name, hdfsServer);
		createIProject(name, hdfsURI);
		return hdfsServer;
	}

	/**
	 * @param name
	 * @param hdfsURI
	 * @return
	 * @throws CoreException
	 */
	private IProject createIProject(String name, java.net.URI hdfsURI) throws CoreException {
		final IWorkspace workspace = ResourcesPlugin.getWorkspace();
		IProject project = workspace.getRoot().getProject(name);
		IProjectDescription pd = workspace.newProjectDescription(name);
		pd.setLocationURI(hdfsURI);
		project.create(pd, new NullProgressMonitor());
		project.open(new NullProgressMonitor());
		return project;
	}

	public HDFSServer getServer(String uri) {
		if (!uriToServerCacheMap.containsKey(uri)) {
			String tmpUri = uri;
			HDFSServer serverU = uriToServerMap.get(tmpUri);
			while (serverU == null) {
				int lastSlashIndex = tmpUri.lastIndexOf('/');
				tmpUri = lastSlashIndex < 0 ? null : tmpUri.substring(0, lastSlashIndex);
				if (tmpUri != null)
					serverU = uriToServerMap.get(tmpUri + "/");
				else
					break;
			}
			if (serverU != null)
				uriToServerCacheMap.put(uri, serverU);
		}
		return uriToServerCacheMap.get(uri);
	}

	public String getProjectName(HDFSServer server) {
		return serverToProjectMap.get(server);
	}

	/**
	 * @param string
	 */
	public void startServerOperation(String uri) {
		serverOperationURIs.add(uri);
	}

	/**
	 * @param string
	 */
	public void stopServerOperation(String uri) {
		serverOperationURIs.remove(uri);
	}

	public boolean isServerOperationRunning(String uri) {
		return serverOperationURIs.contains(uri);
	}

	/**
	 * @param server
	 */
	public void deleteServer(HDFSServer server) {
		getServers().getHdfsServers().remove(server);
		String projectName = this.serverToProjectMap.remove(server);
		this.projectToServerMap.remove(projectName);
		this.uriToServerMap.remove(server.getUri());
		saveServers();
	}
}
