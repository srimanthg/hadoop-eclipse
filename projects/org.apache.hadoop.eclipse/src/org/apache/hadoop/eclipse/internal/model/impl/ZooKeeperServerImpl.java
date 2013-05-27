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
 *  
 */
package org.apache.hadoop.eclipse.internal.model.impl;

import java.util.Collection;
import org.apache.hadoop.eclipse.internal.model.HadoopPackage;
import org.apache.hadoop.eclipse.internal.model.ZNode;
import org.apache.hadoop.eclipse.internal.model.ZNodeType;
import org.apache.hadoop.eclipse.internal.model.ZooKeeperServer;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Zoo Keeper Server</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.apache.hadoop.eclipse.internal.model.impl.ZooKeeperServerImpl#getChildren <em>Children</em>}</li>
 *   <li>{@link org.apache.hadoop.eclipse.internal.model.impl.ZooKeeperServerImpl#getLastRefresh <em>Last Refresh</em>}</li>
 *   <li>{@link org.apache.hadoop.eclipse.internal.model.impl.ZooKeeperServerImpl#isRefreshing <em>Refreshing</em>}</li>
 *   <li>{@link org.apache.hadoop.eclipse.internal.model.impl.ZooKeeperServerImpl#isEphermeral <em>Ephermeral</em>}</li>
 *   <li>{@link org.apache.hadoop.eclipse.internal.model.impl.ZooKeeperServerImpl#getCreationId <em>Creation Id</em>}</li>
 *   <li>{@link org.apache.hadoop.eclipse.internal.model.impl.ZooKeeperServerImpl#getModifiedId <em>Modified Id</em>}</li>
 *   <li>{@link org.apache.hadoop.eclipse.internal.model.impl.ZooKeeperServerImpl#getCreationTime <em>Creation Time</em>}</li>
 *   <li>{@link org.apache.hadoop.eclipse.internal.model.impl.ZooKeeperServerImpl#getModifiedTime <em>Modified Time</em>}</li>
 *   <li>{@link org.apache.hadoop.eclipse.internal.model.impl.ZooKeeperServerImpl#getVersion <em>Version</em>}</li>
 *   <li>{@link org.apache.hadoop.eclipse.internal.model.impl.ZooKeeperServerImpl#getChildrenVersion <em>Children Version</em>}</li>
 *   <li>{@link org.apache.hadoop.eclipse.internal.model.impl.ZooKeeperServerImpl#getAclVersion <em>Acl Version</em>}</li>
 *   <li>{@link org.apache.hadoop.eclipse.internal.model.impl.ZooKeeperServerImpl#getEphermalOwnerSessionId <em>Ephermal Owner Session Id</em>}</li>
 *   <li>{@link org.apache.hadoop.eclipse.internal.model.impl.ZooKeeperServerImpl#getDataLength <em>Data Length</em>}</li>
 *   <li>{@link org.apache.hadoop.eclipse.internal.model.impl.ZooKeeperServerImpl#getChildrenCount <em>Children Count</em>}</li>
 *   <li>{@link org.apache.hadoop.eclipse.internal.model.impl.ZooKeeperServerImpl#getParent <em>Parent</em>}</li>
 *   <li>{@link org.apache.hadoop.eclipse.internal.model.impl.ZooKeeperServerImpl#getNodeName <em>Node Name</em>}</li>
 *   <li>{@link org.apache.hadoop.eclipse.internal.model.impl.ZooKeeperServerImpl#isSequential <em>Sequential</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ZooKeeperServerImpl extends ServerImpl implements ZooKeeperServer {
	/**
	 * The cached value of the '{@link #getChildren() <em>Children</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChildren()
	 * @generated
	 * @ordered
	 */
	protected EList<ZNode> children;
	/**
	 * The default value of the '{@link #getLastRefresh() <em>Last Refresh</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLastRefresh()
	 * @generated
	 * @ordered
	 */
	protected static final long LAST_REFRESH_EDEFAULT = -1L;
	/**
	 * The cached value of the '{@link #getLastRefresh() <em>Last Refresh</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLastRefresh()
	 * @generated
	 * @ordered
	 */
	protected long lastRefresh = LAST_REFRESH_EDEFAULT;
	/**
	 * The default value of the '{@link #isRefreshing() <em>Refreshing</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isRefreshing()
	 * @generated
	 * @ordered
	 */
	protected static final boolean REFRESHING_EDEFAULT = false;
	/**
	 * The cached value of the '{@link #isRefreshing() <em>Refreshing</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isRefreshing()
	 * @generated
	 * @ordered
	 */
	protected boolean refreshing = REFRESHING_EDEFAULT;
	/**
	 * The default value of the '{@link #isEphermeral() <em>Ephermeral</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isEphermeral()
	 * @generated
	 * @ordered
	 */
	protected static final boolean EPHERMERAL_EDEFAULT = false;
	/**
	 * The cached value of the '{@link #isEphermeral() <em>Ephermeral</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isEphermeral()
	 * @generated
	 * @ordered
	 */
	protected boolean ephermeral = EPHERMERAL_EDEFAULT;
	/**
	 * The default value of the '{@link #getCreationId() <em>Creation Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCreationId()
	 * @generated
	 * @ordered
	 */
	protected static final long CREATION_ID_EDEFAULT = -1L;
	/**
	 * The cached value of the '{@link #getCreationId() <em>Creation Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCreationId()
	 * @generated
	 * @ordered
	 */
	protected long creationId = CREATION_ID_EDEFAULT;
	/**
	 * The default value of the '{@link #getModifiedId() <em>Modified Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModifiedId()
	 * @generated
	 * @ordered
	 */
	protected static final long MODIFIED_ID_EDEFAULT = -1L;
	/**
	 * The cached value of the '{@link #getModifiedId() <em>Modified Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModifiedId()
	 * @generated
	 * @ordered
	 */
	protected long modifiedId = MODIFIED_ID_EDEFAULT;
	/**
	 * The default value of the '{@link #getCreationTime() <em>Creation Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCreationTime()
	 * @generated
	 * @ordered
	 */
	protected static final long CREATION_TIME_EDEFAULT = -1L;
	/**
	 * The cached value of the '{@link #getCreationTime() <em>Creation Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCreationTime()
	 * @generated
	 * @ordered
	 */
	protected long creationTime = CREATION_TIME_EDEFAULT;
	/**
	 * The default value of the '{@link #getModifiedTime() <em>Modified Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModifiedTime()
	 * @generated
	 * @ordered
	 */
	protected static final long MODIFIED_TIME_EDEFAULT = -1L;
	/**
	 * The cached value of the '{@link #getModifiedTime() <em>Modified Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModifiedTime()
	 * @generated
	 * @ordered
	 */
	protected long modifiedTime = MODIFIED_TIME_EDEFAULT;
	/**
	 * The default value of the '{@link #getVersion() <em>Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVersion()
	 * @generated
	 * @ordered
	 */
	protected static final int VERSION_EDEFAULT = -1;
	/**
	 * The cached value of the '{@link #getVersion() <em>Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVersion()
	 * @generated
	 * @ordered
	 */
	protected int version = VERSION_EDEFAULT;
	/**
	 * The default value of the '{@link #getChildrenVersion() <em>Children Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChildrenVersion()
	 * @generated
	 * @ordered
	 */
	protected static final int CHILDREN_VERSION_EDEFAULT = -1;
	/**
	 * The cached value of the '{@link #getChildrenVersion() <em>Children Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChildrenVersion()
	 * @generated
	 * @ordered
	 */
	protected int childrenVersion = CHILDREN_VERSION_EDEFAULT;
	/**
	 * The default value of the '{@link #getAclVersion() <em>Acl Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAclVersion()
	 * @generated
	 * @ordered
	 */
	protected static final int ACL_VERSION_EDEFAULT = -1;
	/**
	 * The cached value of the '{@link #getAclVersion() <em>Acl Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAclVersion()
	 * @generated
	 * @ordered
	 */
	protected int aclVersion = ACL_VERSION_EDEFAULT;
	/**
	 * The default value of the '{@link #getEphermalOwnerSessionId() <em>Ephermal Owner Session Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEphermalOwnerSessionId()
	 * @generated
	 * @ordered
	 */
	protected static final long EPHERMAL_OWNER_SESSION_ID_EDEFAULT = -1L;
	/**
	 * The cached value of the '{@link #getEphermalOwnerSessionId() <em>Ephermal Owner Session Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEphermalOwnerSessionId()
	 * @generated
	 * @ordered
	 */
	protected long ephermalOwnerSessionId = EPHERMAL_OWNER_SESSION_ID_EDEFAULT;
	/**
	 * The default value of the '{@link #getDataLength() <em>Data Length</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDataLength()
	 * @generated
	 * @ordered
	 */
	protected static final int DATA_LENGTH_EDEFAULT = -1;
	/**
	 * The cached value of the '{@link #getDataLength() <em>Data Length</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDataLength()
	 * @generated
	 * @ordered
	 */
	protected int dataLength = DATA_LENGTH_EDEFAULT;
	/**
	 * The default value of the '{@link #getChildrenCount() <em>Children Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChildrenCount()
	 * @generated
	 * @ordered
	 */
	protected static final int CHILDREN_COUNT_EDEFAULT = 0;
	/**
	 * The cached value of the '{@link #getChildrenCount() <em>Children Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChildrenCount()
	 * @generated
	 * @ordered
	 */
	protected int childrenCount = CHILDREN_COUNT_EDEFAULT;
	/**
	 * The cached value of the '{@link #getParent() <em>Parent</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParent()
	 * @generated
	 * @ordered
	 */
	protected ZNode parent;
	/**
	 * The default value of the '{@link #getNodeName() <em>Node Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNodeName()
	 * @generated
	 * @ordered
	 */
	protected static final String NODE_NAME_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getNodeName() <em>Node Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNodeName()
	 * @generated
	 * @ordered
	 */
	protected String nodeName = NODE_NAME_EDEFAULT;
	/**
	 * The default value of the '{@link #isSequential() <em>Sequential</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSequential()
	 * @generated
	 * @ordered
	 */
	protected static final boolean SEQUENTIAL_EDEFAULT = false;
	/**
	 * The cached value of the '{@link #isSequential() <em>Sequential</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSequential()
	 * @generated
	 * @ordered
	 */
	protected boolean sequential = SEQUENTIAL_EDEFAULT;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ZooKeeperServerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return HadoopPackage.Literals.ZOO_KEEPER_SERVER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ZNode> getChildren() {
		if (children == null) {
			children = new EObjectContainmentEList<ZNode>(ZNode.class, this, HadoopPackage.ZOO_KEEPER_SERVER__CHILDREN);
		}
		return children;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getLastRefresh() {
		return lastRefresh;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLastRefresh(long newLastRefresh) {
		long oldLastRefresh = lastRefresh;
		lastRefresh = newLastRefresh;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HadoopPackage.ZOO_KEEPER_SERVER__LAST_REFRESH, oldLastRefresh, lastRefresh));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isRefreshing() {
		return refreshing;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRefreshing(boolean newRefreshing) {
		boolean oldRefreshing = refreshing;
		refreshing = newRefreshing;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HadoopPackage.ZOO_KEEPER_SERVER__REFRESHING, oldRefreshing, refreshing));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isEphermeral() {
		return ephermeral;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEphermeral(boolean newEphermeral) {
		boolean oldEphermeral = ephermeral;
		ephermeral = newEphermeral;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HadoopPackage.ZOO_KEEPER_SERVER__EPHERMERAL, oldEphermeral, ephermeral));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getCreationId() {
		return creationId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCreationId(long newCreationId) {
		long oldCreationId = creationId;
		creationId = newCreationId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HadoopPackage.ZOO_KEEPER_SERVER__CREATION_ID, oldCreationId, creationId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getModifiedId() {
		return modifiedId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setModifiedId(long newModifiedId) {
		long oldModifiedId = modifiedId;
		modifiedId = newModifiedId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HadoopPackage.ZOO_KEEPER_SERVER__MODIFIED_ID, oldModifiedId, modifiedId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getCreationTime() {
		return creationTime;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCreationTime(long newCreationTime) {
		long oldCreationTime = creationTime;
		creationTime = newCreationTime;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HadoopPackage.ZOO_KEEPER_SERVER__CREATION_TIME, oldCreationTime, creationTime));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getModifiedTime() {
		return modifiedTime;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setModifiedTime(long newModifiedTime) {
		long oldModifiedTime = modifiedTime;
		modifiedTime = newModifiedTime;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HadoopPackage.ZOO_KEEPER_SERVER__MODIFIED_TIME, oldModifiedTime, modifiedTime));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getVersion() {
		return version;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVersion(int newVersion) {
		int oldVersion = version;
		version = newVersion;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HadoopPackage.ZOO_KEEPER_SERVER__VERSION, oldVersion, version));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getChildrenVersion() {
		return childrenVersion;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setChildrenVersion(int newChildrenVersion) {
		int oldChildrenVersion = childrenVersion;
		childrenVersion = newChildrenVersion;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HadoopPackage.ZOO_KEEPER_SERVER__CHILDREN_VERSION, oldChildrenVersion, childrenVersion));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getAclVersion() {
		return aclVersion;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAclVersion(int newAclVersion) {
		int oldAclVersion = aclVersion;
		aclVersion = newAclVersion;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HadoopPackage.ZOO_KEEPER_SERVER__ACL_VERSION, oldAclVersion, aclVersion));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getEphermalOwnerSessionId() {
		return ephermalOwnerSessionId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEphermalOwnerSessionId(long newEphermalOwnerSessionId) {
		long oldEphermalOwnerSessionId = ephermalOwnerSessionId;
		ephermalOwnerSessionId = newEphermalOwnerSessionId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HadoopPackage.ZOO_KEEPER_SERVER__EPHERMAL_OWNER_SESSION_ID, oldEphermalOwnerSessionId, ephermalOwnerSessionId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getDataLength() {
		return dataLength;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDataLength(int newDataLength) {
		int oldDataLength = dataLength;
		dataLength = newDataLength;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HadoopPackage.ZOO_KEEPER_SERVER__DATA_LENGTH, oldDataLength, dataLength));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getChildrenCount() {
		return childrenCount;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setChildrenCount(int newChildrenCount) {
		int oldChildrenCount = childrenCount;
		childrenCount = newChildrenCount;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HadoopPackage.ZOO_KEEPER_SERVER__CHILDREN_COUNT, oldChildrenCount, childrenCount));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ZNode getParent() {
		if (parent != null && parent.eIsProxy()) {
			InternalEObject oldParent = (InternalEObject)parent;
			parent = (ZNode)eResolveProxy(oldParent);
			if (parent != oldParent) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, HadoopPackage.ZOO_KEEPER_SERVER__PARENT, oldParent, parent));
			}
		}
		return parent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ZNode basicGetParent() {
		return parent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParent(ZNode newParent) {
		ZNode oldParent = parent;
		parent = newParent;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HadoopPackage.ZOO_KEEPER_SERVER__PARENT, oldParent, parent));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getNodeName() {
		return nodeName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNodeName(String newNodeName) {
		String oldNodeName = nodeName;
		nodeName = newNodeName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HadoopPackage.ZOO_KEEPER_SERVER__NODE_NAME, oldNodeName, nodeName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSequential() {
		return sequential;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSequential(boolean newSequential) {
		boolean oldSequential = sequential;
		sequential = newSequential;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HadoopPackage.ZOO_KEEPER_SERVER__SEQUENTIAL, oldSequential, sequential));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ZooKeeperServer getServer() {
		if(this instanceof org.apache.hadoop.eclipse.internal.model.ZooKeeperServer)
					return (org.apache.hadoop.eclipse.internal.model.ZooKeeperServer) this;
				else
					return getParent().getServer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPath() {
		if (this instanceof org.apache.hadoop.eclipse.internal.model.ZooKeeperServer)
			return "/";
		else {
			String parentPath = getParent().getPath();
			return parentPath.endsWith("/") ? parentPath + getNodeName() : parentPath + "/" + getNodeName();
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case HadoopPackage.ZOO_KEEPER_SERVER__CHILDREN:
				return ((InternalEList<?>)getChildren()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case HadoopPackage.ZOO_KEEPER_SERVER__CHILDREN:
				return getChildren();
			case HadoopPackage.ZOO_KEEPER_SERVER__LAST_REFRESH:
				return getLastRefresh();
			case HadoopPackage.ZOO_KEEPER_SERVER__REFRESHING:
				return isRefreshing();
			case HadoopPackage.ZOO_KEEPER_SERVER__EPHERMERAL:
				return isEphermeral();
			case HadoopPackage.ZOO_KEEPER_SERVER__CREATION_ID:
				return getCreationId();
			case HadoopPackage.ZOO_KEEPER_SERVER__MODIFIED_ID:
				return getModifiedId();
			case HadoopPackage.ZOO_KEEPER_SERVER__CREATION_TIME:
				return getCreationTime();
			case HadoopPackage.ZOO_KEEPER_SERVER__MODIFIED_TIME:
				return getModifiedTime();
			case HadoopPackage.ZOO_KEEPER_SERVER__VERSION:
				return getVersion();
			case HadoopPackage.ZOO_KEEPER_SERVER__CHILDREN_VERSION:
				return getChildrenVersion();
			case HadoopPackage.ZOO_KEEPER_SERVER__ACL_VERSION:
				return getAclVersion();
			case HadoopPackage.ZOO_KEEPER_SERVER__EPHERMAL_OWNER_SESSION_ID:
				return getEphermalOwnerSessionId();
			case HadoopPackage.ZOO_KEEPER_SERVER__DATA_LENGTH:
				return getDataLength();
			case HadoopPackage.ZOO_KEEPER_SERVER__CHILDREN_COUNT:
				return getChildrenCount();
			case HadoopPackage.ZOO_KEEPER_SERVER__PARENT:
				if (resolve) return getParent();
				return basicGetParent();
			case HadoopPackage.ZOO_KEEPER_SERVER__NODE_NAME:
				return getNodeName();
			case HadoopPackage.ZOO_KEEPER_SERVER__SEQUENTIAL:
				return isSequential();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case HadoopPackage.ZOO_KEEPER_SERVER__CHILDREN:
				getChildren().clear();
				getChildren().addAll((Collection<? extends ZNode>)newValue);
				return;
			case HadoopPackage.ZOO_KEEPER_SERVER__LAST_REFRESH:
				setLastRefresh((Long)newValue);
				return;
			case HadoopPackage.ZOO_KEEPER_SERVER__REFRESHING:
				setRefreshing((Boolean)newValue);
				return;
			case HadoopPackage.ZOO_KEEPER_SERVER__EPHERMERAL:
				setEphermeral((Boolean)newValue);
				return;
			case HadoopPackage.ZOO_KEEPER_SERVER__CREATION_ID:
				setCreationId((Long)newValue);
				return;
			case HadoopPackage.ZOO_KEEPER_SERVER__MODIFIED_ID:
				setModifiedId((Long)newValue);
				return;
			case HadoopPackage.ZOO_KEEPER_SERVER__CREATION_TIME:
				setCreationTime((Long)newValue);
				return;
			case HadoopPackage.ZOO_KEEPER_SERVER__MODIFIED_TIME:
				setModifiedTime((Long)newValue);
				return;
			case HadoopPackage.ZOO_KEEPER_SERVER__VERSION:
				setVersion((Integer)newValue);
				return;
			case HadoopPackage.ZOO_KEEPER_SERVER__CHILDREN_VERSION:
				setChildrenVersion((Integer)newValue);
				return;
			case HadoopPackage.ZOO_KEEPER_SERVER__ACL_VERSION:
				setAclVersion((Integer)newValue);
				return;
			case HadoopPackage.ZOO_KEEPER_SERVER__EPHERMAL_OWNER_SESSION_ID:
				setEphermalOwnerSessionId((Long)newValue);
				return;
			case HadoopPackage.ZOO_KEEPER_SERVER__DATA_LENGTH:
				setDataLength((Integer)newValue);
				return;
			case HadoopPackage.ZOO_KEEPER_SERVER__CHILDREN_COUNT:
				setChildrenCount((Integer)newValue);
				return;
			case HadoopPackage.ZOO_KEEPER_SERVER__PARENT:
				setParent((ZNode)newValue);
				return;
			case HadoopPackage.ZOO_KEEPER_SERVER__NODE_NAME:
				setNodeName((String)newValue);
				return;
			case HadoopPackage.ZOO_KEEPER_SERVER__SEQUENTIAL:
				setSequential((Boolean)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case HadoopPackage.ZOO_KEEPER_SERVER__CHILDREN:
				getChildren().clear();
				return;
			case HadoopPackage.ZOO_KEEPER_SERVER__LAST_REFRESH:
				setLastRefresh(LAST_REFRESH_EDEFAULT);
				return;
			case HadoopPackage.ZOO_KEEPER_SERVER__REFRESHING:
				setRefreshing(REFRESHING_EDEFAULT);
				return;
			case HadoopPackage.ZOO_KEEPER_SERVER__EPHERMERAL:
				setEphermeral(EPHERMERAL_EDEFAULT);
				return;
			case HadoopPackage.ZOO_KEEPER_SERVER__CREATION_ID:
				setCreationId(CREATION_ID_EDEFAULT);
				return;
			case HadoopPackage.ZOO_KEEPER_SERVER__MODIFIED_ID:
				setModifiedId(MODIFIED_ID_EDEFAULT);
				return;
			case HadoopPackage.ZOO_KEEPER_SERVER__CREATION_TIME:
				setCreationTime(CREATION_TIME_EDEFAULT);
				return;
			case HadoopPackage.ZOO_KEEPER_SERVER__MODIFIED_TIME:
				setModifiedTime(MODIFIED_TIME_EDEFAULT);
				return;
			case HadoopPackage.ZOO_KEEPER_SERVER__VERSION:
				setVersion(VERSION_EDEFAULT);
				return;
			case HadoopPackage.ZOO_KEEPER_SERVER__CHILDREN_VERSION:
				setChildrenVersion(CHILDREN_VERSION_EDEFAULT);
				return;
			case HadoopPackage.ZOO_KEEPER_SERVER__ACL_VERSION:
				setAclVersion(ACL_VERSION_EDEFAULT);
				return;
			case HadoopPackage.ZOO_KEEPER_SERVER__EPHERMAL_OWNER_SESSION_ID:
				setEphermalOwnerSessionId(EPHERMAL_OWNER_SESSION_ID_EDEFAULT);
				return;
			case HadoopPackage.ZOO_KEEPER_SERVER__DATA_LENGTH:
				setDataLength(DATA_LENGTH_EDEFAULT);
				return;
			case HadoopPackage.ZOO_KEEPER_SERVER__CHILDREN_COUNT:
				setChildrenCount(CHILDREN_COUNT_EDEFAULT);
				return;
			case HadoopPackage.ZOO_KEEPER_SERVER__PARENT:
				setParent((ZNode)null);
				return;
			case HadoopPackage.ZOO_KEEPER_SERVER__NODE_NAME:
				setNodeName(NODE_NAME_EDEFAULT);
				return;
			case HadoopPackage.ZOO_KEEPER_SERVER__SEQUENTIAL:
				setSequential(SEQUENTIAL_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case HadoopPackage.ZOO_KEEPER_SERVER__CHILDREN:
				return children != null && !children.isEmpty();
			case HadoopPackage.ZOO_KEEPER_SERVER__LAST_REFRESH:
				return lastRefresh != LAST_REFRESH_EDEFAULT;
			case HadoopPackage.ZOO_KEEPER_SERVER__REFRESHING:
				return refreshing != REFRESHING_EDEFAULT;
			case HadoopPackage.ZOO_KEEPER_SERVER__EPHERMERAL:
				return ephermeral != EPHERMERAL_EDEFAULT;
			case HadoopPackage.ZOO_KEEPER_SERVER__CREATION_ID:
				return creationId != CREATION_ID_EDEFAULT;
			case HadoopPackage.ZOO_KEEPER_SERVER__MODIFIED_ID:
				return modifiedId != MODIFIED_ID_EDEFAULT;
			case HadoopPackage.ZOO_KEEPER_SERVER__CREATION_TIME:
				return creationTime != CREATION_TIME_EDEFAULT;
			case HadoopPackage.ZOO_KEEPER_SERVER__MODIFIED_TIME:
				return modifiedTime != MODIFIED_TIME_EDEFAULT;
			case HadoopPackage.ZOO_KEEPER_SERVER__VERSION:
				return version != VERSION_EDEFAULT;
			case HadoopPackage.ZOO_KEEPER_SERVER__CHILDREN_VERSION:
				return childrenVersion != CHILDREN_VERSION_EDEFAULT;
			case HadoopPackage.ZOO_KEEPER_SERVER__ACL_VERSION:
				return aclVersion != ACL_VERSION_EDEFAULT;
			case HadoopPackage.ZOO_KEEPER_SERVER__EPHERMAL_OWNER_SESSION_ID:
				return ephermalOwnerSessionId != EPHERMAL_OWNER_SESSION_ID_EDEFAULT;
			case HadoopPackage.ZOO_KEEPER_SERVER__DATA_LENGTH:
				return dataLength != DATA_LENGTH_EDEFAULT;
			case HadoopPackage.ZOO_KEEPER_SERVER__CHILDREN_COUNT:
				return childrenCount != CHILDREN_COUNT_EDEFAULT;
			case HadoopPackage.ZOO_KEEPER_SERVER__PARENT:
				return parent != null;
			case HadoopPackage.ZOO_KEEPER_SERVER__NODE_NAME:
				return NODE_NAME_EDEFAULT == null ? nodeName != null : !NODE_NAME_EDEFAULT.equals(nodeName);
			case HadoopPackage.ZOO_KEEPER_SERVER__SEQUENTIAL:
				return sequential != SEQUENTIAL_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == ZNode.class) {
			switch (derivedFeatureID) {
				case HadoopPackage.ZOO_KEEPER_SERVER__CHILDREN: return HadoopPackage.ZNODE__CHILDREN;
				case HadoopPackage.ZOO_KEEPER_SERVER__LAST_REFRESH: return HadoopPackage.ZNODE__LAST_REFRESH;
				case HadoopPackage.ZOO_KEEPER_SERVER__REFRESHING: return HadoopPackage.ZNODE__REFRESHING;
				case HadoopPackage.ZOO_KEEPER_SERVER__EPHERMERAL: return HadoopPackage.ZNODE__EPHERMERAL;
				case HadoopPackage.ZOO_KEEPER_SERVER__CREATION_ID: return HadoopPackage.ZNODE__CREATION_ID;
				case HadoopPackage.ZOO_KEEPER_SERVER__MODIFIED_ID: return HadoopPackage.ZNODE__MODIFIED_ID;
				case HadoopPackage.ZOO_KEEPER_SERVER__CREATION_TIME: return HadoopPackage.ZNODE__CREATION_TIME;
				case HadoopPackage.ZOO_KEEPER_SERVER__MODIFIED_TIME: return HadoopPackage.ZNODE__MODIFIED_TIME;
				case HadoopPackage.ZOO_KEEPER_SERVER__VERSION: return HadoopPackage.ZNODE__VERSION;
				case HadoopPackage.ZOO_KEEPER_SERVER__CHILDREN_VERSION: return HadoopPackage.ZNODE__CHILDREN_VERSION;
				case HadoopPackage.ZOO_KEEPER_SERVER__ACL_VERSION: return HadoopPackage.ZNODE__ACL_VERSION;
				case HadoopPackage.ZOO_KEEPER_SERVER__EPHERMAL_OWNER_SESSION_ID: return HadoopPackage.ZNODE__EPHERMAL_OWNER_SESSION_ID;
				case HadoopPackage.ZOO_KEEPER_SERVER__DATA_LENGTH: return HadoopPackage.ZNODE__DATA_LENGTH;
				case HadoopPackage.ZOO_KEEPER_SERVER__CHILDREN_COUNT: return HadoopPackage.ZNODE__CHILDREN_COUNT;
				case HadoopPackage.ZOO_KEEPER_SERVER__PARENT: return HadoopPackage.ZNODE__PARENT;
				case HadoopPackage.ZOO_KEEPER_SERVER__NODE_NAME: return HadoopPackage.ZNODE__NODE_NAME;
				case HadoopPackage.ZOO_KEEPER_SERVER__SEQUENTIAL: return HadoopPackage.ZNODE__SEQUENTIAL;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == ZNode.class) {
			switch (baseFeatureID) {
				case HadoopPackage.ZNODE__CHILDREN: return HadoopPackage.ZOO_KEEPER_SERVER__CHILDREN;
				case HadoopPackage.ZNODE__LAST_REFRESH: return HadoopPackage.ZOO_KEEPER_SERVER__LAST_REFRESH;
				case HadoopPackage.ZNODE__REFRESHING: return HadoopPackage.ZOO_KEEPER_SERVER__REFRESHING;
				case HadoopPackage.ZNODE__EPHERMERAL: return HadoopPackage.ZOO_KEEPER_SERVER__EPHERMERAL;
				case HadoopPackage.ZNODE__CREATION_ID: return HadoopPackage.ZOO_KEEPER_SERVER__CREATION_ID;
				case HadoopPackage.ZNODE__MODIFIED_ID: return HadoopPackage.ZOO_KEEPER_SERVER__MODIFIED_ID;
				case HadoopPackage.ZNODE__CREATION_TIME: return HadoopPackage.ZOO_KEEPER_SERVER__CREATION_TIME;
				case HadoopPackage.ZNODE__MODIFIED_TIME: return HadoopPackage.ZOO_KEEPER_SERVER__MODIFIED_TIME;
				case HadoopPackage.ZNODE__VERSION: return HadoopPackage.ZOO_KEEPER_SERVER__VERSION;
				case HadoopPackage.ZNODE__CHILDREN_VERSION: return HadoopPackage.ZOO_KEEPER_SERVER__CHILDREN_VERSION;
				case HadoopPackage.ZNODE__ACL_VERSION: return HadoopPackage.ZOO_KEEPER_SERVER__ACL_VERSION;
				case HadoopPackage.ZNODE__EPHERMAL_OWNER_SESSION_ID: return HadoopPackage.ZOO_KEEPER_SERVER__EPHERMAL_OWNER_SESSION_ID;
				case HadoopPackage.ZNODE__DATA_LENGTH: return HadoopPackage.ZOO_KEEPER_SERVER__DATA_LENGTH;
				case HadoopPackage.ZNODE__CHILDREN_COUNT: return HadoopPackage.ZOO_KEEPER_SERVER__CHILDREN_COUNT;
				case HadoopPackage.ZNODE__PARENT: return HadoopPackage.ZOO_KEEPER_SERVER__PARENT;
				case HadoopPackage.ZNODE__NODE_NAME: return HadoopPackage.ZOO_KEEPER_SERVER__NODE_NAME;
				case HadoopPackage.ZNODE__SEQUENTIAL: return HadoopPackage.ZOO_KEEPER_SERVER__SEQUENTIAL;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (lastRefresh: ");
		result.append(lastRefresh);
		result.append(", refreshing: ");
		result.append(refreshing);
		result.append(", ephermeral: ");
		result.append(ephermeral);
		result.append(", creationId: ");
		result.append(creationId);
		result.append(", modifiedId: ");
		result.append(modifiedId);
		result.append(", creationTime: ");
		result.append(creationTime);
		result.append(", modifiedTime: ");
		result.append(modifiedTime);
		result.append(", version: ");
		result.append(version);
		result.append(", childrenVersion: ");
		result.append(childrenVersion);
		result.append(", aclVersion: ");
		result.append(aclVersion);
		result.append(", ephermalOwnerSessionId: ");
		result.append(ephermalOwnerSessionId);
		result.append(", dataLength: ");
		result.append(dataLength);
		result.append(", childrenCount: ");
		result.append(childrenCount);
		result.append(", nodeName: ");
		result.append(nodeName);
		result.append(", sequential: ");
		result.append(sequential);
		result.append(')');
		return result.toString();
	}

} //ZooKeeperServerImpl
