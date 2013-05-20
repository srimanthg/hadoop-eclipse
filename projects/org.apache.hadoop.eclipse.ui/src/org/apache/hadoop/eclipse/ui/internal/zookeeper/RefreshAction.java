package org.apache.hadoop.eclipse.ui.internal.zookeeper;

import java.util.Iterator;

import org.apache.hadoop.eclipse.internal.model.ServerStatus;
import org.apache.hadoop.eclipse.internal.model.ZooKeeperServer;
import org.apache.hadoop.eclipse.internal.zookeeper.ZooKeeperNode;
import org.apache.log4j.Logger;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.navigator.resources.ProjectExplorer;

public class RefreshAction implements IObjectActionDelegate {

	private final static Logger logger = Logger.getLogger(RefreshAction.class);
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
			if (targetPart instanceof ProjectExplorer) {
				ProjectExplorer pe = (ProjectExplorer) targetPart;
				@SuppressWarnings("rawtypes")
				Iterator itr = sSelection.iterator();
				while (itr.hasNext()) {
					Object object = itr.next();
					if (logger.isDebugEnabled())
						logger.debug("Refreshing: " + object);
					pe.getCommonViewer().refresh(object, true);
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
					ZooKeeperServer zks = (ZooKeeperServer) object;
					enabled = zks.getStatusCode() == ServerStatus.CONNECTED_VALUE;
				} else
					enabled = object instanceof ZooKeeperNode;
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