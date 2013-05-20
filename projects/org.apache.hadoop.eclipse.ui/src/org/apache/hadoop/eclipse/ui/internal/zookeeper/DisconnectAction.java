package org.apache.hadoop.eclipse.ui.internal.zookeeper;

import java.util.Iterator;

import org.apache.hadoop.eclipse.internal.model.ServerStatus;
import org.apache.hadoop.eclipse.internal.model.ZooKeeperServer;
import org.apache.hadoop.eclipse.internal.zookeeper.ZooKeeperManager;
import org.apache.log4j.Logger;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.navigator.resources.ProjectExplorer;

public class DisconnectAction implements IObjectActionDelegate {

	private final static Logger logger = Logger.getLogger(DisconnectAction.class);
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
					if(logger.isDebugEnabled())
						logger.debug("Disconnecting: "+r);
					ZooKeeperManager.INSTANCE.disconnect(r);
					if(logger.isDebugEnabled())
						logger.debug("Disconnected: "+r);
					if (targetPart instanceof ProjectExplorer) {
						ProjectExplorer pe = (ProjectExplorer) targetPart;
						pe.getCommonViewer().refresh(r, true);
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
				if (object instanceof ZooKeeperServer) {
					ZooKeeperServer server = (ZooKeeperServer) object;
					try {
						enabled = server == null ? false : server.getStatusCode() != ServerStatus.DISCONNECTED_VALUE;
					} catch (Throwable t) {
						enabled = false;
					}
				} else
					enabled = false;
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
