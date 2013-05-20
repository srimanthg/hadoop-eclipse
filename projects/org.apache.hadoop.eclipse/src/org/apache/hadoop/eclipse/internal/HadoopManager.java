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

package org.apache.hadoop.eclipse.internal;

import java.io.File;
import java.io.IOException;
import java.util.Collections;

import org.apache.hadoop.eclipse.Activator;
import org.apache.hadoop.eclipse.internal.hdfs.HDFSManager;
import org.apache.hadoop.eclipse.internal.model.HadoopFactory;
import org.apache.hadoop.eclipse.internal.model.Servers;
import org.apache.hadoop.eclipse.internal.zookeeper.ZooKeeperManager;
import org.apache.log4j.Logger;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.osgi.framework.Bundle;

/**
 * @author Srimanth Gunturi
 * 
 */
public class HadoopManager {
	private static final Logger logger = Logger.getLogger(HadoopManager.class);
	private static final String MODEL_FILE_NAME = "servers.xmi";
	public static HadoopManager INSTANCE = new HadoopManager();

	private Servers servers = null;

	private HadoopManager() {
	}

	public Servers getServers() {
		if (servers == null) {
			loadServers();
			if (servers == null) {
				Bundle bundle = Platform.getBundle(Activator.BUNDLE_ID);
				File serversFile = bundle.getBundleContext().getDataFile(MODEL_FILE_NAME);
				Resource resource = new ResourceSetImpl().createResource(URI.createFileURI(serversFile.getPath()));
				servers = HadoopFactory.eINSTANCE.createServers();
				resource.getContents().add(servers);
			}
		}
		return servers;
	}

	private void loadServers() {
		Bundle bundle = Platform.getBundle(Activator.BUNDLE_ID);
		File serversFile = bundle.getBundleContext().getDataFile(MODEL_FILE_NAME);
		if (serversFile.exists()) {
			Resource resource = new ResourceSetImpl().getResource(URI.createFileURI(serversFile.getPath()), true);
			servers = (Servers) resource.getContents().get(0);
			HDFSManager.INSTANCE.loadServers();
			ZooKeeperManager.INSTANCE.loadServers();
		}
	}

	public void saveServers() {
		try {
			servers.eResource().save(Collections.EMPTY_MAP);
		} catch (IOException e) {
			logger.error("Unable to persist Hadoop servers model", e);
		}
	}
}
