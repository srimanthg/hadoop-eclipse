package org.apache.hadoop.eclipse.ui.internal;

import org.apache.hadoop.eclipse.internal.hdfs.HDFSFileStore;
import org.apache.hadoop.eclipse.ui.internal.hdfs.HDFSFileStorePropertySource;
import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.ui.views.properties.IPropertySource;

public class HadoopAdapterFactory implements IAdapterFactory {

	@Override
	public Object getAdapter(Object adaptableObject, Class adapterType) {
		if (adaptableObject instanceof HDFSFileStore) {
			HDFSFileStore fs = (HDFSFileStore) adaptableObject;
			if (adapterType == IPropertySource.class)
				return new HDFSFileStorePropertySource(fs);
		}
		return null;
	}

	@Override
	public Class[] getAdapterList() {
		return new Class[] { IPropertySource.class };
	}

}
