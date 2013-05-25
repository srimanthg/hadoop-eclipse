package org.apache.hadoop.eclipse.ui.internal.zookeeper;

import java.io.IOException;
import java.util.Iterator;

import org.apache.hadoop.eclipse.internal.model.ZNode;
import org.apache.hadoop.eclipse.internal.model.ZooKeeperServer;
import org.apache.hadoop.eclipse.internal.zookeeper.ZooKeeperManager;
import org.apache.hadoop.eclipse.zookeeper.ZooKeeperClient;
import org.apache.log4j.Logger;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.navigator.resources.ProjectExplorer;

public class DeleteAction implements IObjectActionDelegate {

	private final static Logger logger = Logger.getLogger(DeleteAction.class);
	private ISelection selection;
	private IWorkbenchPart targetPart;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.IActionDelegate#run(org.eclipse.jface.action.IAction)
	 */
	@Override
	public void run(IAction action) {
		if (this.selection != null && !this.selection.isEmpty()) {
			IStructuredSelection sSelection = (IStructuredSelection) this.selection;
			@SuppressWarnings("rawtypes")
			Iterator itr = sSelection.iterator();
			while (itr.hasNext()) {
				Object object = itr.next();
				if (object instanceof ZooKeeperServer) {
					ZooKeeperServer r = (ZooKeeperServer) object;
					if (logger.isDebugEnabled())
						logger.debug("Deleting: " + r);
					try {
						ZooKeeperManager.INSTANCE.disconnect(r);
					} finally {
						try {
							ZooKeeperManager.INSTANCE.delete(r);
						} catch (CoreException e) {
							logger.error(e.getMessage());
						}
					}
					if (logger.isDebugEnabled())
						logger.debug("Deleted: " + r);
					if (targetPart instanceof ProjectExplorer) {
						ProjectExplorer pe = (ProjectExplorer) targetPart;
						pe.getCommonViewer().refresh();
					}
				} else if (object instanceof ZNode) {
					ZNode zkn = (ZNode) object;
					if (logger.isDebugEnabled())
						logger.debug("Deleting: " + zkn);
					try {
						ZooKeeperClient client = ZooKeeperManager.INSTANCE.getClient(zkn.getServer());
						client.delete(zkn);
					} catch (CoreException e) {
						logger.error(e.getMessage(), e);
					} catch (IOException e) {
						logger.error(e.getMessage(), e);
					} catch (InterruptedException e) {
						logger.error(e.getMessage(), e);
					}
				}
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ui.IActionDelegate#selectionChanged(org.eclipse.jface.action
	 * .IAction, org.eclipse.jface.viewers.ISelection)
	 */
	@Override
	public void selectionChanged(IAction action, ISelection selection) {
		this.selection = selection;
		boolean enabled = true;
		if (this.selection != null && !this.selection.isEmpty()) {
			IStructuredSelection sSelection = (IStructuredSelection) this.selection;
			@SuppressWarnings("rawtypes")
			Iterator itr = sSelection.iterator();
			while (itr.hasNext()) {
				Object object = itr.next();
				enabled = false;
				if (object instanceof ZooKeeperServer) {
					ZooKeeperServer server = (ZooKeeperServer) object;
					enabled = server != null;
				} else if (object instanceof ZNode) {
					ZNode zkn = (ZNode) object;
					enabled = zkn != null;
				}
			}
		} else
			enabled = false;
		action.setEnabled(enabled);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ui.IObjectActionDelegate#setActivePart(org.eclipse.jface.
	 * action.IAction, org.eclipse.ui.IWorkbenchPart)
	 */
	@Override
	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
		this.targetPart = targetPart;
	}

}
