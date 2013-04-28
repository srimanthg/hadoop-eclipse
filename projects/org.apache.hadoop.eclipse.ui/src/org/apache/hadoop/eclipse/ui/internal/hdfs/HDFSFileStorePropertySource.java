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
package org.apache.hadoop.eclipse.ui.internal.hdfs;

import java.util.ArrayList;
import java.util.List;

import org.apache.hadoop.eclipse.internal.hdfs.HDFSFileStore;
import org.eclipse.core.filesystem.EFS;
import org.eclipse.ui.views.properties.IPropertyDescriptor;
import org.eclipse.ui.views.properties.IPropertySource;
import org.eclipse.ui.views.properties.PropertyDescriptor;

/**
 * @author Srimanth Gunturi
 * 
 */
public class HDFSFileStorePropertySource implements IPropertySource {

	private enum Property {
		USER, GROUP, ISLOCAL,
		PERMISSIONS, USER_PERMISSIONS, 
		GROUP_PERMISSIONS, OTHER_PERMISSIONS,
	}

	private final HDFSFileStore fileStore;

	/**
	 * @param fs
	 */
	public HDFSFileStorePropertySource(HDFSFileStore fileStore) {
		this.fileStore = fileStore;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.views.properties.IPropertySource#getEditableValue()
	 */
	@Override
	public Object getEditableValue() {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ui.views.properties.IPropertySource#getPropertyDescriptors()
	 */
	@Override
	public IPropertyDescriptor[] getPropertyDescriptors() {
		List<IPropertyDescriptor> descriptors = new ArrayList<IPropertyDescriptor>();
		final PropertyDescriptor user = new PropertyDescriptor(Property.USER, "User");
		final PropertyDescriptor group = new PropertyDescriptor(Property.GROUP, "Group");
		final PropertyDescriptor isDownloaded = new PropertyDescriptor(Property.ISLOCAL, "Is downloaded");
		final PropertyDescriptor perms = new PropertyDescriptor(Property.PERMISSIONS, "Effective Permissions");
		final PropertyDescriptor userPerms = new PropertyDescriptor(Property.USER_PERMISSIONS, "User Permissions");
		final PropertyDescriptor groupPerms = new PropertyDescriptor(Property.GROUP_PERMISSIONS, "Group Permissions");
		final PropertyDescriptor otherPerms = new PropertyDescriptor(Property.OTHER_PERMISSIONS, "Other Permissions");
		descriptors.add(user);
		descriptors.add(group);
		descriptors.add(isDownloaded);
		descriptors.add(perms);
		descriptors.add(userPerms);
		descriptors.add(groupPerms);
		descriptors.add(otherPerms);
		return descriptors.toArray(new IPropertyDescriptor[descriptors.size()]);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ui.views.properties.IPropertySource#getPropertyValue(java
	 * .lang.Object)
	 */
	@Override
	public Object getPropertyValue(Object id) {
		if (Property.USER.equals(id))
			return this.fileStore.getServerResourceInfo() == null ? null : fileStore.getServerResourceInfo().getOwner();
		else if (Property.GROUP.equals(id))
			return this.fileStore.getServerResourceInfo() == null ? null : fileStore.getServerResourceInfo().getGroup();
		else if (Property.ISLOCAL.equals(id))
			return this.fileStore.isLocalFile();
		else if (Property.PERMISSIONS.equals(id)){
			String perms = "";
			perms += this.fileStore.getEffectivePermissions().read ? "r" : "-";
			perms += this.fileStore.getEffectivePermissions().write ? "w" : "-";
			perms += this.fileStore.getEffectivePermissions().execute ? "x" : "-";
			return perms;
		} else if (Property.USER_PERMISSIONS.equals(id)){
			String perms = "";
			perms += this.fileStore.fetchInfo().getAttribute(EFS.ATTRIBUTE_OWNER_READ) ? "r" : "-";
			perms += this.fileStore.fetchInfo().getAttribute(EFS.ATTRIBUTE_OWNER_WRITE) ? "w" : "-";
			perms += this.fileStore.fetchInfo().getAttribute(EFS.ATTRIBUTE_OWNER_EXECUTE) ? "x" : "-";
			return perms;
		} else if (Property.GROUP_PERMISSIONS.equals(id)){
			String perms = "";
			perms += this.fileStore.fetchInfo().getAttribute(EFS.ATTRIBUTE_GROUP_READ) ? "r" : "-";
			perms += this.fileStore.fetchInfo().getAttribute(EFS.ATTRIBUTE_GROUP_WRITE) ? "w" : "-";
			perms += this.fileStore.fetchInfo().getAttribute(EFS.ATTRIBUTE_GROUP_EXECUTE) ? "x" : "-";
			return perms;
		} else if (Property.OTHER_PERMISSIONS.equals(id)){
			String perms = "";
			perms += this.fileStore.fetchInfo().getAttribute(EFS.ATTRIBUTE_OTHER_READ) ? "r" : "-";
			perms += this.fileStore.fetchInfo().getAttribute(EFS.ATTRIBUTE_OTHER_WRITE) ? "w" : "-";
			perms += this.fileStore.fetchInfo().getAttribute(EFS.ATTRIBUTE_OTHER_EXECUTE) ? "x" : "-";
			return perms;
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ui.views.properties.IPropertySource#isPropertySet(java.lang
	 * .Object)
	 */
	@Override
	public boolean isPropertySet(Object id) {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ui.views.properties.IPropertySource#resetPropertyValue(java
	 * .lang.Object)
	 */
	@Override
	public void resetPropertyValue(Object id) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ui.views.properties.IPropertySource#setPropertyValue(java
	 * .lang.Object, java.lang.Object)
	 */
	@Override
	public void setPropertyValue(Object id, Object value) {
		// TODO Auto-generated method stub

	}

}
