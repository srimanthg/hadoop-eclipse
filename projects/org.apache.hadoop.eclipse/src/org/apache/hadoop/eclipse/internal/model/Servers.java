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
 * A representation of the model object '<em><b>Servers</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.apache.hadoop.eclipse.internal.model.Servers#getHdfsServers <em>Hdfs Servers</em>}</li>
 *   <li>{@link org.apache.hadoop.eclipse.internal.model.Servers#getVersion <em>Version</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.apache.hadoop.eclipse.internal.model.HadoopPackage#getServers()
 * @model
 * @generated
 */
public interface Servers extends EObject {
	/**
	 * Returns the value of the '<em><b>Hdfs Servers</b></em>' reference list.
	 * The list contents are of type {@link org.apache.hadoop.eclipse.internal.model.HDFSServer}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Hdfs Servers</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Hdfs Servers</em>' reference list.
	 * @see org.apache.hadoop.eclipse.internal.model.HadoopPackage#getServers_HdfsServers()
	 * @model
	 * @generated
	 */
	EList<HDFSServer> getHdfsServers();

	/**
	 * Returns the value of the '<em><b>Version</b></em>' attribute.
	 * The default value is <code>"1.0.0.0"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Version</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Version</em>' attribute.
	 * @see #setVersion(String)
	 * @see org.apache.hadoop.eclipse.internal.model.HadoopPackage#getServers_Version()
	 * @model default="1.0.0.0"
	 * @generated
	 */
	String getVersion();

	/**
	 * Sets the value of the '{@link org.apache.hadoop.eclipse.internal.model.Servers#getVersion <em>Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Version</em>' attribute.
	 * @see #getVersion()
	 * @generated
	 */
	void setVersion(String value);

} // Servers
