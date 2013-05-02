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

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>HDFS Server</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.apache.hadoop.eclipse.internal.model.HDFSServer#getName <em>Name</em>}</li>
 *   <li>{@link org.apache.hadoop.eclipse.internal.model.HDFSServer#getUri <em>Uri</em>}</li>
 *   <li>{@link org.apache.hadoop.eclipse.internal.model.HDFSServer#getStatusCode <em>Status Code</em>}</li>
 *   <li>{@link org.apache.hadoop.eclipse.internal.model.HDFSServer#getStatusMessage <em>Status Message</em>}</li>
 *   <li>{@link org.apache.hadoop.eclipse.internal.model.HDFSServer#getLastAccessed <em>Last Accessed</em>}</li>
 *   <li>{@link org.apache.hadoop.eclipse.internal.model.HDFSServer#isLoaded <em>Loaded</em>}</li>
 *   <li>{@link org.apache.hadoop.eclipse.internal.model.HDFSServer#getWorkspaceProjectName <em>Workspace Project Name</em>}</li>
 *   <li>{@link org.apache.hadoop.eclipse.internal.model.HDFSServer#getOperationURIs <em>Operation UR Is</em>}</li>
 *   <li>{@link org.apache.hadoop.eclipse.internal.model.HDFSServer#getUserId <em>User Id</em>}</li>
 *   <li>{@link org.apache.hadoop.eclipse.internal.model.HDFSServer#getGroupIds <em>Group Ids</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.apache.hadoop.eclipse.internal.model.HadoopPackage#getHDFSServer()
 * @model
 * @generated
 */
public interface HDFSServer extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.apache.hadoop.eclipse.internal.model.HadoopPackage#getHDFSServer_Name()
	 * @model default=""
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.apache.hadoop.eclipse.internal.model.HDFSServer#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * This is URI location for the HDFS server. Ex: hdfs://hdfs.server.hostname/path.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Uri</em>' attribute.
	 * @see #setUri(String)
	 * @see org.apache.hadoop.eclipse.internal.model.HadoopPackage#getHDFSServer_Uri()
	 * @model
	 * @generated
	 */
	String getUri();

	/**
	 * Sets the value of the '{@link org.apache.hadoop.eclipse.internal.model.HDFSServer#getUri <em>Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Uri</em>' attribute.
	 * @see #getUri()
	 * @generated
	 */
	void setUri(String value);

	/**
	 * Returns the value of the '<em><b>Status Code</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Indicates the status of this server. Values could be from HTTP response codes to indicate server status.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Status Code</em>' attribute.
	 * @see #setStatusCode(int)
	 * @see org.apache.hadoop.eclipse.internal.model.HadoopPackage#getHDFSServer_StatusCode()
	 * @model default="0" transient="true"
	 * @generated
	 */
	int getStatusCode();

	/**
	 * Sets the value of the '{@link org.apache.hadoop.eclipse.internal.model.HDFSServer#getStatusCode <em>Status Code</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Status Code</em>' attribute.
	 * @see #getStatusCode()
	 * @generated
	 */
	void setStatusCode(int value);

	/**
	 * Returns the value of the '<em><b>Status Message</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Status Message</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Status Message</em>' attribute.
	 * @see #setStatusMessage(String)
	 * @see org.apache.hadoop.eclipse.internal.model.HadoopPackage#getHDFSServer_StatusMessage()
	 * @model
	 * @generated
	 */
	String getStatusMessage();

	/**
	 * Sets the value of the '{@link org.apache.hadoop.eclipse.internal.model.HDFSServer#getStatusMessage <em>Status Message</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Status Message</em>' attribute.
	 * @see #getStatusMessage()
	 * @generated
	 */
	void setStatusMessage(String value);

	/**
	 * Returns the value of the '<em><b>Last Accessed</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Last Accessed</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Last Accessed</em>' attribute.
	 * @see #setLastAccessed(long)
	 * @see org.apache.hadoop.eclipse.internal.model.HadoopPackage#getHDFSServer_LastAccessed()
	 * @model default="-1"
	 * @generated
	 */
	long getLastAccessed();

	/**
	 * Sets the value of the '{@link org.apache.hadoop.eclipse.internal.model.HDFSServer#getLastAccessed <em>Last Accessed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Last Accessed</em>' attribute.
	 * @see #getLastAccessed()
	 * @generated
	 */
	void setLastAccessed(long value);

	/**
	 * Returns the value of the '<em><b>Loaded</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Loaded</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Loaded</em>' attribute.
	 * @see #setLoaded(boolean)
	 * @see org.apache.hadoop.eclipse.internal.model.HadoopPackage#getHDFSServer_Loaded()
	 * @model
	 * @generated
	 */
	boolean isLoaded();

	/**
	 * Sets the value of the '{@link org.apache.hadoop.eclipse.internal.model.HDFSServer#isLoaded <em>Loaded</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Loaded</em>' attribute.
	 * @see #isLoaded()
	 * @generated
	 */
	void setLoaded(boolean value);

	/**
	 * Returns the value of the '<em><b>Workspace Project Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Workspace Project Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Workspace Project Name</em>' attribute.
	 * @see #setWorkspaceProjectName(String)
	 * @see org.apache.hadoop.eclipse.internal.model.HadoopPackage#getHDFSServer_WorkspaceProjectName()
	 * @model
	 * @generated
	 */
	String getWorkspaceProjectName();

	/**
	 * Sets the value of the '{@link org.apache.hadoop.eclipse.internal.model.HDFSServer#getWorkspaceProjectName <em>Workspace Project Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Workspace Project Name</em>' attribute.
	 * @see #getWorkspaceProjectName()
	 * @generated
	 */
	void setWorkspaceProjectName(String value);

	/**
	 * Returns the value of the '<em><b>Operation UR Is</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * List of HDFS uris where operations are being performed.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Operation UR Is</em>' attribute list.
	 * @see org.apache.hadoop.eclipse.internal.model.HadoopPackage#getHDFSServer_OperationURIs()
	 * @model transient="true"
	 * @generated
	 */
	EList<String> getOperationURIs();

	/**
	 * Returns the value of the '<em><b>User Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>User Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>User Id</em>' attribute.
	 * @see #setUserId(String)
	 * @see org.apache.hadoop.eclipse.internal.model.HadoopPackage#getHDFSServer_UserId()
	 * @model
	 * @generated
	 */
	String getUserId();

	/**
	 * Sets the value of the '{@link org.apache.hadoop.eclipse.internal.model.HDFSServer#getUserId <em>User Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>User Id</em>' attribute.
	 * @see #getUserId()
	 * @generated
	 */
	void setUserId(String value);

	/**
	 * Returns the value of the '<em><b>Group Ids</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Group Ids</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Group Ids</em>' attribute list.
	 * @see org.apache.hadoop.eclipse.internal.model.HadoopPackage#getHDFSServer_GroupIds()
	 * @model
	 * @generated
	 */
	EList<String> getGroupIds();

} // HDFSServer
