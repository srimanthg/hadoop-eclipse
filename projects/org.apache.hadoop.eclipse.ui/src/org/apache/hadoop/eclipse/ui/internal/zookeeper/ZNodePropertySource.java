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
package org.apache.hadoop.eclipse.ui.internal.zookeeper;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.hadoop.eclipse.internal.model.ZNode;
import org.apache.hadoop.eclipse.ui.Activator;
import org.eclipse.ui.views.properties.IPropertyDescriptor;
import org.eclipse.ui.views.properties.IPropertySource;
import org.eclipse.ui.views.properties.PropertyDescriptor;

/**
 * @author Srimanth Gunturi
 * 
 */
public class ZNodePropertySource implements IPropertySource {

	/**
	 * 
	 */
	private static final String PROP_DATA_SIZE = Activator.PLUGIN_ID + ".znode.dsize";
	/**
	 * 
	 */
	private static final String PROP_CHILD_COUNT = Activator.PLUGIN_ID + ".znode.ccount";
	/**
	 * 
	 */
	private static final String PROP_TIME_REFRESH = Activator.PLUGIN_ID + ".znode.rtime";
	/**
	 * 
	 */
	private static final String PROP_TIME_MODIFICATION = Activator.PLUGIN_ID + ".znode.mtime";
	/**
	 * 
	 */
	private static final String PROP_TIME_CREATION = Activator.PLUGIN_ID + ".znode.ctime";
	/**
	 * 
	 */
	private static final String PROP_ID_MODIFICATION = Activator.PLUGIN_ID + ".znode.mxid";
	/**
	 * 
	 */
	private static final String PROP_ID_CREATION = Activator.PLUGIN_ID + ".znode.cxid";
	/**
	 * 
	 */
	private static final String PROP_VERSION_ACL = Activator.PLUGIN_ID + ".znode.aversion";
	/**
	 * 
	 */
	private static final String PROP_VERSION_CHILDREN = Activator.PLUGIN_ID + ".znode.cversion";
	/**
	 * 
	 */
	private static final String PROP_VERSION = Activator.PLUGIN_ID + ".znode.version";
	/**
	 * 
	 */
	private static final String PROP_EPHERMERAL = Activator.PLUGIN_ID + ".znode.ephermeral";
	/**
	 * 
	 */
	private static final String PROP_EPHERMERAL_SESSION_ID = Activator.PLUGIN_ID + ".znode.ephermeral.sessionid";

	private final ZNode zNode;

	/**
	 * @param zNode
	 */
	public ZNodePropertySource(ZNode zNode) {
		this.zNode = zNode;
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
		if (zNode != null) {
			List<IPropertyDescriptor> props = new ArrayList<IPropertyDescriptor>();
			// Versions
			props.add(new PropertyDescriptor(PROP_VERSION, "Version (Node)"));
			props.add(new PropertyDescriptor(PROP_VERSION_CHILDREN, "Version (Children)"));
			props.add(new PropertyDescriptor(PROP_VERSION_ACL, "Version (ACL)"));
			// IDs
			props.add(new PropertyDescriptor(PROP_ID_CREATION, "ID (Creation)"));
			props.add(new PropertyDescriptor(PROP_ID_MODIFICATION, "ID (Modification)"));
			// Time
			props.add(new PropertyDescriptor(PROP_TIME_CREATION, "Created"));
			props.add(new PropertyDescriptor(PROP_TIME_MODIFICATION, "Modified"));
			props.add(new PropertyDescriptor(PROP_TIME_REFRESH, "Refreshed"));
			// Misc
			props.add(new PropertyDescriptor(PROP_CHILD_COUNT, "Children Count"));
			props.add(new PropertyDescriptor(PROP_DATA_SIZE, "Data size"));
			props.add(new PropertyDescriptor(PROP_EPHERMERAL, "Is Ephermeral Node"));
			if(zNode.isEphermeral())
				props.add(new PropertyDescriptor(PROP_EPHERMERAL_SESSION_ID, "Ephermeral Session Id"));
			return props.toArray(new IPropertyDescriptor[props.size()]);
		}
		return new IPropertyDescriptor[0];
	}

	protected String getTimeDisplay(long time) {
		if (time > 0)
			return DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG).format(new Date(time));
		return null;
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
		if(PROP_CHILD_COUNT.equals(id))
			return zNode.getChildrenCount();
		if(PROP_DATA_SIZE.equals(id))
			return zNode.getDataLength();
		if(PROP_TIME_CREATION.equals(id))
			return getTimeDisplay(zNode.getCreationTime());
		if(PROP_TIME_MODIFICATION.equals(id))
			return getTimeDisplay(zNode.getModifiedTime());
		if(PROP_TIME_REFRESH.equals(id))
			return getTimeDisplay(zNode.getLastRefresh());
		if(PROP_ID_CREATION.equals(id))
			return zNode.getCreationId();
		if(PROP_ID_MODIFICATION.equals(id))
			return zNode.getModifiedId();
		if(PROP_VERSION.equals(id))
			return zNode.getVersion();
		if(PROP_VERSION_ACL.equals(id))
			return zNode.getAclVersion();
		if(PROP_VERSION_CHILDREN.equals(id))
			return zNode.getChildrenVersion();
		if(PROP_EPHERMERAL.equals(id))
			return zNode.isEphermeral();
		if(PROP_EPHERMERAL_SESSION_ID.equals(id))
			return zNode.getEphermalOwnerSessionId();
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
