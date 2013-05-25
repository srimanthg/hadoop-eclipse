package org.apache.hadoop.eclipse.ui.internal.zookeeper;

import java.io.IOException;
import java.util.List;

import org.apache.hadoop.eclipse.internal.model.ZNode;
import org.apache.hadoop.eclipse.internal.model.ZooKeeperServer;
import org.apache.hadoop.eclipse.internal.zookeeper.ZooKeeperManager;
import org.apache.hadoop.eclipse.zookeeper.ZooKeeperClient;
import org.apache.log4j.Logger;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;

public class ZooKeeperCommonContentProvider implements ITreeContentProvider {

	private static final Logger logger = Logger.getLogger(ZooKeeperCommonContentProvider.class);

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

	@Override
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		// TODO Auto-generated method stub

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

}
