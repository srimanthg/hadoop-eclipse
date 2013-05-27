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

import org.apache.hadoop.eclipse.internal.model.HDFSServer;
import org.apache.hadoop.eclipse.internal.model.HadoopFactory;
import org.apache.hadoop.eclipse.internal.model.HadoopPackage;
import org.apache.hadoop.eclipse.internal.model.Server;
import org.apache.hadoop.eclipse.internal.model.ServerStatus;
import org.apache.hadoop.eclipse.internal.model.Servers;

import org.apache.hadoop.eclipse.internal.model.ZNode;
import org.apache.hadoop.eclipse.internal.model.ZNodeType;
import org.apache.hadoop.eclipse.internal.model.ZooKeeperServer;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class HadoopPackageImpl extends EPackageImpl implements HadoopPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass hdfsServerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass serversEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass serverEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass zooKeeperServerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass zNodeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum serverStatusEEnum = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.apache.hadoop.eclipse.internal.model.HadoopPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private HadoopPackageImpl() {
		super(eNS_URI, HadoopFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link HadoopPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static HadoopPackage init() {
		if (isInited) return (HadoopPackage)EPackage.Registry.INSTANCE.getEPackage(HadoopPackage.eNS_URI);

		// Obtain or create and register package
		HadoopPackageImpl theHadoopPackage = (HadoopPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof HadoopPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new HadoopPackageImpl());

		isInited = true;

		// Create package meta-data objects
		theHadoopPackage.createPackageContents();

		// Initialize created meta-data
		theHadoopPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theHadoopPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(HadoopPackage.eNS_URI, theHadoopPackage);
		return theHadoopPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getHDFSServer() {
		return hdfsServerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getHDFSServer_Loaded() {
		return (EAttribute)hdfsServerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getHDFSServer_OperationURIs() {
		return (EAttribute)hdfsServerEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getHDFSServer_UserId() {
		return (EAttribute)hdfsServerEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getHDFSServer_GroupIds() {
		return (EAttribute)hdfsServerEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getServers() {
		return serversEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getServers_HdfsServers() {
		return (EReference)serversEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getServers_Version() {
		return (EAttribute)serversEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getServers_ZookeeperServers() {
		return (EReference)serversEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getServer() {
		return serverEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getServer_Name() {
		return (EAttribute)serverEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getServer_Uri() {
		return (EAttribute)serverEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getServer_StatusCode() {
		return (EAttribute)serverEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getServer_StatusMessage() {
		return (EAttribute)serverEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getServer_LastAccessed() {
		return (EAttribute)serverEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getZooKeeperServer() {
		return zooKeeperServerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getZNode() {
		return zNodeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getZNode_Children() {
		return (EReference)zNodeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getZNode_LastRefresh() {
		return (EAttribute)zNodeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getZNode_Refreshing() {
		return (EAttribute)zNodeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getZNode_Ephermeral() {
		return (EAttribute)zNodeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getZNode_CreationId() {
		return (EAttribute)zNodeEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getZNode_ModifiedId() {
		return (EAttribute)zNodeEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getZNode_CreationTime() {
		return (EAttribute)zNodeEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getZNode_ModifiedTime() {
		return (EAttribute)zNodeEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getZNode_Version() {
		return (EAttribute)zNodeEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getZNode_ChildrenVersion() {
		return (EAttribute)zNodeEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getZNode_AclVersion() {
		return (EAttribute)zNodeEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getZNode_EphermalOwnerSessionId() {
		return (EAttribute)zNodeEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getZNode_DataLength() {
		return (EAttribute)zNodeEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getZNode_ChildrenCount() {
		return (EAttribute)zNodeEClass.getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getZNode_Parent() {
		return (EReference)zNodeEClass.getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getZNode_NodeName() {
		return (EAttribute)zNodeEClass.getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getZNode_Sequential() {
		return (EAttribute)zNodeEClass.getEStructuralFeatures().get(16);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getServerStatus() {
		return serverStatusEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HadoopFactory getHadoopFactory() {
		return (HadoopFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		hdfsServerEClass = createEClass(HDFS_SERVER);
		createEAttribute(hdfsServerEClass, HDFS_SERVER__LOADED);
		createEAttribute(hdfsServerEClass, HDFS_SERVER__OPERATION_UR_IS);
		createEAttribute(hdfsServerEClass, HDFS_SERVER__USER_ID);
		createEAttribute(hdfsServerEClass, HDFS_SERVER__GROUP_IDS);

		serversEClass = createEClass(SERVERS);
		createEReference(serversEClass, SERVERS__HDFS_SERVERS);
		createEAttribute(serversEClass, SERVERS__VERSION);
		createEReference(serversEClass, SERVERS__ZOOKEEPER_SERVERS);

		serverEClass = createEClass(SERVER);
		createEAttribute(serverEClass, SERVER__NAME);
		createEAttribute(serverEClass, SERVER__URI);
		createEAttribute(serverEClass, SERVER__STATUS_CODE);
		createEAttribute(serverEClass, SERVER__STATUS_MESSAGE);
		createEAttribute(serverEClass, SERVER__LAST_ACCESSED);

		zooKeeperServerEClass = createEClass(ZOO_KEEPER_SERVER);

		zNodeEClass = createEClass(ZNODE);
		createEReference(zNodeEClass, ZNODE__CHILDREN);
		createEAttribute(zNodeEClass, ZNODE__LAST_REFRESH);
		createEAttribute(zNodeEClass, ZNODE__REFRESHING);
		createEAttribute(zNodeEClass, ZNODE__EPHERMERAL);
		createEAttribute(zNodeEClass, ZNODE__CREATION_ID);
		createEAttribute(zNodeEClass, ZNODE__MODIFIED_ID);
		createEAttribute(zNodeEClass, ZNODE__CREATION_TIME);
		createEAttribute(zNodeEClass, ZNODE__MODIFIED_TIME);
		createEAttribute(zNodeEClass, ZNODE__VERSION);
		createEAttribute(zNodeEClass, ZNODE__CHILDREN_VERSION);
		createEAttribute(zNodeEClass, ZNODE__ACL_VERSION);
		createEAttribute(zNodeEClass, ZNODE__EPHERMAL_OWNER_SESSION_ID);
		createEAttribute(zNodeEClass, ZNODE__DATA_LENGTH);
		createEAttribute(zNodeEClass, ZNODE__CHILDREN_COUNT);
		createEReference(zNodeEClass, ZNODE__PARENT);
		createEAttribute(zNodeEClass, ZNODE__NODE_NAME);
		createEAttribute(zNodeEClass, ZNODE__SEQUENTIAL);

		// Create enums
		serverStatusEEnum = createEEnum(SERVER_STATUS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		hdfsServerEClass.getESuperTypes().add(this.getServer());
		zooKeeperServerEClass.getESuperTypes().add(this.getServer());
		zooKeeperServerEClass.getESuperTypes().add(this.getZNode());

		// Initialize classes and features; add operations and parameters
		initEClass(hdfsServerEClass, HDFSServer.class, "HDFSServer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getHDFSServer_Loaded(), ecorePackage.getEBoolean(), "loaded", null, 0, 1, HDFSServer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getHDFSServer_OperationURIs(), ecorePackage.getEString(), "operationURIs", null, 0, -1, HDFSServer.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getHDFSServer_UserId(), ecorePackage.getEString(), "userId", null, 0, 1, HDFSServer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getHDFSServer_GroupIds(), ecorePackage.getEString(), "groupIds", null, 0, -1, HDFSServer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(serversEClass, Servers.class, "Servers", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getServers_HdfsServers(), this.getHDFSServer(), null, "hdfsServers", null, 0, -1, Servers.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getServers_Version(), ecorePackage.getEString(), "version", "1.0.0.0", 0, 1, Servers.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getServers_ZookeeperServers(), this.getZooKeeperServer(), null, "zookeeperServers", null, 0, -1, Servers.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(serverEClass, Server.class, "Server", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getServer_Name(), ecorePackage.getEString(), "name", "", 0, 1, Server.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getServer_Uri(), ecorePackage.getEString(), "uri", null, 0, 1, Server.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getServer_StatusCode(), ecorePackage.getEInt(), "statusCode", "0", 0, 1, Server.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getServer_StatusMessage(), ecorePackage.getEString(), "statusMessage", null, 0, 1, Server.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getServer_LastAccessed(), ecorePackage.getELong(), "lastAccessed", "-1", 0, 1, Server.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(zooKeeperServerEClass, ZooKeeperServer.class, "ZooKeeperServer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(zNodeEClass, ZNode.class, "ZNode", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getZNode_Children(), this.getZNode(), null, "children", null, 0, -1, ZNode.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getZNode_LastRefresh(), ecorePackage.getELong(), "lastRefresh", "-1", 0, 1, ZNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getZNode_Refreshing(), ecorePackage.getEBoolean(), "refreshing", null, 0, 1, ZNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getZNode_Ephermeral(), ecorePackage.getEBoolean(), "ephermeral", null, 0, 1, ZNode.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getZNode_CreationId(), ecorePackage.getELong(), "creationId", "-1", 0, 1, ZNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getZNode_ModifiedId(), ecorePackage.getELong(), "modifiedId", "-1", 0, 1, ZNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getZNode_CreationTime(), ecorePackage.getELong(), "creationTime", "-1", 0, 1, ZNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getZNode_ModifiedTime(), ecorePackage.getELong(), "modifiedTime", "-1", 0, 1, ZNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getZNode_Version(), ecorePackage.getEInt(), "version", "-1", 0, 1, ZNode.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getZNode_ChildrenVersion(), ecorePackage.getEInt(), "childrenVersion", "-1", 0, 1, ZNode.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getZNode_AclVersion(), ecorePackage.getEInt(), "aclVersion", "-1", 0, 1, ZNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getZNode_EphermalOwnerSessionId(), ecorePackage.getELong(), "ephermalOwnerSessionId", "-1", 0, 1, ZNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getZNode_DataLength(), ecorePackage.getEInt(), "dataLength", "-1", 0, 1, ZNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getZNode_ChildrenCount(), ecorePackage.getEInt(), "childrenCount", "0", 0, 1, ZNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getZNode_Parent(), this.getZNode(), null, "parent", null, 0, 1, ZNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getZNode_NodeName(), ecorePackage.getEString(), "nodeName", null, 0, 1, ZNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getZNode_Sequential(), ecorePackage.getEBoolean(), "sequential", null, 0, 1, ZNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(zNodeEClass, ecorePackage.getEString(), "getPath", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(zNodeEClass, this.getZooKeeperServer(), "getServer", 0, 1, IS_UNIQUE, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(serverStatusEEnum, ServerStatus.class, "ServerStatus");
		addEEnumLiteral(serverStatusEEnum, ServerStatus.NO_PROJECT);
		addEEnumLiteral(serverStatusEEnum, ServerStatus.DISCONNECTED);
		addEEnumLiteral(serverStatusEEnum, ServerStatus.CONNECTED);

		// Create resource
		createResource(eNS_URI);
	}

} //HadoopPackageImpl
