package org.apache.hadoop.eclipse.ui.internal.zookeeper;

import org.apache.hadoop.eclipse.internal.model.ZNode;
import org.apache.hadoop.eclipse.internal.model.ZooKeeperServer;
import org.apache.hadoop.eclipse.ui.Activator;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.navigator.ICommonContentExtensionSite;
import org.eclipse.ui.navigator.ICommonLabelProvider;

public class ZooKeeperLabelProvider implements ICommonLabelProvider {

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
		if (element instanceof ZNode)
			return Activator.IMAGE_ZOOKEEPER_NODE;
		return null;
	}

	@Override
	public String getText(Object element) {
		if (element instanceof ZooKeeperServer) {
			ZooKeeperServer zks = (ZooKeeperServer) element;
			return zks.getName();
		}
		if (element instanceof ZNode)
			return ((ZNode) element).getNodeName();
		return null;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.navigator.IMementoAware#restoreState(org.eclipse.ui.IMemento)
	 */
	@Override
	public void restoreState(IMemento aMemento) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.navigator.IMementoAware#saveState(org.eclipse.ui.IMemento)
	 */
	@Override
	public void saveState(IMemento aMemento) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.navigator.IDescriptionProvider#getDescription(java.lang.Object)
	 */
	@Override
	public String getDescription(Object anElement) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.navigator.ICommonLabelProvider#init(org.eclipse.ui.navigator.ICommonContentExtensionSite)
	 */
	@Override
	public void init(ICommonContentExtensionSite aConfig) {
		// TODO Auto-generated method stub
		
	}

}
