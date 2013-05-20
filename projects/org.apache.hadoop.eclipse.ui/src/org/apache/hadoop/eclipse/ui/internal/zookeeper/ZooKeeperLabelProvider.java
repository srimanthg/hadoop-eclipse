package org.apache.hadoop.eclipse.ui.internal.zookeeper;

import org.apache.hadoop.eclipse.internal.model.ZooKeeperServer;
import org.apache.hadoop.eclipse.internal.zookeeper.ZooKeeperNode;
import org.apache.hadoop.eclipse.ui.Activator;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.swt.graphics.Image;

public class ZooKeeperLabelProvider implements ILabelProvider {

	@Override
	public void addListener(ILabelProviderListener listener) {
	}

	@Override
	public void dispose() {
	}

	@Override
	public boolean isLabelProperty(Object element, String property) {
		return false;
	}

	@Override
	public void removeListener(ILabelProviderListener listener) {
	}

	@Override
	public Image getImage(Object element) {
		if (element instanceof ZooKeeperServer)
			return Activator.IMAGE_ZOOKEEPER;
		if (element instanceof ZooKeeperNode)
			return Activator.IMAGE_ZOOKEEPER_NODE;
		return null;
	}

	@Override
	public String getText(Object element) {
		if (element instanceof ZooKeeperServer) {
			ZooKeeperServer zks = (ZooKeeperServer) element;
			return zks.getName();
		}
		if (element instanceof ZooKeeperNode)
			return ((ZooKeeperNode) element).getName();
		return null;
	}

}
