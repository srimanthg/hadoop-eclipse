package org.apache.hadoop.eclipse.ui.internal.hdfs;

import java.util.Iterator;

import org.apache.hadoop.eclipse.hdfs.ResourceInformation.Permissions;
import org.apache.hadoop.eclipse.internal.hdfs.HDFSFileStore;
import org.apache.hadoop.eclipse.internal.hdfs.UploadFileJob;
import org.apache.log4j.Logger;
import org.eclipse.core.filesystem.EFS;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;

public class UploadResourceAction implements IObjectActionDelegate {

	private final static Logger logger = Logger.getLogger(UploadResourceAction.class);
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
				if (object instanceof IResource) {
					IResource r = (IResource) object;
					uploadResource(r);
				}
			}
		}
	}

	/**
	 * @param r
	 */
	private void uploadResource(IResource r) {
		try {
			switch (r.getType()) {
			case IResource.FILE:
				UploadFileJob ufj = new UploadFileJob(r);
				ufj.schedule();
				break;
			case IResource.FOLDER:
				IFolder folder = (IFolder) r;
				IResource[] members = folder.members();
				if (members != null) {
					for (int mc = 0; mc < members.length; mc++) {
						uploadResource(members[mc]);
					}
				}
			}
		} catch (CoreException e) {
			MessageDialog.openError(targetPart.getSite().getShell(), "Upload HDFS Resources", "Error uploading resource to " + r.getLocationURI() + ": "
					+ e.getMessage());
			logger.warn(e.getMessage(), e);
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
				if (object instanceof IResource) {
					IResource r = (IResource) object;
					try {
						HDFSFileStore store = (HDFSFileStore) EFS.getStore(r.getLocationURI());
						Permissions effectivePermissions = store.getEffectivePermissions();
						if (enabled && effectivePermissions != null && !effectivePermissions.write)
							enabled = false;
						if (enabled)
							enabled = store.isLocalFile();
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
