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
import java.util.ArrayList;
import java.util.List;

import org.apache.hadoop.eclipse.internal.HadoopManager;
import org.apache.hadoop.eclipse.internal.hdfs.HDFSManager;
import org.apache.hadoop.eclipse.internal.model.HDFSServer;
import org.apache.hadoop.eclipse.internal.model.HadoopPackage;
import org.apache.log4j.Logger;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.navigator.CommonNavigator;
import org.eclipse.ui.navigator.CommonViewer;
import org.eclipse.ui.navigator.ICommonContentExtensionSite;
import org.eclipse.ui.navigator.ICommonContentProvider;
import org.eclipse.ui.navigator.INavigatorContentService;

public class HDFSCommonContentProvider implements ICommonContentProvider {

	private static final Logger logger = Logger.getLogger(HDFSCommonContentProvider.class);

	private String viewerId;
	private Display display = null;

	private EContentAdapter serversListener;

	@Override
	public Object[] getElements(Object inputElement) {
		return null;
	}

	@Override
	public Object[] getChildren(Object parentElement) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getParent(Object element) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean hasChildren(Object element) {
		return false;
	}

	@Override
	public void dispose() {
		if (serversListener != null) {
			HadoopManager.INSTANCE.getServers().eAdapters().remove(serversListener);
			serversListener = null;
		}
	}

	@Override
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		// TODO Auto-generated method stub

	}

	@Override
	public void restoreState(IMemento aMemento) {
		// TODO Auto-generated method stub

	}

	@Override
	public void saveState(IMemento aMemento) {
		// TODO Auto-generated method stub

	}

	@Override
	public void init(ICommonContentExtensionSite aConfig) {
		INavigatorContentService cs = aConfig.getService();
		viewerId = cs.getViewerId();
		this.display = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell().getDisplay();
		hookRefreshResources();
	}

	protected void hookRefreshResources() {
		serversListener = new EContentAdapter() {
			private List<String> addedUris = new ArrayList<String>();

			public boolean isAdapterForType(Object type) {
				return HadoopPackage.eINSTANCE.getHDFSServer().isInstance(type);
			}

			public void notifyChanged(org.eclipse.emf.common.notify.Notification notification) {
				super.notifyChanged(notification);
				if (notification.getNotifier() instanceof HDFSServer) {
					int featureID = notification.getFeatureID(HDFSServer.class);
					if (featureID == HadoopPackage.HDFS_SERVER__OPERATION_UR_IS) {
						if (notification.getEventType() == Notification.ADD) {
							Object[] array = ((HDFSServer) notification.getNotifier()).getOperationURIs().toArray();
							for (int ac = 0; ac < array.length; ac++) {
								String uri = (String) array[ac];
								addedUris.add(uri);
							}
						} else if (addedUris.size() > 0 && display != null) {
							display.asyncExec(new Runnable() {
								@Override
								public void run() {
									CommonViewer viewer = null;
									try {
										IViewPart view = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().showView(viewerId);
										if (view instanceof CommonNavigator) {
											CommonNavigator navigator = (CommonNavigator) view;
											viewer = navigator.getCommonViewer();
										}
									} catch (PartInitException e) {
									}
									if (viewer != null) {
										Object[] addedArray = addedUris.toArray();
										for (int ac = 0; ac < addedArray.length; ac++) {
											String uri = (String) addedArray[ac];
											HDFSServer server = HDFSManager.INSTANCE.getServer(uri);
											if (server != null) {
												try {
													URI relativeURI = org.eclipse.core.runtime.URIUtil.makeRelative(new URI(uri), new URI(server.getUri()));
													if (relativeURI != null) {
														String projectName = HDFSManager.INSTANCE.getProjectName(server);
														if (projectName != null) {
															IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(
																	new Path(projectName + "/" + relativeURI.toString()));
															if (file != null) {
																viewer.refresh(file, true);
																IContainer parent = file.getParent();
																while (parent != null) {
																	viewer.refresh(parent, true);
																	parent = parent.getParent();
																}
															}
														}
													}
												} catch (Throwable t) {
													if (logger.isDebugEnabled())
														logger.debug(t);
												}
											}
										}
									}
									addedUris.clear();
								}
							});
						}

					}
				}
			}
		};
		HadoopManager.INSTANCE.getServers().eAdapters().add(serversListener);
	}

}
