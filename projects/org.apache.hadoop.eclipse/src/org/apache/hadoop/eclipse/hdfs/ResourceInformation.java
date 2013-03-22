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

public class ResourceInformation{
	private String name;
	private String path;
	private long lastModifiedTime;
	private long lastAccessedTime;
	private boolean isFolder;
	private long size;
	private short replicationFactor;
	private String owner;
	private String group;
	
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the lastModifiedTime
	 */
	public long getLastModifiedTime() {
		return lastModifiedTime;
	}
	/**
	 * @param lastModifiedTime the lastModifiedTime to set
	 */
	public void setLastModifiedTime(long lastModifiedTime) {
		this.lastModifiedTime = lastModifiedTime;
	}
	/**
	 * @return the lastAccessedTime
	 */
	public long getLastAccessedTime() {
		return lastAccessedTime;
	}
	/**
	 * @param lastAccessedTime the lastAccessedTime to set
	 */
	public void setLastAccessedTime(long lastAccessedTime) {
		this.lastAccessedTime = lastAccessedTime;
	}
	/**
	 * @return the isFolder
	 */
	public boolean isFolder() {
		return isFolder;
	}
	/**
	 * @param isFolder the isFolder to set
	 */
	public void setFolder(boolean isFolder) {
		this.isFolder = isFolder;
	}
	public void setSize(long size) {
		this.size = size;
	}
	public long getSize() {
		return size;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getPath() {
		return path;
	}
	public void setReplicationFactor(short replicationFactor) {
		this.replicationFactor = replicationFactor;
	}
	public short getReplicationFactor() {
		return replicationFactor;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public String getOwner() {
		return owner;
	}
	public void setGroup(String group) {
		this.group = group;
	}
	public String getGroup() {
		return group;
	}
}