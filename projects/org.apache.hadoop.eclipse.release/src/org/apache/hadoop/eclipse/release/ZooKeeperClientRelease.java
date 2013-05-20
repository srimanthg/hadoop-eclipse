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
package org.apache.hadoop.eclipse.release;

import java.io.IOException;
import java.util.List;

import org.apache.hadoop.eclipse.zookeeper.ZooKeeperClient;
import org.apache.log4j.Logger;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.ZooKeeper.States;

/**
 * @author Srimanth Gunturi
 * 
 */
public class ZooKeeperClientRelease extends ZooKeeperClient {

	private static final Logger logger = Logger.getLogger(ZooKeeperClientRelease.class);
	private ZooKeeper client = null;
	private String serverLocation;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.apache.hadoop.eclipse.zookeeper.ZooKeeperClient#initialize(java.lang
	 * .String)
	 */
	@Override
	public void initialize(String serverLocation) {
		this.serverLocation = serverLocation;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.apache.hadoop.eclipse.zookeeper.ZooKeeperClient#isConnected()
	 */
	@Override
	public boolean isConnected() throws IOException, InterruptedException {
		if (client != null) {
			if (logger.isDebugEnabled())
				logger.debug("isConnected(" + serverLocation + "): Client state = " + client.getState());
			return client.getState() == States.CONNECTED;
		}
		return false;
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
		if (client == null) {
			if (logger.isDebugEnabled())
				logger.debug("connect(" + serverLocation + "): Connecting begin");
			client = new ZooKeeper(serverLocation, 5000, new Watcher() {
				@Override
				public void process(WatchedEvent event) {
				}
			});
			int waitCount = 0;
			while (client.getState() == States.CONNECTING && waitCount++ < 5) {
				if (logger.isDebugEnabled())
					logger.debug("connect(" + serverLocation + "): Still connecting... sleep for 1s");
				Thread.sleep(1000);
			}
			if (logger.isDebugEnabled())
				logger.debug("connect(" + serverLocation + "): Connecting finish with state: " + client.getState());
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.apache.hadoop.eclipse.zookeeper.ZooKeeperClient#disconnect()
	 */
	@Override
	public void disconnect() throws IOException, InterruptedException {
		if (client != null) {
			client.close();
			client = null;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.apache.hadoop.eclipse.zookeeper.ZooKeeperClient#getChildren(java.
	 * lang.String)
	 */
	@Override
	public List<String> getChildren(String path) throws IOException, InterruptedException {
		try {
			return client.getChildren(path, false);
		} catch (KeeperException e) {
			logger.debug(e.getMessage(), e);
			throw new IOException(e.getMessage(), e);
		}
	}

}
