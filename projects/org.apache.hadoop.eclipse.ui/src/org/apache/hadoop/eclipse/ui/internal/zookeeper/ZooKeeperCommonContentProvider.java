package org.apache.hadoop.eclipse.ui.internal.zookeeper;

import java.io.IOException;
import java.util.List;

import org.apache.hadoop.eclipse.internal.HadoopManager;
import org.apache.hadoop.eclipse.internal.model.HadoopPackage;
import org.apache.hadoop.eclipse.internal.model.Servers;
import org.apache.hadoop.eclipse.internal.model.ZNode;
import org.apache.hadoop.eclipse.internal.model.ZooKeeperServer;
import org.apache.hadoop.eclipse.internal.zookeeper.ZooKeeperManager;
import org.apache.hadoop.eclipse.zookeeper.ZooKeeperClient;
import org.apache.log4j.Logger;
import org.eclipse.core.runtime.CoreException;
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

public class ZooKeeperCommonContentProvider implements ICommonContentProvider {

	private static final Logger logger = Logger.getLogger(ZooKeeperCommonContentProvider.class);
	private EContentAdapter serversListener;
	private String viewerId;
	private Display display;

	@Override
	public void dispose() {
		if (serversListener != null) {
			HadoopManager.INSTANCE.getServers().eAdapters().remove(serversListener);
			serversListener = null;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ui.navigator.ICommonContentProvider#init(org.eclipse.ui.navigator
	 * .ICommonContentExtensionSite)
	 */
	@Override
	public void init(ICommonContentExtensionSite aConfig) {
		INavigatorContentService cs = aConfig.getService();
		viewerId = cs.getViewerId();
		this.display = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell().getDisplay();
		hookRefreshResources();
	}

	@Override
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
	}

	@Override
	public Object[] getElements(Object inputElement) {
		return ZooKeeperManager.INSTANCE.getServers().toArray();
	}

	@Override
	public Object[] getChildren(Object parentElement) {
		if (parentElement instanceof ZNode) {
			ZNode zkn = (ZNode) parentElement;
			try {
				ZooKeeperClient client = ZooKeeperManager.INSTANCE.getClient(zkn.getServer());
				List<ZNode> zkChildren = client.getChildren(zkn);
				return zkChildren.toArray();
			} catch (CoreException e) {
				logger.error("Error getting children of node", e);
			} catch (IOException e) {
				logger.error("Error getting children of node", e);
			} catch (InterruptedException e) {
				logger.error("Error getting children of node", e);
			}
		}
		return null;
	}

	@Override
	public Object getParent(Object element) {
		if (element instanceof ZNode) {
			ZNode zkn = (ZNode) element;
			return zkn.getParent();
		}
		return null;
	}

	@Override
	public boolean hasChildren(Object element) {
		if (element instanceof ZooKeeperServer)
			return true;
		if (element instanceof ZNode)
			return true;
		return false;
	}

	protected void hookRefreshResources() {
		serversListener = new EContentAdapter() {
			public boolean isAdapterForType(Object type) {
				return HadoopPackage.eINSTANCE.getZooKeeperServer().isInstance(type) || HadoopPackage.eINSTANCE.getZNode().isInstance(type);
			}

			public void notifyChanged(final org.eclipse.emf.common.notify.Notification notification) {
				super.notifyChanged(notification);
				if (logger.isDebugEnabled())
					logger.debug(notification);
				if (notification.getNotifier() instanceof Servers) {
					if (notification.getEventType() == Notification.ADD || notification.getEventType() == Notification.REMOVE) {
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
									viewer.refresh(true);
								}
							}
						});
					}
				} else if (notification.getNotifier() instanceof ZooKeeperServer) {
					int featureID = notification.getFeatureID(ZooKeeperServer.class);
					if (featureID == HadoopPackage.ZOO_KEEPER_SERVER__STATUS_CODE) {
						if (notification.getEventType() == Notification.SET) {
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
										viewer.refresh(notification.getNotifier(), true);
									}
								}
							});
						}
					}
				}
			}
		};
		HadoopManager.INSTANCE.getServers().eAdapters().add(serversListener);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ui.navigator.IMementoAware#restoreState(org.eclipse.ui.IMemento
	 * )
	 */
	@Override
	public void restoreState(IMemento aMemento) {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ui.navigator.IMementoAware#saveState(org.eclipse.ui.IMemento)
	 */
	@Override
	public void saveState(IMemento aMemento) {
	}

}
