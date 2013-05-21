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
import java.util.HashMap;
import java.util.Map;

import org.apache.hadoop.eclipse.Activator;
import org.apache.hadoop.eclipse.internal.HadoopManager;
import org.apache.hadoop.eclipse.internal.model.HadoopFactory;
import org.apache.hadoop.eclipse.internal.model.ServerStatus;
import org.apache.hadoop.eclipse.internal.model.ZooKeeperServer;
import org.apache.hadoop.eclipse.zookeeper.ZooKeeperClient;
import org.apache.log4j.Logger;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.EList;

/**
 * @author Srimanth Gunturi
 * 
 */
public class ZooKeeperManager {
	private static final Logger logger = Logger.getLogger(ZooKeeperManager.class);
	public static ZooKeeperManager INSTANCE = new ZooKeeperManager();
	private Map<String, ZooKeeperClient> clientsMap = new HashMap<String, ZooKeeperClient>();

	private ZooKeeperManager() {
	}

	/**
	 * 
	 */
	public void loadServers() {

	}

	public EList<ZooKeeperServer> getServers() {
		return HadoopManager.INSTANCE.getServers().getZookeeperServers();
	}

	/**
	 * @param zkServerName
	 * @param uri
	 */
	public ZooKeeperServer createServer(String zkServerName, String zkServerLocation) {
		ZooKeeperServer zkServer = HadoopFactory.eINSTANCE.createZooKeeperServer();
		zkServer.setName(zkServerName);
		zkServer.setUri(zkServerLocation);
		getServers().add(zkServer);
		HadoopManager.INSTANCE.saveServers();
		return zkServer;
	}

	/**
	 * @param r
	 */
	public void disconnect(ZooKeeperServer server) {
		try {
			if (ServerStatus.DISCONNECTED_VALUE != server.getStatusCode()) {
				getClient(server).disconnect();
				server.setStatusCode(ServerStatus.DISCONNECTED_VALUE);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (CoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Provides a ZooKeeper instance using plugin extensions.
	 * 
	 * @param r
	 */
	public void reconnect(ZooKeeperServer server) {
		try {
			if (logger.isDebugEnabled())
				logger.debug("reconnect(): Reconnecting: " + server);
			server.setStatusCode(0);
			getClient(server).connect();
			if (!getClient(server).isConnected()) {
				if (logger.isDebugEnabled())
					logger.debug("reconnect(): Client not connected. Setting to disconnected: " + server);
				server.setStatusCode(ServerStatus.DISCONNECTED_VALUE);
			}
			if (logger.isDebugEnabled())
				logger.debug("reconnect(): Reconnected: " + server);
		} catch (IOException e) {
			server.setStatusCode(ServerStatus.DISCONNECTED_VALUE);
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			server.setStatusCode(ServerStatus.DISCONNECTED_VALUE);
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (CoreException e) {
			server.setStatusCode(ServerStatus.DISCONNECTED_VALUE);
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public ZooKeeperClient getClient(ZooKeeperServer server) throws CoreException {
		if (server != null && server.getStatusCode() == ServerStatus.DISCONNECTED_VALUE) {
			if (logger.isDebugEnabled())
				logger.debug("getClient(" + server.getUri() + "): Server disconnected. Not returning client");
			throw new CoreException(new Status(IStatus.WARNING, Activator.BUNDLE_ID, "Server disconnected. Please reconnect to server."));
		}
		if (clientsMap.containsKey(server.getUri()))
			return clientsMap.get(server.getUri());
		else {
			IConfigurationElement[] elementsFor = Platform.getExtensionRegistry().getConfigurationElementsFor("org.apache.hadoop.eclipse.zookeeperClient");
			for (IConfigurationElement element : elementsFor) {
				ZooKeeperClient client = (ZooKeeperClient) element.createExecutableExtension("class");
				client.initialize(server.getUri());
				clientsMap.put(server.getUri(), new InterruptableZooKeeperClient(server, client));
			}
			return clientsMap.get(server.getUri());
		}
	}

	/**
	 * @param r
	 * @throws CoreException
	 */
	public void delete(ZooKeeperServer server) throws CoreException {
		if (server != null && server.getStatusCode() != ServerStatus.DISCONNECTED_VALUE) {
			if (logger.isDebugEnabled())
				logger.debug("getClient(" + server.getUri() + "): Cannot delete a connected server.");
			throw new CoreException(new Status(IStatus.WARNING, Activator.BUNDLE_ID, "Cannot delete a connected server."));
		}
		if (clientsMap.containsKey(server.getUri()))
			clientsMap.remove(server.getUri());
		getServers().remove(server);
	}
}
