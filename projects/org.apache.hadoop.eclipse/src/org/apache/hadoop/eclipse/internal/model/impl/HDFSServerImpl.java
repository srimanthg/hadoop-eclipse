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

import java.util.Collection;
import org.apache.hadoop.eclipse.internal.model.HDFSServer;
import org.apache.hadoop.eclipse.internal.model.HadoopPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>HDFS Server</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.apache.hadoop.eclipse.internal.model.impl.HDFSServerImpl#isLoaded <em>Loaded</em>}</li>
 *   <li>{@link org.apache.hadoop.eclipse.internal.model.impl.HDFSServerImpl#getOperationURIs <em>Operation UR Is</em>}</li>
 *   <li>{@link org.apache.hadoop.eclipse.internal.model.impl.HDFSServerImpl#getUserId <em>User Id</em>}</li>
 *   <li>{@link org.apache.hadoop.eclipse.internal.model.impl.HDFSServerImpl#getGroupIds <em>Group Ids</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class HDFSServerImpl extends ServerImpl implements HDFSServer {
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
	 * The cached value of the '{@link #getOperationURIs() <em>Operation UR Is</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOperationURIs()
	 * @generated
	 * @ordered
	 */
	protected EList<String> operationURIs;

	/**
	 * The default value of the '{@link #getUserId() <em>User Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUserId()
	 * @generated
	 * @ordered
	 */
	protected static final String USER_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getUserId() <em>User Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUserId()
	 * @generated
	 * @ordered
	 */
	protected String userId = USER_ID_EDEFAULT;

	/**
	 * The cached value of the '{@link #getGroupIds() <em>Group Ids</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGroupIds()
	 * @generated
	 * @ordered
	 */
	protected EList<String> groupIds;

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
	public EList<String> getOperationURIs() {
		if (operationURIs == null) {
			operationURIs = new EDataTypeUniqueEList<String>(String.class, this, HadoopPackage.HDFS_SERVER__OPERATION_UR_IS);
		}
		return operationURIs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUserId(String newUserId) {
		String oldUserId = userId;
		userId = newUserId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HadoopPackage.HDFS_SERVER__USER_ID, oldUserId, userId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getGroupIds() {
		if (groupIds == null) {
			groupIds = new EDataTypeUniqueEList<String>(String.class, this, HadoopPackage.HDFS_SERVER__GROUP_IDS);
		}
		return groupIds;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case HadoopPackage.HDFS_SERVER__LOADED:
				return isLoaded();
			case HadoopPackage.HDFS_SERVER__OPERATION_UR_IS:
				return getOperationURIs();
			case HadoopPackage.HDFS_SERVER__USER_ID:
				return getUserId();
			case HadoopPackage.HDFS_SERVER__GROUP_IDS:
				return getGroupIds();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case HadoopPackage.HDFS_SERVER__LOADED:
				setLoaded((Boolean)newValue);
				return;
			case HadoopPackage.HDFS_SERVER__OPERATION_UR_IS:
				getOperationURIs().clear();
				getOperationURIs().addAll((Collection<? extends String>)newValue);
				return;
			case HadoopPackage.HDFS_SERVER__USER_ID:
				setUserId((String)newValue);
				return;
			case HadoopPackage.HDFS_SERVER__GROUP_IDS:
				getGroupIds().clear();
				getGroupIds().addAll((Collection<? extends String>)newValue);
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
			case HadoopPackage.HDFS_SERVER__LOADED:
				setLoaded(LOADED_EDEFAULT);
				return;
			case HadoopPackage.HDFS_SERVER__OPERATION_UR_IS:
				getOperationURIs().clear();
				return;
			case HadoopPackage.HDFS_SERVER__USER_ID:
				setUserId(USER_ID_EDEFAULT);
				return;
			case HadoopPackage.HDFS_SERVER__GROUP_IDS:
				getGroupIds().clear();
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
			case HadoopPackage.HDFS_SERVER__LOADED:
				return loaded != LOADED_EDEFAULT;
			case HadoopPackage.HDFS_SERVER__OPERATION_UR_IS:
				return operationURIs != null && !operationURIs.isEmpty();
			case HadoopPackage.HDFS_SERVER__USER_ID:
				return USER_ID_EDEFAULT == null ? userId != null : !USER_ID_EDEFAULT.equals(userId);
			case HadoopPackage.HDFS_SERVER__GROUP_IDS:
				return groupIds != null && !groupIds.isEmpty();
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
		result.append(" (loaded: ");
		result.append(loaded);
		result.append(", operationURIs: ");
		result.append(operationURIs);
		result.append(", userId: ");
		result.append(userId);
		result.append(", groupIds: ");
		result.append(groupIds);
		result.append(')');
		return result.toString();
	}

} //HDFSServerImpl
