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
 *   <li>{@link org.apache.hadoop.eclipse.internal.model.HDFSServer#isLoaded <em>Loaded</em>}</li>
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
public interface HDFSServer extends Server {
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
