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
 * A representation of the model object '<em><b>ZNode</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.apache.hadoop.eclipse.internal.model.ZNode#getChildren <em>Children</em>}</li>
 *   <li>{@link org.apache.hadoop.eclipse.internal.model.ZNode#getLastRefresh <em>Last Refresh</em>}</li>
 *   <li>{@link org.apache.hadoop.eclipse.internal.model.ZNode#isRefreshing <em>Refreshing</em>}</li>
 *   <li>{@link org.apache.hadoop.eclipse.internal.model.ZNode#getType <em>Type</em>}</li>
 *   <li>{@link org.apache.hadoop.eclipse.internal.model.ZNode#getCreationId <em>Creation Id</em>}</li>
 *   <li>{@link org.apache.hadoop.eclipse.internal.model.ZNode#getModifiedId <em>Modified Id</em>}</li>
 *   <li>{@link org.apache.hadoop.eclipse.internal.model.ZNode#getCreationTime <em>Creation Time</em>}</li>
 *   <li>{@link org.apache.hadoop.eclipse.internal.model.ZNode#getModifiedTime <em>Modified Time</em>}</li>
 *   <li>{@link org.apache.hadoop.eclipse.internal.model.ZNode#getVersion <em>Version</em>}</li>
 *   <li>{@link org.apache.hadoop.eclipse.internal.model.ZNode#getChildrenVersion <em>Children Version</em>}</li>
 *   <li>{@link org.apache.hadoop.eclipse.internal.model.ZNode#getAclVersion <em>Acl Version</em>}</li>
 *   <li>{@link org.apache.hadoop.eclipse.internal.model.ZNode#getEphermalOwnerSessionId <em>Ephermal Owner Session Id</em>}</li>
 *   <li>{@link org.apache.hadoop.eclipse.internal.model.ZNode#getDataLength <em>Data Length</em>}</li>
 *   <li>{@link org.apache.hadoop.eclipse.internal.model.ZNode#getChildrenCount <em>Children Count</em>}</li>
 *   <li>{@link org.apache.hadoop.eclipse.internal.model.ZNode#getParent <em>Parent</em>}</li>
 *   <li>{@link org.apache.hadoop.eclipse.internal.model.ZNode#getNodeName <em>Node Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.apache.hadoop.eclipse.internal.model.HadoopPackage#getZNode()
 * @model
 * @generated
 */
public interface ZNode extends EObject {
	/**
	 * Returns the value of the '<em><b>Children</b></em>' containment reference list.
	 * The list contents are of type {@link org.apache.hadoop.eclipse.internal.model.ZNode}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Children</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Children</em>' containment reference list.
	 * @see org.apache.hadoop.eclipse.internal.model.HadoopPackage#getZNode_Children()
	 * @model containment="true" transient="true"
	 * @generated
	 */
	EList<ZNode> getChildren();

	/**
	 * Returns the value of the '<em><b>Last Refresh</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Last Refresh</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Last Refresh</em>' attribute.
	 * @see #setLastRefresh(long)
	 * @see org.apache.hadoop.eclipse.internal.model.HadoopPackage#getZNode_LastRefresh()
	 * @model default="-1"
	 * @generated
	 */
	long getLastRefresh();

	/**
	 * Sets the value of the '{@link org.apache.hadoop.eclipse.internal.model.ZNode#getLastRefresh <em>Last Refresh</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Last Refresh</em>' attribute.
	 * @see #getLastRefresh()
	 * @generated
	 */
	void setLastRefresh(long value);

	/**
	 * Returns the value of the '<em><b>Refreshing</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Refreshing</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Refreshing</em>' attribute.
	 * @see #setRefreshing(boolean)
	 * @see org.apache.hadoop.eclipse.internal.model.HadoopPackage#getZNode_Refreshing()
	 * @model
	 * @generated
	 */
	boolean isRefreshing();

	/**
	 * Sets the value of the '{@link org.apache.hadoop.eclipse.internal.model.ZNode#isRefreshing <em>Refreshing</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Refreshing</em>' attribute.
	 * @see #isRefreshing()
	 * @generated
	 */
	void setRefreshing(boolean value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.apache.hadoop.eclipse.internal.model.ZNodeType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see org.apache.hadoop.eclipse.internal.model.ZNodeType
	 * @see #setType(ZNodeType)
	 * @see org.apache.hadoop.eclipse.internal.model.HadoopPackage#getZNode_Type()
	 * @model transient="true"
	 * @generated
	 */
	ZNodeType getType();

	/**
	 * Sets the value of the '{@link org.apache.hadoop.eclipse.internal.model.ZNode#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see org.apache.hadoop.eclipse.internal.model.ZNodeType
	 * @see #getType()
	 * @generated
	 */
	void setType(ZNodeType value);

	/**
	 * Returns the value of the '<em><b>Creation Id</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Creation Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Creation Id</em>' attribute.
	 * @see #setCreationId(long)
	 * @see org.apache.hadoop.eclipse.internal.model.HadoopPackage#getZNode_CreationId()
	 * @model default="-1"
	 * @generated
	 */
	long getCreationId();

	/**
	 * Sets the value of the '{@link org.apache.hadoop.eclipse.internal.model.ZNode#getCreationId <em>Creation Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Creation Id</em>' attribute.
	 * @see #getCreationId()
	 * @generated
	 */
	void setCreationId(long value);

	/**
	 * Returns the value of the '<em><b>Modified Id</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Modified Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Modified Id</em>' attribute.
	 * @see #setModifiedId(long)
	 * @see org.apache.hadoop.eclipse.internal.model.HadoopPackage#getZNode_ModifiedId()
	 * @model default="-1"
	 * @generated
	 */
	long getModifiedId();

	/**
	 * Sets the value of the '{@link org.apache.hadoop.eclipse.internal.model.ZNode#getModifiedId <em>Modified Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Modified Id</em>' attribute.
	 * @see #getModifiedId()
	 * @generated
	 */
	void setModifiedId(long value);

	/**
	 * Returns the value of the '<em><b>Creation Time</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Creation Time</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Creation Time</em>' attribute.
	 * @see #setCreationTime(long)
	 * @see org.apache.hadoop.eclipse.internal.model.HadoopPackage#getZNode_CreationTime()
	 * @model default="-1"
	 * @generated
	 */
	long getCreationTime();

	/**
	 * Sets the value of the '{@link org.apache.hadoop.eclipse.internal.model.ZNode#getCreationTime <em>Creation Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Creation Time</em>' attribute.
	 * @see #getCreationTime()
	 * @generated
	 */
	void setCreationTime(long value);

	/**
	 * Returns the value of the '<em><b>Modified Time</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Modified Time</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Modified Time</em>' attribute.
	 * @see #setModifiedTime(long)
	 * @see org.apache.hadoop.eclipse.internal.model.HadoopPackage#getZNode_ModifiedTime()
	 * @model default="-1"
	 * @generated
	 */
	long getModifiedTime();

	/**
	 * Sets the value of the '{@link org.apache.hadoop.eclipse.internal.model.ZNode#getModifiedTime <em>Modified Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Modified Time</em>' attribute.
	 * @see #getModifiedTime()
	 * @generated
	 */
	void setModifiedTime(long value);

	/**
	 * Returns the value of the '<em><b>Version</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Version</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Version</em>' attribute.
	 * @see #setVersion(int)
	 * @see org.apache.hadoop.eclipse.internal.model.HadoopPackage#getZNode_Version()
	 * @model default="-1" transient="true"
	 * @generated
	 */
	int getVersion();

	/**
	 * Sets the value of the '{@link org.apache.hadoop.eclipse.internal.model.ZNode#getVersion <em>Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Version</em>' attribute.
	 * @see #getVersion()
	 * @generated
	 */
	void setVersion(int value);

	/**
	 * Returns the value of the '<em><b>Children Version</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Children Version</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Children Version</em>' attribute.
	 * @see #setChildrenVersion(int)
	 * @see org.apache.hadoop.eclipse.internal.model.HadoopPackage#getZNode_ChildrenVersion()
	 * @model default="-1" transient="true"
	 * @generated
	 */
	int getChildrenVersion();

	/**
	 * Sets the value of the '{@link org.apache.hadoop.eclipse.internal.model.ZNode#getChildrenVersion <em>Children Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Children Version</em>' attribute.
	 * @see #getChildrenVersion()
	 * @generated
	 */
	void setChildrenVersion(int value);

	/**
	 * Returns the value of the '<em><b>Acl Version</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Acl Version</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Acl Version</em>' attribute.
	 * @see #setAclVersion(int)
	 * @see org.apache.hadoop.eclipse.internal.model.HadoopPackage#getZNode_AclVersion()
	 * @model default="-1"
	 * @generated
	 */
	int getAclVersion();

	/**
	 * Sets the value of the '{@link org.apache.hadoop.eclipse.internal.model.ZNode#getAclVersion <em>Acl Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Acl Version</em>' attribute.
	 * @see #getAclVersion()
	 * @generated
	 */
	void setAclVersion(int value);

	/**
	 * Returns the value of the '<em><b>Ephermal Owner Session Id</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ephermal Owner Session Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ephermal Owner Session Id</em>' attribute.
	 * @see #setEphermalOwnerSessionId(long)
	 * @see org.apache.hadoop.eclipse.internal.model.HadoopPackage#getZNode_EphermalOwnerSessionId()
	 * @model default="-1"
	 * @generated
	 */
	long getEphermalOwnerSessionId();

	/**
	 * Sets the value of the '{@link org.apache.hadoop.eclipse.internal.model.ZNode#getEphermalOwnerSessionId <em>Ephermal Owner Session Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ephermal Owner Session Id</em>' attribute.
	 * @see #getEphermalOwnerSessionId()
	 * @generated
	 */
	void setEphermalOwnerSessionId(long value);

	/**
	 * Returns the value of the '<em><b>Data Length</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Data Length</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Data Length</em>' attribute.
	 * @see #setDataLength(int)
	 * @see org.apache.hadoop.eclipse.internal.model.HadoopPackage#getZNode_DataLength()
	 * @model default="-1"
	 * @generated
	 */
	int getDataLength();

	/**
	 * Sets the value of the '{@link org.apache.hadoop.eclipse.internal.model.ZNode#getDataLength <em>Data Length</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Data Length</em>' attribute.
	 * @see #getDataLength()
	 * @generated
	 */
	void setDataLength(int value);

	/**
	 * Returns the value of the '<em><b>Children Count</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Children Count</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Children Count</em>' attribute.
	 * @see #setChildrenCount(int)
	 * @see org.apache.hadoop.eclipse.internal.model.HadoopPackage#getZNode_ChildrenCount()
	 * @model default="0"
	 * @generated
	 */
	int getChildrenCount();

	/**
	 * Sets the value of the '{@link org.apache.hadoop.eclipse.internal.model.ZNode#getChildrenCount <em>Children Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Children Count</em>' attribute.
	 * @see #getChildrenCount()
	 * @generated
	 */
	void setChildrenCount(int value);

	/**
	 * Returns the value of the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent</em>' reference.
	 * @see #setParent(ZNode)
	 * @see org.apache.hadoop.eclipse.internal.model.HadoopPackage#getZNode_Parent()
	 * @model
	 * @generated
	 */
	ZNode getParent();

	/**
	 * Sets the value of the '{@link org.apache.hadoop.eclipse.internal.model.ZNode#getParent <em>Parent</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent</em>' reference.
	 * @see #getParent()
	 * @generated
	 */
	void setParent(ZNode value);

	/**
	 * Returns the value of the '<em><b>Node Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Node Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Node Name</em>' attribute.
	 * @see #setNodeName(String)
	 * @see org.apache.hadoop.eclipse.internal.model.HadoopPackage#getZNode_NodeName()
	 * @model
	 * @generated
	 */
	String getNodeName();

	/**
	 * Sets the value of the '{@link org.apache.hadoop.eclipse.internal.model.ZNode#getNodeName <em>Node Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Node Name</em>' attribute.
	 * @see #getNodeName()
	 * @generated
	 */
	void setNodeName(String value);

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Server</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='if(this instanceof org.apache.hadoop.eclipse.internal.model.ZooKeeperServer)\n\t\t\treturn (org.apache.hadoop.eclipse.internal.model.ZooKeeperServer) this;\n\t\telse\n\t\t\treturn getParent().getServer();'"
	 * @generated
	 */
	ZooKeeperServer getServer();

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Path</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='if (this instanceof org.apache.hadoop.eclipse.internal.model.ZooKeeperServer)\n\treturn \"/\";\nelse {\n\tString parentPath = getParent().getPath();\n\treturn parentPath.endsWith(\"/\") ? parentPath + getNodeName() : parentPath + \"/\" + getNodeName();\n}'"
	 * @generated
	 */
	String getPath();

} // ZNode
