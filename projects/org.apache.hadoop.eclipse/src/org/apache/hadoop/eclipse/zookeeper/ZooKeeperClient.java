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

package org.apache.hadoop.eclipse.zookeeper;

import java.io.IOException;
import java.util.List;

import org.apache.hadoop.eclipse.internal.zookeeper.ZooKeeperNode;

/**
 * @author Srimanth Gunturi
 * 
 */
public abstract class ZooKeeperClient {

	public static class NodeInfo {
		public int version;
		public int childrenVersion;
	}

	public static class NodeData extends NodeInfo {
		public byte[] data;
	}

	public abstract void initialize(String serverLocation);

	public abstract boolean isConnected() throws IOException, InterruptedException;

	public abstract void connect() throws IOException, InterruptedException;

	public abstract List<String> getChildren(String path) throws IOException, InterruptedException;

	public abstract void disconnect() throws IOException, InterruptedException;

	public abstract void delete(ZooKeeperNode zkn) throws IOException, InterruptedException;

	public abstract NodeData open(String path) throws InterruptedException, IOException;
}
