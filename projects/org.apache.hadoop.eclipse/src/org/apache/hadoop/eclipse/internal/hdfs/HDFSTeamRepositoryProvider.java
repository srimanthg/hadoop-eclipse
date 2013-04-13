package org.apache.hadoop.eclipse.internal.hdfs;

import org.eclipse.core.resources.team.IMoveDeleteHook;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.team.core.RepositoryProvider;

public class HDFSTeamRepositoryProvider extends RepositoryProvider {

	public static final String ID = "org.apache.hadoop.hdfs";
	private HDFSMoveDeleteHook moveDeleteHook = new HDFSMoveDeleteHook();
	
	public HDFSTeamRepositoryProvider() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void deconfigure() throws CoreException {
		// TODO Auto-generated method stub

	}

	@Override
	public void configureProject() throws CoreException {
		// TODO Auto-generated method stub

	}

	@Override
	public String getID() {
		return ID;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.team.core.RepositoryProvider#getMoveDeleteHook()
	 */
	@Override
	public IMoveDeleteHook getMoveDeleteHook() {
		return moveDeleteHook;
	}

}
