package org.apache.hadoop.eclipse.ui.internal.hdfs;

import org.apache.hadoop.eclipse.internal.hdfs.HDFSFileSystem;
import org.apache.log4j.Logger;
import org.eclipse.core.filesystem.EFS;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.ui.views.properties.tabbed.ITypeMapper;

public class PropertyTypeMapper implements ITypeMapper {
	private static final Logger logger = Logger.getLogger(PropertyTypeMapper.class);

	@Override
	public Class mapType(Object object) {
		if (object instanceof IResource) {
			IResource resource = (IResource) object;
			if(HDFSFileSystem.SCHEME.equals(resource.getLocationURI().getScheme())){
				// This is a HDFS resource - only show the HDFS tab
				try {
					return EFS.getStore(resource.getLocationURI()).getClass();
				} catch (CoreException e) {
					logger.warn(e.getMessage(), e);
				}
			}
		}
		return object.getClass();
	}

}
