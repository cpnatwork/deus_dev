package deus.remoting.initializerdestroyer;

import deus.core.User;

// TODO: extract interface
public class RemotingStateRegistry {

	public RemotingState getRemotingState(User user) {
		if (!hasRemotingState(user))
			throw new RuntimeException("no remoting state available for user " + user
					+ ". Maybe, the user has no RemotingState, since remoting is not activated yet?");

		return null;
	}


	public void addRemotingState(User user, RemotingState remotingState) {
		// TODO
	}


	public void updateRemotingState(User user, RemotingState remotingState) {
		// TODO
	}


	public void removeRemotingState(User user) {
		// TODO
	}


	public boolean hasRemotingState(User user) {
		// TODO
		return false;
	}

}
