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

package org.apache.hadoop.eclipse.internal.zookeeper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.hadoop.eclipse.internal.model.ZooKeeperServer;
import org.apache.hadoop.eclipse.zookeeper.ZooKeeperClient;
import org.apache.log4j.Logger;

/**
 * 
 * @author Srimanth Gunturi
 * 
 */
public class InterruptableZooKeeperClient extends ZooKeeperClient {
	private static final int DEFAULT_TIMEOUT = 5000;
	private static final Logger logger = Logger.getLogger(InterruptableZooKeeperClient.class);
	// private static ExecutorService threadPool =
	// Executors.newFixedThreadPool(10);

	private final ZooKeeperClient client;
	private final int timeoutMillis = DEFAULT_TIMEOUT;
	private final ZooKeeperServer server;

	/**
	 * @param server
	 * 
	 */
	public InterruptableZooKeeperClient(ZooKeeperServer server, ZooKeeperClient client) {
		this.server = server;
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
			if (logger.isDebugEnabled())
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
			if (logger.isDebugEnabled())
				logger.debug("executeWithTimeout(): Server timed out: " + server);
			ZooKeeperManager.INSTANCE.disconnect(server);
			throw new InterruptedException();
		}
		if (data.size() > 0)
			return data.get(0);
		return null;
	}
	
	protected void connectIfNecessary() throws IOException, InterruptedException{
		if(!client.isConnected())
			client.connect();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.apache.hadoop.eclipse.zookeeper.ZooKeeperClient#initialize(java.lang
	 * .String)
	 */
	@Override
	public void initialize(final String serverLocation) {
		try {
			executeWithTimeout(new CustomRunnable<Object>() {
				@Override
				public Object run() throws IOException, InterruptedException {
					client.initialize(serverLocation);
					return null;
				}
			});
		} catch (IOException e) {
			throw new RuntimeException(e.getMessage(), e);
		} catch (InterruptedException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.apache.hadoop.eclipse.zookeeper.ZooKeeperClient#isConnected()
	 */
	@Override
	public boolean isConnected() throws IOException, InterruptedException {
		return executeWithTimeout(new CustomRunnable<Boolean>() {
			@Override
			public Boolean run() throws IOException, InterruptedException {
				return client.isConnected();
			}
		});
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.apache.hadoop.eclipse.zookeeper.ZooKeeperClient#connect(java.lang
	 * .String)
	 */
	@Override
	public void connect() throws IOException, InterruptedException {
		executeWithTimeout(new CustomRunnable<Object>() {
			@Override
			public Object run() throws IOException, InterruptedException {
				client.connect();
				return null;
			}
		});
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.apache.hadoop.eclipse.zookeeper.ZooKeeperClient#getChildren(java.
	 * lang.String)
	 */
	@Override
	public List<String> getChildren(final String path) throws IOException, InterruptedException {
		connectIfNecessary();
		return executeWithTimeout(new CustomRunnable<List<String>>() {
			@Override
			public List<String> run() throws IOException, InterruptedException {
				return client.getChildren(path);
			}
		});
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.apache.hadoop.eclipse.zookeeper.ZooKeeperClient#disconnect()
	 */
	@Override
	public void disconnect() throws IOException, InterruptedException {
		executeWithTimeout(new CustomRunnable<Object>() {
			@Override
			public Object run() throws IOException, InterruptedException {
				client.disconnect();
				return null;
			}
		});
	}
}
