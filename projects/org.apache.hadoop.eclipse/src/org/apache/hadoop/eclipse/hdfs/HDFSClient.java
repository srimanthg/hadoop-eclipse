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

package org.apache.hadoop.eclipse.hdfs;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.util.List;

/**
 * 
 * @author Srimanth Gunturi
 */
public abstract class HDFSClient {
	/**
	 * Provides the default userId and groupIds.
	 * 
	 * @return List of ids. First ID has to be of the user. Group IDs are
	 *         optional.
	 * @throws IOException
	 * @throws InterruptedException 
	 */
	public abstract List<String> getDefaultUserAndGroupIds() throws IOException, InterruptedException;

	/**
	 * 
	 * @param uri
	 * @param user
	 * @return
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public abstract ResourceInformation getResourceInformation(URI uri, String user) throws IOException, InterruptedException;

	/**
	 * 
	 * @param uri
	 * @param information
	 * @param user
	 * @throws IOException
	 * @throws InterruptedException 
	 */
	public abstract void setResourceInformation(URI uri, ResourceInformation information, String user) throws IOException, InterruptedException;

	/**
	 * 
	 * @param uri
	 * @param user
	 * @return
	 * @throws IOException
	 * @throws InterruptedException 
	 */
	public abstract List<ResourceInformation> listResources(URI uri, String user) throws IOException, InterruptedException;

	/**
	 * @param uri
	 * @param user
	 * @return
	 * @throws InterruptedException 
	 */
	public abstract InputStream openInputStream(URI uri, String user) throws IOException, InterruptedException;

	/**
	 * 
	 * @param uri
	 * @param user
	 * @return
	 * @throws IOException
	 * @throws InterruptedException 
	 */
	public abstract boolean mkdirs(URI uri, String user) throws IOException, InterruptedException;

	/**
	 * @param uri
	 * @param user
	 * @return
	 * @throws IOException
	 * @throws InterruptedException 
	 */
	public abstract OutputStream openOutputStream(URI uri, String user) throws IOException, InterruptedException;

	/**
	 * @param uri
	 * @param monitor
	 * @return
	 * @throws IOException
	 * @throws InterruptedException 
	 */
	public abstract OutputStream createOutputStream(URI uri, String user) throws IOException, InterruptedException;

	/**
	 * @param uri
	 * @param user
	 * @throws InterruptedException 
	 */
	public abstract void delete(URI uri, String user) throws IOException, InterruptedException;
}
