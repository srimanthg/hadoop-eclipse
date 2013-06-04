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
 */
package org.apache.hadoop.eclipse.ui.internal.hdfs;

import java.net.URI;

import org.apache.hadoop.eclipse.hdfs.ResourceInformation.Permissions;
import org.apache.hadoop.eclipse.internal.hdfs.HDFSFileStore;
import org.apache.hadoop.eclipse.internal.hdfs.HDFSManager;
import org.apache.hadoop.eclipse.internal.hdfs.HDFSURI;
import org.apache.hadoop.eclipse.internal.model.HDFSServer;
import org.apache.hadoop.eclipse.internal.model.ServerStatus;
import org.apache.log4j.Logger;
import org.eclipse.core.filesystem.EFS;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.viewers.IDecoration;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ILightweightLabelDecorator;

public class HDFSLightweightLabelDecorator implements ILightweightLabelDecorator {
	private static final Logger logger = Logger.getLogger(HDFSLightweightLabelDecorator.class);

	/**
	 * 
	 */
	public HDFSLightweightLabelDecorator() {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.jface.viewers.IBaseLabelProvider#addListener(org.eclipse.
	 * jface.viewers.ILabelProviderListener)
	 */
	@Override
	public void addListener(ILabelProviderListener listener) {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.viewers.IBaseLabelProvider#dispose()
	 */
	@Override
	public void dispose() {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.jface.viewers.IBaseLabelProvider#isLabelProperty(java.lang
	 * .Object, java.lang.String)
	 */
	@Override
	public boolean isLabelProperty(Object element, String property) {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.jface.viewers.IBaseLabelProvider#removeListener(org.eclipse
	 * .jface.viewers.ILabelProviderListener)
	 */
	@Override
	public void removeListener(ILabelProviderListener listener) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.jface.viewers.ILightweightLabelDecorator#decorate(java.lang
	 * .Object, org.eclipse.jface.viewers.IDecoration)
	 */
	@Override
	public void decorate(Object element, IDecoration decoration) {
		if (element instanceof IResource) {
			IResource r = (IResource) element;
			URI locationURI = r.getLocationURI();
			if (locationURI != null && HDFSURI.SCHEME.equals(locationURI.getScheme())) {
				try {
					if (r instanceof IProject) {
						final HDFSManager hdfsManager = HDFSManager.INSTANCE;
						HDFSServer server = hdfsManager.getServer(locationURI.toString());
						if (server != null) {
							String serverUrl = server.getUri();
							String userId = server.getUserId();
							if (userId == null) {
								try {
									userId = hdfsManager.getClient(serverUrl).getDefaultUserAndGroupIds().get(0);
								} catch (Throwable e) {
									userId = null;
								}
							}
							if (userId == null)
								userId = "";
							else
								userId = userId + "@";
							if (serverUrl != null) {
								try {
									URI uri = new URI(serverUrl);
									serverUrl = serverUrl.substring(uri.getScheme().length() + 3);
								} catch (Throwable e) {
								}
							}
							if (serverUrl.endsWith("/"))
								serverUrl = serverUrl.substring(0, serverUrl.length() - 1);
							decoration.addSuffix(" " + userId + serverUrl);
							if (server.getStatusCode() == ServerStatus.DISCONNECTED_VALUE)
								decoration.addOverlay(org.apache.hadoop.eclipse.ui.Activator.IMAGE_OFFLINE_OVR);
							else
								decoration.addOverlay(org.apache.hadoop.eclipse.ui.Activator.IMAGE_ONLINE_OVR);
						} else
							decoration.addSuffix(" [Unknown server]");
					} else
						decorate((HDFSFileStore) EFS.getStore(locationURI), decoration);
				} catch (CoreException e) {
					logger.debug(e.getMessage(), e);
				}
			}
		}
	}

	protected void decorate(HDFSFileStore store, IDecoration decoration) {
		if (store != null) {
			if (store.isLocalFile())
				decoration.addOverlay(org.apache.hadoop.eclipse.ui.Activator.IMAGE_LOCAL_OVR, IDecoration.BOTTOM_LEFT);
			else if (store.isRemoteFile())
				decoration.addOverlay(org.apache.hadoop.eclipse.ui.Activator.IMAGE_REMOTE_OVR, IDecoration.BOTTOM_LEFT);
			if (store.isLocalOnly())
				decoration.addOverlay(org.apache.hadoop.eclipse.ui.Activator.IMAGE_OUTGOING_OVR, IDecoration.BOTTOM_RIGHT);

			Permissions effectivePermissions = store.getEffectivePermissions();
			if (effectivePermissions != null && !effectivePermissions.read && !effectivePermissions.write)
				decoration.addOverlay(org.apache.hadoop.eclipse.ui.Activator.IMAGE_READONLY_OVR);
		}
	}

}
