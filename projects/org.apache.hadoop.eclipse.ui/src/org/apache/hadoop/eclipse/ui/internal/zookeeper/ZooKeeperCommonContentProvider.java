package org.apache.hadoop.eclipse.ui.internal.zookeeper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.hadoop.eclipse.internal.model.ZooKeeperServer;
import org.apache.hadoop.eclipse.internal.zookeeper.ZooKeeperManager;
import org.apache.hadoop.eclipse.internal.zookeeper.ZooKeeperNode;
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
		if (parentElement instanceof ZooKeeperServer) {
			ZooKeeperServer zks = (ZooKeeperServer) parentElement;
			try {
				ZooKeeperClient client = ZooKeeperManager.INSTANCE.getClient(zks);
				List<String> children = client.getChildren("/");
				List<ZooKeeperNode> zkChildren = new ArrayList<ZooKeeperNode>();
				for (String child : children)
					zkChildren.add(new ZooKeeperNode(child, null, zks));
				return zkChildren.toArray();
			} catch (CoreException e) {
				logger.error("Error getting children of server", e);
			} catch (IOException e) {
				logger.error("Error getting children of server", e);
			} catch (InterruptedException e) {
				logger.error("Error getting children of server", e);
			}
		} else if (parentElement instanceof ZooKeeperNode) {
			ZooKeeperNode zkn = (ZooKeeperNode) parentElement;
			try {
				ZooKeeperClient client = ZooKeeperManager.INSTANCE.getClient(zkn.getServer());
				List<String> children = client.getChildren(zkn.getPath());
				List<ZooKeeperNode> zkChildren = new ArrayList<ZooKeeperNode>();
				for (String child : children)
					zkChildren.add(new ZooKeeperNode(child, zkn, zkn.getServer()));
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
		if (element instanceof ZooKeeperNode) {
			ZooKeeperNode zkn = (ZooKeeperNode) element;
			return zkn.getParent();
		}
		return null;
	}

	@Override
	public boolean hasChildren(Object element) {
		if (element instanceof ZooKeeperServer)
			return true;
		if (element instanceof ZooKeeperNode)
			return true;
		return false;
	}

}
