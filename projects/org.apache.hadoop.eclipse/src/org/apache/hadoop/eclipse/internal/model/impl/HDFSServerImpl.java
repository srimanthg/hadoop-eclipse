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
import org.apache.hadoop.eclipse.internal.model.HadoopPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>HDFS Server</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.apache.hadoop.eclipse.internal.model.impl.HDFSServerImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.apache.hadoop.eclipse.internal.model.impl.HDFSServerImpl#getUri <em>Uri</em>}</li>
 *   <li>{@link org.apache.hadoop.eclipse.internal.model.impl.HDFSServerImpl#getStatusCode <em>Status Code</em>}</li>
 *   <li>{@link org.apache.hadoop.eclipse.internal.model.impl.HDFSServerImpl#getStatusMessage <em>Status Message</em>}</li>
 *   <li>{@link org.apache.hadoop.eclipse.internal.model.impl.HDFSServerImpl#getLastAccessed <em>Last Accessed</em>}</li>
 *   <li>{@link org.apache.hadoop.eclipse.internal.model.impl.HDFSServerImpl#isLoaded <em>Loaded</em>}</li>
 *   <li>{@link org.apache.hadoop.eclipse.internal.model.impl.HDFSServerImpl#getWorkspaceProjectName <em>Workspace Project Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class HDFSServerImpl extends EObjectImpl implements HDFSServer {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = "";

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getUri() <em>Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUri()
	 * @generated
	 * @ordered
	 */
	protected static final String URI_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getUri() <em>Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUri()
	 * @generated
	 * @ordered
	 */
	protected String uri = URI_EDEFAULT;

	/**
	 * The default value of the '{@link #getStatusCode() <em>Status Code</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStatusCode()
	 * @generated
	 * @ordered
	 */
	protected static final int STATUS_CODE_EDEFAULT = -1;

	/**
	 * The cached value of the '{@link #getStatusCode() <em>Status Code</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStatusCode()
	 * @generated
	 * @ordered
	 */
	protected int statusCode = STATUS_CODE_EDEFAULT;

	/**
	 * The default value of the '{@link #getStatusMessage() <em>Status Message</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStatusMessage()
	 * @generated
	 * @ordered
	 */
	protected static final String STATUS_MESSAGE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getStatusMessage() <em>Status Message</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStatusMessage()
	 * @generated
	 * @ordered
	 */
	protected String statusMessage = STATUS_MESSAGE_EDEFAULT;

	/**
	 * The default value of the '{@link #getLastAccessed() <em>Last Accessed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLastAccessed()
	 * @generated
	 * @ordered
	 */
	protected static final long LAST_ACCESSED_EDEFAULT = -1L;

	/**
	 * The cached value of the '{@link #getLastAccessed() <em>Last Accessed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLastAccessed()
	 * @generated
	 * @ordered
	 */
	protected long lastAccessed = LAST_ACCESSED_EDEFAULT;

	/**
	 * The default value of the '{@link #isLoaded() <em>Loaded</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isLoaded()
	 * @generated
	 * @ordered
	 */
	protected static final boolean LOADED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isLoaded() <em>Loaded</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isLoaded()
	 * @generated
	 * @ordered
	 */
	protected boolean loaded = LOADED_EDEFAULT;

	/**
	 * The default value of the '{@link #getWorkspaceProjectName() <em>Workspace Project Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWorkspaceProjectName()
	 * @generated
	 * @ordered
	 */
	protected static final String WORKSPACE_PROJECT_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getWorkspaceProjectName() <em>Workspace Project Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWorkspaceProjectName()
	 * @generated
	 * @ordered
	 */
	protected String workspaceProjectName = WORKSPACE_PROJECT_NAME_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected HDFSServerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return HadoopPackage.Literals.HDFS_SERVER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HadoopPackage.HDFS_SERVER__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getUri() {
		return uri;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUri(String newUri) {
		String oldUri = uri;
		uri = newUri;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HadoopPackage.HDFS_SERVER__URI, oldUri, uri));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getStatusCode() {
		return statusCode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStatusCode(int newStatusCode) {
		int oldStatusCode = statusCode;
		statusCode = newStatusCode;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HadoopPackage.HDFS_SERVER__STATUS_CODE, oldStatusCode, statusCode));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getStatusMessage() {
		return statusMessage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStatusMessage(String newStatusMessage) {
		String oldStatusMessage = statusMessage;
		statusMessage = newStatusMessage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HadoopPackage.HDFS_SERVER__STATUS_MESSAGE, oldStatusMessage, statusMessage));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getLastAccessed() {
		return lastAccessed;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLastAccessed(long newLastAccessed) {
		long oldLastAccessed = lastAccessed;
		lastAccessed = newLastAccessed;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HadoopPackage.HDFS_SERVER__LAST_ACCESSED, oldLastAccessed, lastAccessed));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isLoaded() {
		return loaded;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLoaded(boolean newLoaded) {
		boolean oldLoaded = loaded;
		loaded = newLoaded;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HadoopPackage.HDFS_SERVER__LOADED, oldLoaded, loaded));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getWorkspaceProjectName() {
		return workspaceProjectName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWorkspaceProjectName(String newWorkspaceProjectName) {
		String oldWorkspaceProjectName = workspaceProjectName;
		workspaceProjectName = newWorkspaceProjectName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HadoopPackage.HDFS_SERVER__WORKSPACE_PROJECT_NAME, oldWorkspaceProjectName, workspaceProjectName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case HadoopPackage.HDFS_SERVER__NAME:
				return getName();
			case HadoopPackage.HDFS_SERVER__URI:
				return getUri();
			case HadoopPackage.HDFS_SERVER__STATUS_CODE:
				return getStatusCode();
			case HadoopPackage.HDFS_SERVER__STATUS_MESSAGE:
				return getStatusMessage();
			case HadoopPackage.HDFS_SERVER__LAST_ACCESSED:
				return getLastAccessed();
			case HadoopPackage.HDFS_SERVER__LOADED:
				return isLoaded();
			case HadoopPackage.HDFS_SERVER__WORKSPACE_PROJECT_NAME:
				return getWorkspaceProjectName();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case HadoopPackage.HDFS_SERVER__NAME:
				setName((String)newValue);
				return;
			case HadoopPackage.HDFS_SERVER__URI:
				setUri((String)newValue);
				return;
			case HadoopPackage.HDFS_SERVER__STATUS_CODE:
				setStatusCode((Integer)newValue);
				return;
			case HadoopPackage.HDFS_SERVER__STATUS_MESSAGE:
				setStatusMessage((String)newValue);
				return;
			case HadoopPackage.HDFS_SERVER__LAST_ACCESSED:
				setLastAccessed((Long)newValue);
				return;
			case HadoopPackage.HDFS_SERVER__LOADED:
				setLoaded((Boolean)newValue);
				return;
			case HadoopPackage.HDFS_SERVER__WORKSPACE_PROJECT_NAME:
				setWorkspaceProjectName((String)newValue);
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
			case HadoopPackage.HDFS_SERVER__NAME:
				setName(NAME_EDEFAULT);
				return;
			case HadoopPackage.HDFS_SERVER__URI:
				setUri(URI_EDEFAULT);
				return;
			case HadoopPackage.HDFS_SERVER__STATUS_CODE:
				setStatusCode(STATUS_CODE_EDEFAULT);
				return;
			case HadoopPackage.HDFS_SERVER__STATUS_MESSAGE:
				setStatusMessage(STATUS_MESSAGE_EDEFAULT);
				return;
			case HadoopPackage.HDFS_SERVER__LAST_ACCESSED:
				setLastAccessed(LAST_ACCESSED_EDEFAULT);
				return;
			case HadoopPackage.HDFS_SERVER__LOADED:
				setLoaded(LOADED_EDEFAULT);
				return;
			case HadoopPackage.HDFS_SERVER__WORKSPACE_PROJECT_NAME:
				setWorkspaceProjectName(WORKSPACE_PROJECT_NAME_EDEFAULT);
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
			case HadoopPackage.HDFS_SERVER__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case HadoopPackage.HDFS_SERVER__URI:
				return URI_EDEFAULT == null ? uri != null : !URI_EDEFAULT.equals(uri);
			case HadoopPackage.HDFS_SERVER__STATUS_CODE:
				return statusCode != STATUS_CODE_EDEFAULT;
			case HadoopPackage.HDFS_SERVER__STATUS_MESSAGE:
				return STATUS_MESSAGE_EDEFAULT == null ? statusMessage != null : !STATUS_MESSAGE_EDEFAULT.equals(statusMessage);
			case HadoopPackage.HDFS_SERVER__LAST_ACCESSED:
				return lastAccessed != LAST_ACCESSED_EDEFAULT;
			case HadoopPackage.HDFS_SERVER__LOADED:
				return loaded != LOADED_EDEFAULT;
			case HadoopPackage.HDFS_SERVER__WORKSPACE_PROJECT_NAME:
				return WORKSPACE_PROJECT_NAME_EDEFAULT == null ? workspaceProjectName != null : !WORKSPACE_PROJECT_NAME_EDEFAULT.equals(workspaceProjectName);
		}
		return super.eIsSet(featureID);
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
		result.append(" (name: ");
		result.append(name);
		result.append(", uri: ");
		result.append(uri);
		result.append(", statusCode: ");
		result.append(statusCode);
		result.append(", statusMessage: ");
		result.append(statusMessage);
		result.append(", lastAccessed: ");
		result.append(lastAccessed);
		result.append(", loaded: ");
		result.append(loaded);
		result.append(", workspaceProjectName: ");
		result.append(workspaceProjectName);
		result.append(')');
		return result.toString();
	}

} //HDFSServerImpl
