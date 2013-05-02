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

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.apache.hadoop.eclipse.hdfs.HDFSClient;
import org.apache.hadoop.eclipse.hdfs.ResourceInformation;
import org.apache.hadoop.eclipse.internal.model.HDFSServer;
import org.apache.hadoop.eclipse.internal.model.ServerStatus;
import org.apache.log4j.Logger;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;

/**
 * 
 * @author Srimanth Gunturi
 * 
 */
public class InterruptableHDFSClient extends HDFSClient {
	private static final int DEFAULT_TIMEOUT = 5000;
	private static final Logger logger = Logger.getLogger(InterruptableHDFSClient.class);
	// private static ExecutorService threadPool =
	// Executors.newFixedThreadPool(10);

	private final HDFSClient client;
	private final int timeoutMillis = DEFAULT_TIMEOUT;
	private final String serverURI;

	/**
	 * @param serverURI
	 * 
	 */
	public InterruptableHDFSClient(String serverURI, HDFSClient client) {
		this.serverURI = serverURI;
		this.client = client;
	}

	private static interface CustomRunnable<V> {
		public V run() throws IOException, InterruptedException;
	}

	protected <T> T executeWithTimeout(final CustomRunnable<T> runnable) throws IOException, InterruptedException {
		final List<T> data = new ArrayList<T>();
		final IOException[] ioE = new IOException[1];
		final InterruptedException[] inE = new InterruptedException[1];
		Thread runnerThread = new Thread(new Runnable() {
			public void run() {
				try {
					data.add(runnable.run());
				} catch (IOException e) {
					ioE[0] = e;
				} catch (InterruptedException e) {
					inE[0] = e;
				}
			}
		});
		boolean interrupted = false;
		runnerThread.start();
		runnerThread.join(timeoutMillis);
		if (runnerThread.isAlive()) {
			if(logger.isDebugEnabled())
				logger.debug("executeWithTimeout(): Interrupting server call");
			runnerThread.interrupt();
			interrupted = true;
		}
		if (ioE[0] != null)
			throw ioE[0];
		if (inE[0] != null)
			throw inE[0];
		if (interrupted) {
			// Tell HDFS manager that the server timed out
			if(logger.isDebugEnabled())
				logger.debug("executeWithTimeout(): Server timed out: "+serverURI);
			HDFSServer server = HDFSManager.INSTANCE.getServer(serverURI);
			String projectName = HDFSManager.INSTANCE.getProjectName(server);
			IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(projectName);
			HDFSManager.disconnectProject(project);
			throw new InterruptedException();
		}
		if (data.size() > 0)
			return data.get(0);
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.apache.hadoop.eclipse.hdfs.HDFSClient#getDefaultUserAndGroupIds()
	 */
	@Override
	public List<String> getDefaultUserAndGroupIds() throws IOException, InterruptedException {
		return executeWithTimeout(new CustomRunnable<List<String>>() {
			@Override
			public List<String> run() throws IOException, InterruptedException {
				return client.getDefaultUserAndGroupIds();
			}
		});
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.apache.hadoop.eclipse.hdfs.HDFSClient#getResourceInformation(java
	 * .net.URI, java.lang.String)
	 */
	@Override
	public ResourceInformation getResourceInformation(final URI uri, final String user) throws IOException, InterruptedException {
		return executeWithTimeout(new CustomRunnable<ResourceInformation>() {
			@Override
			public ResourceInformation run() throws IOException, InterruptedException {
				return client.getResourceInformation(uri, user);
			}
		});
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.apache.hadoop.eclipse.hdfs.HDFSClient#setResourceInformation(java
	 * .net.URI, org.apache.hadoop.eclipse.hdfs.ResourceInformation,
	 * java.lang.String)
	 */
	@Override
	public void setResourceInformation(final URI uri, final ResourceInformation information, final String user) throws IOException, InterruptedException {
		executeWithTimeout(new CustomRunnable<Object>() {
			@Override
			public Object run() throws IOException, InterruptedException {
				client.setResourceInformation(uri, information, user);
				return null;
			}
		});
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.apache.hadoop.eclipse.hdfs.HDFSClient#listResources(java.net.URI,
	 * java.lang.String)
	 */
	@Override
	public List<ResourceInformation> listResources(final URI uri, final String user) throws IOException, InterruptedException {
		return executeWithTimeout(new CustomRunnable<List<ResourceInformation>>() {
			@Override
			public List<ResourceInformation> run() throws IOException, InterruptedException {
				return client.listResources(uri, user);
			}
		});
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.apache.hadoop.eclipse.hdfs.HDFSClient#openInputStream(java.net.URI,
	 * java.lang.String)
	 */
	@Override
	public InputStream openInputStream(final URI uri, final String user) throws IOException, InterruptedException {
		return executeWithTimeout(new CustomRunnable<InputStream>() {
			@Override
			public InputStream run() throws IOException, InterruptedException {
				return client.openInputStream(uri, user);
			}
		});
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.apache.hadoop.eclipse.hdfs.HDFSClient#mkdirs(java.net.URI,
	 * java.lang.String)
	 */
	@Override
	public boolean mkdirs(final URI uri, final String user) throws IOException, InterruptedException {
		return executeWithTimeout(new CustomRunnable<Boolean>() {
			@Override
			public Boolean run() throws IOException, InterruptedException {
				return client.mkdirs(uri, user);
			}
		});
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.apache.hadoop.eclipse.hdfs.HDFSClient#openOutputStream(java.net.URI,
	 * java.lang.String)
	 */
	@Override
	public OutputStream openOutputStream(final URI uri, final String user) throws IOException, InterruptedException {
		return executeWithTimeout(new CustomRunnable<OutputStream>() {
			@Override
			public OutputStream run() throws IOException, InterruptedException {
				return client.openOutputStream(uri, user);
			}
		});
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.apache.hadoop.eclipse.hdfs.HDFSClient#createOutputStream(java.net
	 * .URI, java.lang.String)
	 */
	@Override
	public OutputStream createOutputStream(final URI uri, final String user) throws IOException, InterruptedException {
		return executeWithTimeout(new CustomRunnable<OutputStream>() {
			@Override
			public OutputStream run() throws IOException, InterruptedException {
				return client.openOutputStream(uri, user);
			}
		});
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.apache.hadoop.eclipse.hdfs.HDFSClient#delete(java.net.URI,
	 * java.lang.String)
	 */
	@Override
	public void delete(final URI uri, final String user) throws IOException, InterruptedException {
		executeWithTimeout(new CustomRunnable<Object>() {
			@Override
			public Object run() throws IOException, InterruptedException {
				client.delete(uri, user);
				return null;
			}
		});
	}

}
