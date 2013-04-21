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
import org.apache.hadoop.eclipse.internal.model.ServerStatus;
import org.apache.hadoop.eclipse.internal.model.Servers;

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
	public EAttribute getHDFSServer_Name() {
		return (EAttribute)hdfsServerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getHDFSServer_Uri() {
		return (EAttribute)hdfsServerEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getHDFSServer_StatusCode() {
		return (EAttribute)hdfsServerEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getHDFSServer_StatusMessage() {
		return (EAttribute)hdfsServerEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getHDFSServer_LastAccessed() {
		return (EAttribute)hdfsServerEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getHDFSServer_Loaded() {
		return (EAttribute)hdfsServerEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getHDFSServer_WorkspaceProjectName() {
		return (EAttribute)hdfsServerEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getHDFSServer_OperationURIs() {
		return (EAttribute)hdfsServerEClass.getEStructuralFeatures().get(7);
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
		createEAttribute(hdfsServerEClass, HDFS_SERVER__NAME);
		createEAttribute(hdfsServerEClass, HDFS_SERVER__URI);
		createEAttribute(hdfsServerEClass, HDFS_SERVER__STATUS_CODE);
		createEAttribute(hdfsServerEClass, HDFS_SERVER__STATUS_MESSAGE);
		createEAttribute(hdfsServerEClass, HDFS_SERVER__LAST_ACCESSED);
		createEAttribute(hdfsServerEClass, HDFS_SERVER__LOADED);
		createEAttribute(hdfsServerEClass, HDFS_SERVER__WORKSPACE_PROJECT_NAME);
		createEAttribute(hdfsServerEClass, HDFS_SERVER__OPERATION_UR_IS);

		serversEClass = createEClass(SERVERS);
		createEReference(serversEClass, SERVERS__HDFS_SERVERS);
		createEAttribute(serversEClass, SERVERS__VERSION);

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

		// Initialize classes and features; add operations and parameters
		initEClass(hdfsServerEClass, HDFSServer.class, "HDFSServer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getHDFSServer_Name(), ecorePackage.getEString(), "name", "", 0, 1, HDFSServer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getHDFSServer_Uri(), ecorePackage.getEString(), "uri", null, 0, 1, HDFSServer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getHDFSServer_StatusCode(), ecorePackage.getEInt(), "statusCode", "-1", 0, 1, HDFSServer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getHDFSServer_StatusMessage(), ecorePackage.getEString(), "statusMessage", null, 0, 1, HDFSServer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getHDFSServer_LastAccessed(), ecorePackage.getELong(), "lastAccessed", "-1", 0, 1, HDFSServer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getHDFSServer_Loaded(), ecorePackage.getEBoolean(), "loaded", null, 0, 1, HDFSServer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getHDFSServer_WorkspaceProjectName(), ecorePackage.getEString(), "workspaceProjectName", null, 0, 1, HDFSServer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getHDFSServer_OperationURIs(), ecorePackage.getEString(), "operationURIs", null, 0, -1, HDFSServer.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(serversEClass, Servers.class, "Servers", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getServers_HdfsServers(), this.getHDFSServer(), null, "hdfsServers", null, 0, -1, Servers.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getServers_Version(), ecorePackage.getEString(), "version", "1.0.0.0", 0, 1, Servers.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(serverStatusEEnum, ServerStatus.class, "ServerStatus");
		addEEnumLiteral(serverStatusEEnum, ServerStatus.NO_PROJECT);

		// Create resource
		createResource(eNS_URI);
	}

} //HadoopPackageImpl
