package org.apache.hadoop.eclipse.ui.internal.zookeeper;

import java.io.IOException;
import java.util.Iterator;

import org.apache.hadoop.eclipse.internal.zookeeper.ZooKeeperManager;
import org.apache.hadoop.eclipse.internal.zookeeper.ZooKeeperNode;
import org.apache.hadoop.eclipse.zookeeper.ZooKeeperClient;
import org.apache.hadoop.eclipse.zookeeper.ZooKeeperClient.NodeData;
import org.apache.log4j.Logger;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IEditorDescriptor;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;

public class OpenAction implements IObjectActionDelegate {

	private final static Logger logger = Logger.getLogger(OpenAction.class);
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
				if (object instanceof ZooKeeperNode) {
					ZooKeeperNode zkn = (ZooKeeperNode) object;
					if (logger.isDebugEnabled())
						logger.debug("Opening: " + zkn);
					try {
						ZooKeeperClient client = ZooKeeperManager.INSTANCE.getClient(zkn.getServer());
						NodeData open = client.open(zkn.getPath());
						IWorkbenchPage activePage = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
						IEditorDescriptor defaultEditor = PlatformUI.getWorkbench().getEditorRegistry().getDefaultEditor(zkn.getName());
						activePage.openEditor(new ZooKeeperNodeEditorInput(zkn, open), defaultEditor == null ? "org.eclipse.ui.DefaultTextEditor" : defaultEditor.getId(), true);
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
				if (object instanceof ZooKeeperNode) {
					ZooKeeperNode zkn = (ZooKeeperNode) object;
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
