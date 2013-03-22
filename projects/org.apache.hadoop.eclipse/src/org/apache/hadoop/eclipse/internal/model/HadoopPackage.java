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
	int HDFS_SERVER__NAME = 0;

	/**
	 * The feature id for the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HDFS_SERVER__URI = 1;

	/**
	 * The feature id for the '<em><b>Status Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HDFS_SERVER__STATUS_CODE = 2;

	/**
	 * The feature id for the '<em><b>Status Message</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HDFS_SERVER__STATUS_MESSAGE = 3;

	/**
	 * The feature id for the '<em><b>Last Accessed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HDFS_SERVER__LAST_ACCESSED = 4;

	/**
	 * The feature id for the '<em><b>Loaded</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HDFS_SERVER__LOADED = 5;

	/**
	 * The feature id for the '<em><b>Workspace Project Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HDFS_SERVER__WORKSPACE_PROJECT_NAME = 6;

	/**
	 * The number of structural features of the '<em>HDFS Server</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HDFS_SERVER_FEATURE_COUNT = 7;

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
	 * The feature id for the '<em><b>Hdfs Servers</b></em>' reference list.
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
	 * The number of structural features of the '<em>Servers</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVERS_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.apache.hadoop.eclipse.internal.model.ServerStatus <em>Server Status</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.apache.hadoop.eclipse.internal.model.ServerStatus
	 * @see org.apache.hadoop.eclipse.internal.model.impl.HadoopPackageImpl#getServerStatus()
	 * @generated
	 */
	int SERVER_STATUS = 2;


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
	 * Returns the meta object for the attribute '{@link org.apache.hadoop.eclipse.internal.model.HDFSServer#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.apache.hadoop.eclipse.internal.model.HDFSServer#getName()
	 * @see #getHDFSServer()
	 * @generated
	 */
	EAttribute getHDFSServer_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.apache.hadoop.eclipse.internal.model.HDFSServer#getUri <em>Uri</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Uri</em>'.
	 * @see org.apache.hadoop.eclipse.internal.model.HDFSServer#getUri()
	 * @see #getHDFSServer()
	 * @generated
	 */
	EAttribute getHDFSServer_Uri();

	/**
	 * Returns the meta object for the attribute '{@link org.apache.hadoop.eclipse.internal.model.HDFSServer#getStatusCode <em>Status Code</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Status Code</em>'.
	 * @see org.apache.hadoop.eclipse.internal.model.HDFSServer#getStatusCode()
	 * @see #getHDFSServer()
	 * @generated
	 */
	EAttribute getHDFSServer_StatusCode();

	/**
	 * Returns the meta object for the attribute '{@link org.apache.hadoop.eclipse.internal.model.HDFSServer#getStatusMessage <em>Status Message</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Status Message</em>'.
	 * @see org.apache.hadoop.eclipse.internal.model.HDFSServer#getStatusMessage()
	 * @see #getHDFSServer()
	 * @generated
	 */
	EAttribute getHDFSServer_StatusMessage();

	/**
	 * Returns the meta object for the attribute '{@link org.apache.hadoop.eclipse.internal.model.HDFSServer#getLastAccessed <em>Last Accessed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Last Accessed</em>'.
	 * @see org.apache.hadoop.eclipse.internal.model.HDFSServer#getLastAccessed()
	 * @see #getHDFSServer()
	 * @generated
	 */
	EAttribute getHDFSServer_LastAccessed();

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
	 * Returns the meta object for the attribute '{@link org.apache.hadoop.eclipse.internal.model.HDFSServer#getWorkspaceProjectName <em>Workspace Project Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Workspace Project Name</em>'.
	 * @see org.apache.hadoop.eclipse.internal.model.HDFSServer#getWorkspaceProjectName()
	 * @see #getHDFSServer()
	 * @generated
	 */
	EAttribute getHDFSServer_WorkspaceProjectName();

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
	 * Returns the meta object for the reference list '{@link org.apache.hadoop.eclipse.internal.model.Servers#getHdfsServers <em>Hdfs Servers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Hdfs Servers</em>'.
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
	 * Returns the meta object for enum '{@link org.apache.hadoop.eclipse.internal.model.ServerStatus <em>Server Status</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Server Status</em>'.
	 * @see org.apache.hadoop.eclipse.internal.model.ServerStatus
	 * @generated
	 */
	EEnum getServerStatus();

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
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute HDFS_SERVER__NAME = eINSTANCE.getHDFSServer_Name();

		/**
		 * The meta object literal for the '<em><b>Uri</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute HDFS_SERVER__URI = eINSTANCE.getHDFSServer_Uri();

		/**
		 * The meta object literal for the '<em><b>Status Code</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute HDFS_SERVER__STATUS_CODE = eINSTANCE.getHDFSServer_StatusCode();

		/**
		 * The meta object literal for the '<em><b>Status Message</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute HDFS_SERVER__STATUS_MESSAGE = eINSTANCE.getHDFSServer_StatusMessage();

		/**
		 * The meta object literal for the '<em><b>Last Accessed</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute HDFS_SERVER__LAST_ACCESSED = eINSTANCE.getHDFSServer_LastAccessed();

		/**
		 * The meta object literal for the '<em><b>Loaded</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute HDFS_SERVER__LOADED = eINSTANCE.getHDFSServer_Loaded();

		/**
		 * The meta object literal for the '<em><b>Workspace Project Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute HDFS_SERVER__WORKSPACE_PROJECT_NAME = eINSTANCE.getHDFSServer_WorkspaceProjectName();

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
		 * The meta object literal for the '<em><b>Hdfs Servers</b></em>' reference list feature.
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
		 * The meta object literal for the '{@link org.apache.hadoop.eclipse.internal.model.ServerStatus <em>Server Status</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.apache.hadoop.eclipse.internal.model.ServerStatus
		 * @see org.apache.hadoop.eclipse.internal.model.impl.HadoopPackageImpl#getServerStatus()
		 * @generated
		 */
		EEnum SERVER_STATUS = eINSTANCE.getServerStatus();

	}

} //HadoopPackage
