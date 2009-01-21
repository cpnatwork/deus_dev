package deus.remoting.initializerdestroyer.impl;

import deus.core.User;
import deus.remoting.initializerdestroyer.RemotingState;
import deus.remoting.initializerdestroyer.RemotingStateRegistry;

// TODO: extract interface
public class RemotingStateRegistryImpl implements RemotingStateRegistry {

	/* (non-Javadoc)
	 * @see deus.remoting.initializerdestroyer.RemotingStateRegistry#getRemotingState(deus.core.User)
	 */
	public RemotingState getRemotingState(User user) {
		if (!hasRemotingState(user))
			throw new RuntimeException("no remoting state available for user " + user
					+ ". Maybe, the user has no RemotingState, since remoting is not activated yet?");

		return null;
	}


	/* (non-Javadoc)
	 * @see deus.remoting.initializerdestroyer.RemotingStateRegistry#addRemotingState(deus.core.User, deus.remoting.initializerdestroyer.RemotingState)
	 */
	public void addRemotingState(User user, RemotingState remotingState) {
		// TODO
	}


	/* (non-Javadoc)
	 * @see deus.remoting.initializerdestroyer.RemotingStateRegistry#updateRemotingState(deus.core.User, deus.remoting.initializerdestroyer.RemotingState)
	 */
	public void updateRemotingState(User user, RemotingState remotingState) {
		// TODO
	}


	/* (non-Javadoc)
	 * @see deus.remoting.initializerdestroyer.RemotingStateRegistry#removeRemotingState(deus.core.User)
	 */
	public void removeRemotingState(User user) {
		// TODO
	}


	/* (non-Javadoc)
	 * @see deus.remoting.initializerdestroyer.RemotingStateRegistry#hasRemotingState(deus.core.User)
	 */
	public boolean hasRemotingState(User user) {
		// TODO
		return false;
	}

}
