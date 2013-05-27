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
import java.util.ArrayList;
import java.util.List;

import org.apache.hadoop.eclipse.internal.model.HadoopFactory;
import org.apache.hadoop.eclipse.internal.model.ZNode;
import org.apache.hadoop.eclipse.internal.model.ZNodeType;
import org.apache.hadoop.eclipse.zookeeper.ZooKeeperClient;
import org.apache.log4j.Logger;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.ZooKeeper.States;
import org.apache.zookeeper.data.Stat;

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
		if (logger.isDebugEnabled())
			logger.debug("initialize(" + serverLocation + ")");
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
		if (logger.isDebugEnabled())
			logger.debug("disconnect(" + serverLocation + ")");
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
	public List<ZNode> getChildren(ZNode node) throws IOException, InterruptedException {
		if (logger.isDebugEnabled())
			logger.debug("getChildren(" + node.getPath() + ")");
		List<ZNode> childNodes = new ArrayList<ZNode>();
		try {
			Stat nodeStat = new Stat();
			List<String> children = client.getChildren(node.getPath(), false, nodeStat);
			copyFromStat(nodeStat, node);

			if (children != null) {
				for (String child : children) {
					ZNode cNode = HadoopFactory.eINSTANCE.createZNode();
					cNode.setNodeName(child);
					cNode.setParent(node);
					Stat exists = client.exists(cNode.getPath(), false);
					if (exists != null) {
						copyFromStat(exists, cNode);
						childNodes.add(cNode);
					}
				}
			}
		} catch (KeeperException e) {
			logger.debug(e.getMessage(), e);
			throw new IOException(e.getMessage(), e);
		}
		if (logger.isDebugEnabled())
			logger.debug("getChildren(" + node.getPath() + "): ChildCount="+childNodes.size());
		return childNodes;
	}

	/**
	 * @param nodeStat
	 * @param node
	 */
	private void copyFromStat(Stat nodeStat, ZNode node) {
		node.setAclVersion(nodeStat.getAversion());
		node.setChildrenCount(nodeStat.getNumChildren());
		node.setChildrenVersion(nodeStat.getCversion());
		node.setCreationId(nodeStat.getCzxid());
		node.setCreationTime(nodeStat.getCtime());
		node.setDataLength(nodeStat.getDataLength());
		node.setEphermalOwnerSessionId(nodeStat.getEphemeralOwner());
		node.setLastRefresh(System.currentTimeMillis());
		node.setModifiedId(nodeStat.getMzxid());
		node.setModifiedTime(nodeStat.getMtime());
		node.setVersion(nodeStat.getVersion());
		if (nodeStat.getEphemeralOwner() > 0)
			node.setEphermeral(true);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.apache.hadoop.eclipse.zookeeper.ZooKeeperClient#delete(org.apache
	 * .hadoop.eclipse.internal.zookeeper.ZooKeeperNode)
	 */
	@Override
	public void delete(ZNode zkn) throws IOException, InterruptedException {
		if(logger.isDebugEnabled())
			logger.debug("delete("+zkn.getPath()+")");
		try {
			client.delete(zkn.getPath(), -1);
		} catch (KeeperException e) {
			throw new IOException(e.getMessage(), e);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.apache.hadoop.eclipse.zookeeper.ZooKeeperClient#open(java.lang.String
	 * )
	 */
	@Override
	public byte[] open(ZNode node) throws InterruptedException, IOException {
		if(logger.isDebugEnabled())
			logger.debug("open("+node.getPath()+")");
		Stat stat = new Stat();
		byte[] nd;
		try {
			nd = client.getData(node.getPath(), false, stat);
		} catch (KeeperException e) {
			throw new IOException(e.getMessage(), e);
		}
		return nd;
	}

}
