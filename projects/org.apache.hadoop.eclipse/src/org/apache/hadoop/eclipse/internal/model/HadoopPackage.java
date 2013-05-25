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
package org.apache.hadoop.eclipse.internal.model;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.apache.hadoop.eclipse.internal.model.HadoopFactory
 * @model kind="package"
 * @generated
 */
public interface HadoopPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "model";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://hadoop/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "model";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	HadoopPackage eINSTANCE = org.apache.hadoop.eclipse.internal.model.impl.HadoopPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.apache.hadoop.eclipse.internal.model.impl.ServerImpl <em>Server</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.apache.hadoop.eclipse.internal.model.impl.ServerImpl
	 * @see org.apache.hadoop.eclipse.internal.model.impl.HadoopPackageImpl#getServer()
	 * @generated
	 */
	int SERVER = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVER__NAME = 0;

	/**
	 * The feature id for the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVER__URI = 1;

	/**
	 * The feature id for the '<em><b>Status Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVER__STATUS_CODE = 2;

	/**
	 * The feature id for the '<em><b>Status Message</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVER__STATUS_MESSAGE = 3;

	/**
	 * The feature id for the '<em><b>Last Accessed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVER__LAST_ACCESSED = 4;

	/**
	 * The number of structural features of the '<em>Server</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVER_FEATURE_COUNT = 5;

	/**
	 * The meta object id for the '{@link org.apache.hadoop.eclipse.internal.model.impl.HDFSServerImpl <em>HDFS Server</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.apache.hadoop.eclipse.internal.model.impl.HDFSServerImpl
	 * @see org.apache.hadoop.eclipse.internal.model.impl.HadoopPackageImpl#getHDFSServer()
	 * @generated
	 */
	int HDFS_SERVER = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HDFS_SERVER__NAME = SERVER__NAME;

	/**
	 * The feature id for the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HDFS_SERVER__URI = SERVER__URI;

	/**
	 * The feature id for the '<em><b>Status Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HDFS_SERVER__STATUS_CODE = SERVER__STATUS_CODE;

	/**
	 * The feature id for the '<em><b>Status Message</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HDFS_SERVER__STATUS_MESSAGE = SERVER__STATUS_MESSAGE;

	/**
	 * The feature id for the '<em><b>Last Accessed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HDFS_SERVER__LAST_ACCESSED = SERVER__LAST_ACCESSED;

	/**
	 * The feature id for the '<em><b>Loaded</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HDFS_SERVER__LOADED = SERVER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Operation UR Is</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HDFS_SERVER__OPERATION_UR_IS = SERVER_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>User Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HDFS_SERVER__USER_ID = SERVER_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Group Ids</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HDFS_SERVER__GROUP_IDS = SERVER_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>HDFS Server</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HDFS_SERVER_FEATURE_COUNT = SERVER_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.apache.hadoop.eclipse.internal.model.impl.ServersImpl <em>Servers</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.apache.hadoop.eclipse.internal.model.impl.ServersImpl
	 * @see org.apache.hadoop.eclipse.internal.model.impl.HadoopPackageImpl#getServers()
	 * @generated
	 */
	int SERVERS = 1;

	/**
	 * The feature id for the '<em><b>Hdfs Servers</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVERS__HDFS_SERVERS = 0;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVERS__VERSION = 1;

	/**
	 * The feature id for the '<em><b>Zookeeper Servers</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVERS__ZOOKEEPER_SERVERS = 2;

	/**
	 * The number of structural features of the '<em>Servers</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVERS_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link org.apache.hadoop.eclipse.internal.model.impl.ZooKeeperServerImpl <em>Zoo Keeper Server</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.apache.hadoop.eclipse.internal.model.impl.ZooKeeperServerImpl
	 * @see org.apache.hadoop.eclipse.internal.model.impl.HadoopPackageImpl#getZooKeeperServer()
	 * @generated
	 */
	int ZOO_KEEPER_SERVER = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ZOO_KEEPER_SERVER__NAME = SERVER__NAME;

	/**
	 * The feature id for the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ZOO_KEEPER_SERVER__URI = SERVER__URI;

	/**
	 * The feature id for the '<em><b>Status Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ZOO_KEEPER_SERVER__STATUS_CODE = SERVER__STATUS_CODE;

	/**
	 * The feature id for the '<em><b>Status Message</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ZOO_KEEPER_SERVER__STATUS_MESSAGE = SERVER__STATUS_MESSAGE;

	/**
	 * The feature id for the '<em><b>Last Accessed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ZOO_KEEPER_SERVER__LAST_ACCESSED = SERVER__LAST_ACCESSED;

	/**
	 * The feature id for the '<em><b>Children</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ZOO_KEEPER_SERVER__CHILDREN = SERVER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Last Refresh</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ZOO_KEEPER_SERVER__LAST_REFRESH = SERVER_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Refreshing</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ZOO_KEEPER_SERVER__REFRESHING = SERVER_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ZOO_KEEPER_SERVER__TYPE = SERVER_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Creation Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ZOO_KEEPER_SERVER__CREATION_ID = SERVER_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Modified Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ZOO_KEEPER_SERVER__MODIFIED_ID = SERVER_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Creation Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ZOO_KEEPER_SERVER__CREATION_TIME = SERVER_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Modified Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ZOO_KEEPER_SERVER__MODIFIED_TIME = SERVER_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ZOO_KEEPER_SERVER__VERSION = SERVER_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Children Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ZOO_KEEPER_SERVER__CHILDREN_VERSION = SERVER_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>Acl Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ZOO_KEEPER_SERVER__ACL_VERSION = SERVER_FEATURE_COUNT + 10;

	/**
	 * The feature id for the '<em><b>Ephermal Owner Session Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ZOO_KEEPER_SERVER__EPHERMAL_OWNER_SESSION_ID = SERVER_FEATURE_COUNT + 11;

	/**
	 * The feature id for the '<em><b>Data Length</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ZOO_KEEPER_SERVER__DATA_LENGTH = SERVER_FEATURE_COUNT + 12;

	/**
	 * The feature id for the '<em><b>Children Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ZOO_KEEPER_SERVER__CHILDREN_COUNT = SERVER_FEATURE_COUNT + 13;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ZOO_KEEPER_SERVER__PARENT = SERVER_FEATURE_COUNT + 14;

	/**
	 * The feature id for the '<em><b>Node Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ZOO_KEEPER_SERVER__NODE_NAME = SERVER_FEATURE_COUNT + 15;

	/**
	 * The number of structural features of the '<em>Zoo Keeper Server</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ZOO_KEEPER_SERVER_FEATURE_COUNT = SERVER_FEATURE_COUNT + 16;

	/**
	 * The meta object id for the '{@link org.apache.hadoop.eclipse.internal.model.impl.ZNodeImpl <em>ZNode</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.apache.hadoop.eclipse.internal.model.impl.ZNodeImpl
	 * @see org.apache.hadoop.eclipse.internal.model.impl.HadoopPackageImpl#getZNode()
	 * @generated
	 */
	int ZNODE = 4;

	/**
	 * The feature id for the '<em><b>Children</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ZNODE__CHILDREN = 0;

	/**
	 * The feature id for the '<em><b>Last Refresh</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ZNODE__LAST_REFRESH = 1;

	/**
	 * The feature id for the '<em><b>Refreshing</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ZNODE__REFRESHING = 2;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ZNODE__TYPE = 3;

	/**
	 * The feature id for the '<em><b>Creation Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ZNODE__CREATION_ID = 4;

	/**
	 * The feature id for the '<em><b>Modified Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ZNODE__MODIFIED_ID = 5;

	/**
	 * The feature id for the '<em><b>Creation Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ZNODE__CREATION_TIME = 6;

	/**
	 * The feature id for the '<em><b>Modified Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ZNODE__MODIFIED_TIME = 7;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ZNODE__VERSION = 8;

	/**
	 * The feature id for the '<em><b>Children Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ZNODE__CHILDREN_VERSION = 9;

	/**
	 * The feature id for the '<em><b>Acl Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ZNODE__ACL_VERSION = 10;

	/**
	 * The feature id for the '<em><b>Ephermal Owner Session Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ZNODE__EPHERMAL_OWNER_SESSION_ID = 11;

	/**
	 * The feature id for the '<em><b>Data Length</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ZNODE__DATA_LENGTH = 12;

	/**
	 * The feature id for the '<em><b>Children Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ZNODE__CHILDREN_COUNT = 13;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ZNODE__PARENT = 14;

	/**
	 * The feature id for the '<em><b>Node Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ZNODE__NODE_NAME = 15;

	/**
	 * The number of structural features of the '<em>ZNode</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ZNODE_FEATURE_COUNT = 16;

	/**
	 * The meta object id for the '{@link org.apache.hadoop.eclipse.internal.model.ServerStatus <em>Server Status</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.apache.hadoop.eclipse.internal.model.ServerStatus
	 * @see org.apache.hadoop.eclipse.internal.model.impl.HadoopPackageImpl#getServerStatus()
	 * @generated
	 */
	int SERVER_STATUS = 5;


	/**
	 * The meta object id for the '{@link org.apache.hadoop.eclipse.internal.model.ZNodeType <em>ZNode Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.apache.hadoop.eclipse.internal.model.ZNodeType
	 * @see org.apache.hadoop.eclipse.internal.model.impl.HadoopPackageImpl#getZNodeType()
	 * @generated
	 */
	int ZNODE_TYPE = 6;


	/**
	 * Returns the meta object for class '{@link org.apache.hadoop.eclipse.internal.model.HDFSServer <em>HDFS Server</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>HDFS Server</em>'.
	 * @see org.apache.hadoop.eclipse.internal.model.HDFSServer
	 * @generated
	 */
	EClass getHDFSServer();

	/**
	 * Returns the meta object for the attribute '{@link org.apache.hadoop.eclipse.internal.model.HDFSServer#isLoaded <em>Loaded</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Loaded</em>'.
	 * @see org.apache.hadoop.eclipse.internal.model.HDFSServer#isLoaded()
	 * @see #getHDFSServer()
	 * @generated
	 */
	EAttribute getHDFSServer_Loaded();

	/**
	 * Returns the meta object for the attribute list '{@link org.apache.hadoop.eclipse.internal.model.HDFSServer#getOperationURIs <em>Operation UR Is</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Operation UR Is</em>'.
	 * @see org.apache.hadoop.eclipse.internal.model.HDFSServer#getOperationURIs()
	 * @see #getHDFSServer()
	 * @generated
	 */
	EAttribute getHDFSServer_OperationURIs();

	/**
	 * Returns the meta object for the attribute '{@link org.apache.hadoop.eclipse.internal.model.HDFSServer#getUserId <em>User Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>User Id</em>'.
	 * @see org.apache.hadoop.eclipse.internal.model.HDFSServer#getUserId()
	 * @see #getHDFSServer()
	 * @generated
	 */
	EAttribute getHDFSServer_UserId();

	/**
	 * Returns the meta object for the attribute list '{@link org.apache.hadoop.eclipse.internal.model.HDFSServer#getGroupIds <em>Group Ids</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Group Ids</em>'.
	 * @see org.apache.hadoop.eclipse.internal.model.HDFSServer#getGroupIds()
	 * @see #getHDFSServer()
	 * @generated
	 */
	EAttribute getHDFSServer_GroupIds();

	/**
	 * Returns the meta object for class '{@link org.apache.hadoop.eclipse.internal.model.Servers <em>Servers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Servers</em>'.
	 * @see org.apache.hadoop.eclipse.internal.model.Servers
	 * @generated
	 */
	EClass getServers();

	/**
	 * Returns the meta object for the containment reference list '{@link org.apache.hadoop.eclipse.internal.model.Servers#getHdfsServers <em>Hdfs Servers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Hdfs Servers</em>'.
	 * @see org.apache.hadoop.eclipse.internal.model.Servers#getHdfsServers()
	 * @see #getServers()
	 * @generated
	 */
	EReference getServers_HdfsServers();

	/**
	 * Returns the meta object for the attribute '{@link org.apache.hadoop.eclipse.internal.model.Servers#getVersion <em>Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Version</em>'.
	 * @see org.apache.hadoop.eclipse.internal.model.Servers#getVersion()
	 * @see #getServers()
	 * @generated
	 */
	EAttribute getServers_Version();

	/**
	 * Returns the meta object for the containment reference list '{@link org.apache.hadoop.eclipse.internal.model.Servers#getZookeeperServers <em>Zookeeper Servers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Zookeeper Servers</em>'.
	 * @see org.apache.hadoop.eclipse.internal.model.Servers#getZookeeperServers()
	 * @see #getServers()
	 * @generated
	 */
	EReference getServers_ZookeeperServers();

	/**
	 * Returns the meta object for class '{@link org.apache.hadoop.eclipse.internal.model.Server <em>Server</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Server</em>'.
	 * @see org.apache.hadoop.eclipse.internal.model.Server
	 * @generated
	 */
	EClass getServer();

	/**
	 * Returns the meta object for the attribute '{@link org.apache.hadoop.eclipse.internal.model.Server#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.apache.hadoop.eclipse.internal.model.Server#getName()
	 * @see #getServer()
	 * @generated
	 */
	EAttribute getServer_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.apache.hadoop.eclipse.internal.model.Server#getUri <em>Uri</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Uri</em>'.
	 * @see org.apache.hadoop.eclipse.internal.model.Server#getUri()
	 * @see #getServer()
	 * @generated
	 */
	EAttribute getServer_Uri();

	/**
	 * Returns the meta object for the attribute '{@link org.apache.hadoop.eclipse.internal.model.Server#getStatusCode <em>Status Code</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Status Code</em>'.
	 * @see org.apache.hadoop.eclipse.internal.model.Server#getStatusCode()
	 * @see #getServer()
	 * @generated
	 */
	EAttribute getServer_StatusCode();

	/**
	 * Returns the meta object for the attribute '{@link org.apache.hadoop.eclipse.internal.model.Server#getStatusMessage <em>Status Message</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Status Message</em>'.
	 * @see org.apache.hadoop.eclipse.internal.model.Server#getStatusMessage()
	 * @see #getServer()
	 * @generated
	 */
	EAttribute getServer_StatusMessage();

	/**
	 * Returns the meta object for the attribute '{@link org.apache.hadoop.eclipse.internal.model.Server#getLastAccessed <em>Last Accessed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Last Accessed</em>'.
	 * @see org.apache.hadoop.eclipse.internal.model.Server#getLastAccessed()
	 * @see #getServer()
	 * @generated
	 */
	EAttribute getServer_LastAccessed();

	/**
	 * Returns the meta object for class '{@link org.apache.hadoop.eclipse.internal.model.ZooKeeperServer <em>Zoo Keeper Server</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Zoo Keeper Server</em>'.
	 * @see org.apache.hadoop.eclipse.internal.model.ZooKeeperServer
	 * @generated
	 */
	EClass getZooKeeperServer();

	/**
	 * Returns the meta object for class '{@link org.apache.hadoop.eclipse.internal.model.ZNode <em>ZNode</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>ZNode</em>'.
	 * @see org.apache.hadoop.eclipse.internal.model.ZNode
	 * @generated
	 */
	EClass getZNode();

	/**
	 * Returns the meta object for the containment reference list '{@link org.apache.hadoop.eclipse.internal.model.ZNode#getChildren <em>Children</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Children</em>'.
	 * @see org.apache.hadoop.eclipse.internal.model.ZNode#getChildren()
	 * @see #getZNode()
	 * @generated
	 */
	EReference getZNode_Children();

	/**
	 * Returns the meta object for the attribute '{@link org.apache.hadoop.eclipse.internal.model.ZNode#getLastRefresh <em>Last Refresh</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Last Refresh</em>'.
	 * @see org.apache.hadoop.eclipse.internal.model.ZNode#getLastRefresh()
	 * @see #getZNode()
	 * @generated
	 */
	EAttribute getZNode_LastRefresh();

	/**
	 * Returns the meta object for the attribute '{@link org.apache.hadoop.eclipse.internal.model.ZNode#isRefreshing <em>Refreshing</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Refreshing</em>'.
	 * @see org.apache.hadoop.eclipse.internal.model.ZNode#isRefreshing()
	 * @see #getZNode()
	 * @generated
	 */
	EAttribute getZNode_Refreshing();

	/**
	 * Returns the meta object for the attribute '{@link org.apache.hadoop.eclipse.internal.model.ZNode#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see org.apache.hadoop.eclipse.internal.model.ZNode#getType()
	 * @see #getZNode()
	 * @generated
	 */
	EAttribute getZNode_Type();

	/**
	 * Returns the meta object for the attribute '{@link org.apache.hadoop.eclipse.internal.model.ZNode#getCreationId <em>Creation Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Creation Id</em>'.
	 * @see org.apache.hadoop.eclipse.internal.model.ZNode#getCreationId()
	 * @see #getZNode()
	 * @generated
	 */
	EAttribute getZNode_CreationId();

	/**
	 * Returns the meta object for the attribute '{@link org.apache.hadoop.eclipse.internal.model.ZNode#getModifiedId <em>Modified Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Modified Id</em>'.
	 * @see org.apache.hadoop.eclipse.internal.model.ZNode#getModifiedId()
	 * @see #getZNode()
	 * @generated
	 */
	EAttribute getZNode_ModifiedId();

	/**
	 * Returns the meta object for the attribute '{@link org.apache.hadoop.eclipse.internal.model.ZNode#getCreationTime <em>Creation Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Creation Time</em>'.
	 * @see org.apache.hadoop.eclipse.internal.model.ZNode#getCreationTime()
	 * @see #getZNode()
	 * @generated
	 */
	EAttribute getZNode_CreationTime();

	/**
	 * Returns the meta object for the attribute '{@link org.apache.hadoop.eclipse.internal.model.ZNode#getModifiedTime <em>Modified Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Modified Time</em>'.
	 * @see org.apache.hadoop.eclipse.internal.model.ZNode#getModifiedTime()
	 * @see #getZNode()
	 * @generated
	 */
	EAttribute getZNode_ModifiedTime();

	/**
	 * Returns the meta object for the attribute '{@link org.apache.hadoop.eclipse.internal.model.ZNode#getVersion <em>Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Version</em>'.
	 * @see org.apache.hadoop.eclipse.internal.model.ZNode#getVersion()
	 * @see #getZNode()
	 * @generated
	 */
	EAttribute getZNode_Version();

	/**
	 * Returns the meta object for the attribute '{@link org.apache.hadoop.eclipse.internal.model.ZNode#getChildrenVersion <em>Children Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Children Version</em>'.
	 * @see org.apache.hadoop.eclipse.internal.model.ZNode#getChildrenVersion()
	 * @see #getZNode()
	 * @generated
	 */
	EAttribute getZNode_ChildrenVersion();

	/**
	 * Returns the meta object for the attribute '{@link org.apache.hadoop.eclipse.internal.model.ZNode#getAclVersion <em>Acl Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Acl Version</em>'.
	 * @see org.apache.hadoop.eclipse.internal.model.ZNode#getAclVersion()
	 * @see #getZNode()
	 * @generated
	 */
	EAttribute getZNode_AclVersion();

	/**
	 * Returns the meta object for the attribute '{@link org.apache.hadoop.eclipse.internal.model.ZNode#getEphermalOwnerSessionId <em>Ephermal Owner Session Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Ephermal Owner Session Id</em>'.
	 * @see org.apache.hadoop.eclipse.internal.model.ZNode#getEphermalOwnerSessionId()
	 * @see #getZNode()
	 * @generated
	 */
	EAttribute getZNode_EphermalOwnerSessionId();

	/**
	 * Returns the meta object for the attribute '{@link org.apache.hadoop.eclipse.internal.model.ZNode#getDataLength <em>Data Length</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Data Length</em>'.
	 * @see org.apache.hadoop.eclipse.internal.model.ZNode#getDataLength()
	 * @see #getZNode()
	 * @generated
	 */
	EAttribute getZNode_DataLength();

	/**
	 * Returns the meta object for the attribute '{@link org.apache.hadoop.eclipse.internal.model.ZNode#getChildrenCount <em>Children Count</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Children Count</em>'.
	 * @see org.apache.hadoop.eclipse.internal.model.ZNode#getChildrenCount()
	 * @see #getZNode()
	 * @generated
	 */
	EAttribute getZNode_ChildrenCount();

	/**
	 * Returns the meta object for the reference '{@link org.apache.hadoop.eclipse.internal.model.ZNode#getParent <em>Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Parent</em>'.
	 * @see org.apache.hadoop.eclipse.internal.model.ZNode#getParent()
	 * @see #getZNode()
	 * @generated
	 */
	EReference getZNode_Parent();

	/**
	 * Returns the meta object for the attribute '{@link org.apache.hadoop.eclipse.internal.model.ZNode#getNodeName <em>Node Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Node Name</em>'.
	 * @see org.apache.hadoop.eclipse.internal.model.ZNode#getNodeName()
	 * @see #getZNode()
	 * @generated
	 */
	EAttribute getZNode_NodeName();

	/**
	 * Returns the meta object for enum '{@link org.apache.hadoop.eclipse.internal.model.ServerStatus <em>Server Status</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Server Status</em>'.
	 * @see org.apache.hadoop.eclipse.internal.model.ServerStatus
	 * @generated
	 */
	EEnum getServerStatus();

	/**
	 * Returns the meta object for enum '{@link org.apache.hadoop.eclipse.internal.model.ZNodeType <em>ZNode Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>ZNode Type</em>'.
	 * @see org.apache.hadoop.eclipse.internal.model.ZNodeType
	 * @generated
	 */
	EEnum getZNodeType();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	HadoopFactory getHadoopFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.apache.hadoop.eclipse.internal.model.impl.HDFSServerImpl <em>HDFS Server</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.apache.hadoop.eclipse.internal.model.impl.HDFSServerImpl
		 * @see org.apache.hadoop.eclipse.internal.model.impl.HadoopPackageImpl#getHDFSServer()
		 * @generated
		 */
		EClass HDFS_SERVER = eINSTANCE.getHDFSServer();

		/**
		 * The meta object literal for the '<em><b>Loaded</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute HDFS_SERVER__LOADED = eINSTANCE.getHDFSServer_Loaded();

		/**
		 * The meta object literal for the '<em><b>Operation UR Is</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute HDFS_SERVER__OPERATION_UR_IS = eINSTANCE.getHDFSServer_OperationURIs();

		/**
		 * The meta object literal for the '<em><b>User Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute HDFS_SERVER__USER_ID = eINSTANCE.getHDFSServer_UserId();

		/**
		 * The meta object literal for the '<em><b>Group Ids</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute HDFS_SERVER__GROUP_IDS = eINSTANCE.getHDFSServer_GroupIds();

		/**
		 * The meta object literal for the '{@link org.apache.hadoop.eclipse.internal.model.impl.ServersImpl <em>Servers</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.apache.hadoop.eclipse.internal.model.impl.ServersImpl
		 * @see org.apache.hadoop.eclipse.internal.model.impl.HadoopPackageImpl#getServers()
		 * @generated
		 */
		EClass SERVERS = eINSTANCE.getServers();

		/**
		 * The meta object literal for the '<em><b>Hdfs Servers</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SERVERS__HDFS_SERVERS = eINSTANCE.getServers_HdfsServers();

		/**
		 * The meta object literal for the '<em><b>Version</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERVERS__VERSION = eINSTANCE.getServers_Version();

		/**
		 * The meta object literal for the '<em><b>Zookeeper Servers</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SERVERS__ZOOKEEPER_SERVERS = eINSTANCE.getServers_ZookeeperServers();

		/**
		 * The meta object literal for the '{@link org.apache.hadoop.eclipse.internal.model.impl.ServerImpl <em>Server</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.apache.hadoop.eclipse.internal.model.impl.ServerImpl
		 * @see org.apache.hadoop.eclipse.internal.model.impl.HadoopPackageImpl#getServer()
		 * @generated
		 */
		EClass SERVER = eINSTANCE.getServer();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERVER__NAME = eINSTANCE.getServer_Name();

		/**
		 * The meta object literal for the '<em><b>Uri</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERVER__URI = eINSTANCE.getServer_Uri();

		/**
		 * The meta object literal for the '<em><b>Status Code</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERVER__STATUS_CODE = eINSTANCE.getServer_StatusCode();

		/**
		 * The meta object literal for the '<em><b>Status Message</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERVER__STATUS_MESSAGE = eINSTANCE.getServer_StatusMessage();

		/**
		 * The meta object literal for the '<em><b>Last Accessed</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERVER__LAST_ACCESSED = eINSTANCE.getServer_LastAccessed();

		/**
		 * The meta object literal for the '{@link org.apache.hadoop.eclipse.internal.model.impl.ZooKeeperServerImpl <em>Zoo Keeper Server</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.apache.hadoop.eclipse.internal.model.impl.ZooKeeperServerImpl
		 * @see org.apache.hadoop.eclipse.internal.model.impl.HadoopPackageImpl#getZooKeeperServer()
		 * @generated
		 */
		EClass ZOO_KEEPER_SERVER = eINSTANCE.getZooKeeperServer();

		/**
		 * The meta object literal for the '{@link org.apache.hadoop.eclipse.internal.model.impl.ZNodeImpl <em>ZNode</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.apache.hadoop.eclipse.internal.model.impl.ZNodeImpl
		 * @see org.apache.hadoop.eclipse.internal.model.impl.HadoopPackageImpl#getZNode()
		 * @generated
		 */
		EClass ZNODE = eINSTANCE.getZNode();

		/**
		 * The meta object literal for the '<em><b>Children</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ZNODE__CHILDREN = eINSTANCE.getZNode_Children();

		/**
		 * The meta object literal for the '<em><b>Last Refresh</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ZNODE__LAST_REFRESH = eINSTANCE.getZNode_LastRefresh();

		/**
		 * The meta object literal for the '<em><b>Refreshing</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ZNODE__REFRESHING = eINSTANCE.getZNode_Refreshing();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ZNODE__TYPE = eINSTANCE.getZNode_Type();

		/**
		 * The meta object literal for the '<em><b>Creation Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ZNODE__CREATION_ID = eINSTANCE.getZNode_CreationId();

		/**
		 * The meta object literal for the '<em><b>Modified Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ZNODE__MODIFIED_ID = eINSTANCE.getZNode_ModifiedId();

		/**
		 * The meta object literal for the '<em><b>Creation Time</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ZNODE__CREATION_TIME = eINSTANCE.getZNode_CreationTime();

		/**
		 * The meta object literal for the '<em><b>Modified Time</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ZNODE__MODIFIED_TIME = eINSTANCE.getZNode_ModifiedTime();

		/**
		 * The meta object literal for the '<em><b>Version</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ZNODE__VERSION = eINSTANCE.getZNode_Version();

		/**
		 * The meta object literal for the '<em><b>Children Version</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ZNODE__CHILDREN_VERSION = eINSTANCE.getZNode_ChildrenVersion();

		/**
		 * The meta object literal for the '<em><b>Acl Version</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ZNODE__ACL_VERSION = eINSTANCE.getZNode_AclVersion();

		/**
		 * The meta object literal for the '<em><b>Ephermal Owner Session Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ZNODE__EPHERMAL_OWNER_SESSION_ID = eINSTANCE.getZNode_EphermalOwnerSessionId();

		/**
		 * The meta object literal for the '<em><b>Data Length</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ZNODE__DATA_LENGTH = eINSTANCE.getZNode_DataLength();

		/**
		 * The meta object literal for the '<em><b>Children Count</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ZNODE__CHILDREN_COUNT = eINSTANCE.getZNode_ChildrenCount();

		/**
		 * The meta object literal for the '<em><b>Parent</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ZNODE__PARENT = eINSTANCE.getZNode_Parent();

		/**
		 * The meta object literal for the '<em><b>Node Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ZNODE__NODE_NAME = eINSTANCE.getZNode_NodeName();

		/**
		 * The meta object literal for the '{@link org.apache.hadoop.eclipse.internal.model.ServerStatus <em>Server Status</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.apache.hadoop.eclipse.internal.model.ServerStatus
		 * @see org.apache.hadoop.eclipse.internal.model.impl.HadoopPackageImpl#getServerStatus()
		 * @generated
		 */
		EEnum SERVER_STATUS = eINSTANCE.getServerStatus();

		/**
		 * The meta object literal for the '{@link org.apache.hadoop.eclipse.internal.model.ZNodeType <em>ZNode Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.apache.hadoop.eclipse.internal.model.ZNodeType
		 * @see org.apache.hadoop.eclipse.internal.model.impl.HadoopPackageImpl#getZNodeType()
		 * @generated
		 */
		EEnum ZNODE_TYPE = eINSTANCE.getZNodeType();

	}

} //HadoopPackage
