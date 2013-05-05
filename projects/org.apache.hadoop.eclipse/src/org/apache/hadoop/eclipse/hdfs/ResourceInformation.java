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

import java.util.List;

public class ResourceInformation {
	public static class Permissions {
		public boolean read = true;
		public boolean write = true;
		public boolean execute = true;

		public Permissions() {
		}

		public Permissions(boolean read, boolean write, boolean execute) {
			this.read = read;
			this.write = write;
			this.execute = execute;
		}

		public void copy(Permissions copyFrom) {
			this.read = copyFrom.read;
			this.write = copyFrom.write;
			this.execute = copyFrom.execute;
		}
	}

	private String name;
	private String path;
	private long lastModifiedTime = -1;
	private long lastAccessedTime = -1;
	private boolean isFolder;
	private long size;
	private short replicationFactor;
	private String owner;
	private String group;
	private Permissions userPermissions = new Permissions();
	private Permissions groupPermissions = new Permissions();
	private Permissions otherPermissions = new Permissions();
	private Permissions effectivePermissions = new Permissions();

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
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
	 * @param lastModifiedTime
	 *            the lastModifiedTime to set
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
	 * @param lastAccessedTime
	 *            the lastAccessedTime to set
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
	 * @param isFolder
	 *            the isFolder to set
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

	public void setUserPermissions(Permissions userPermissions) {
		this.userPermissions = userPermissions;
	}

	public Permissions getUserPermissions() {
		return userPermissions;
	}

	public void setGroupPermissions(Permissions groupPermissions) {
		this.groupPermissions = groupPermissions;
	}

	public Permissions getGroupPermissions() {
		return groupPermissions;
	}

	public void setOtherPermissions(Permissions otherPermissions) {
		this.otherPermissions = otherPermissions;
	}

	public Permissions getOtherPermissions() {
		return otherPermissions;
	}

	/**
	 * Effective permissions of this resource for the caller.
	 * 
	 * @return {@link Permissions}
	 */
	public Permissions getEffectivePermissions() {
		return effectivePermissions;
	}

	/**
	 * Updates the effective permissions for the provided user and groups. This
	 * updates {@link #isRead()}, {@link #isWrite()} and {@link #isExecute()}
	 * 
	 * @param user
	 * @param groups
	 */
	public void updateEffectivePermissions(String user, List<String> groups) {
		if (user != null) {
			if (getOwner().equals(user)) {
				// Owner permissions apply
				this.effectivePermissions.copy(this.userPermissions);
			} else if (groups!=null && groups.contains(getGroup())) {
				// Group permissions apply
				this.effectivePermissions.copy(this.groupPermissions);
			} else {
				// Other permissions apply
				this.effectivePermissions.copy(this.otherPermissions);
			}
		}
	}
}