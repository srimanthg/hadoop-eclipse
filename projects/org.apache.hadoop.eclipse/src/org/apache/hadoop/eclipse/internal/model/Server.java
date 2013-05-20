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

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Server</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.apache.hadoop.eclipse.internal.model.Server#getName <em>Name</em>}</li>
 *   <li>{@link org.apache.hadoop.eclipse.internal.model.Server#getUri <em>Uri</em>}</li>
 *   <li>{@link org.apache.hadoop.eclipse.internal.model.Server#getStatusCode <em>Status Code</em>}</li>
 *   <li>{@link org.apache.hadoop.eclipse.internal.model.Server#getStatusMessage <em>Status Message</em>}</li>
 *   <li>{@link org.apache.hadoop.eclipse.internal.model.Server#getLastAccessed <em>Last Accessed</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.apache.hadoop.eclipse.internal.model.HadoopPackage#getServer()
 * @model abstract="true"
 * @generated
 */
public interface Server extends EObject {
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
	 * @see org.apache.hadoop.eclipse.internal.model.HadoopPackage#getServer_Name()
	 * @model default=""
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.apache.hadoop.eclipse.internal.model.Server#getName <em>Name</em>}' attribute.
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
	 * @see org.apache.hadoop.eclipse.internal.model.HadoopPackage#getServer_Uri()
	 * @model
	 * @generated
	 */
	String getUri();

	/**
	 * Sets the value of the '{@link org.apache.hadoop.eclipse.internal.model.Server#getUri <em>Uri</em>}' attribute.
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
	 * @see org.apache.hadoop.eclipse.internal.model.HadoopPackage#getServer_StatusCode()
	 * @model default="0" transient="true"
	 * @generated
	 */
	int getStatusCode();

	/**
	 * Sets the value of the '{@link org.apache.hadoop.eclipse.internal.model.Server#getStatusCode <em>Status Code</em>}' attribute.
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
	 * @see org.apache.hadoop.eclipse.internal.model.HadoopPackage#getServer_StatusMessage()
	 * @model
	 * @generated
	 */
	String getStatusMessage();

	/**
	 * Sets the value of the '{@link org.apache.hadoop.eclipse.internal.model.Server#getStatusMessage <em>Status Message</em>}' attribute.
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
	 * @see org.apache.hadoop.eclipse.internal.model.HadoopPackage#getServer_LastAccessed()
	 * @model default="-1"
	 * @generated
	 */
	long getLastAccessed();

	/**
	 * Sets the value of the '{@link org.apache.hadoop.eclipse.internal.model.Server#getLastAccessed <em>Last Accessed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Last Accessed</em>' attribute.
	 * @see #getLastAccessed()
	 * @generated
	 */
	void setLastAccessed(long value);

} // Server
