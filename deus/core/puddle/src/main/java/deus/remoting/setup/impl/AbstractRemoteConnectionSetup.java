package deus.remoting.setup.impl;

import deus.core.User;
import deus.remoting.setup.RemoteConnectionSetup;
import deus.remoting.state.RemotingState;
import deus.remoting.state.RemotingStateRegistry;

public abstract class AbstractRemoteConnectionSetup implements RemoteConnectionSetup {

	@Override
	public final void setUp(User user) {
		RemotingStateRegistry remotingStateRegistry = user.getRemotingStateRegistry();

		if (remotingStateRegistry.hasRemotingState(getType()))
			throw new IllegalStateException("Can't setup remote connection for protocol " + getType()
					+ "! There already is a remoting state for the user " + user + " and the transport protocol "
					+ getType() + " registered!");

		RemotingState remotingState = checkedSetUp(user);
		remotingStateRegistry.addRemotingState(getType(), remotingState);
	}


	protected abstract RemotingState checkedSetUp(User user);


	@Override
	public final void tearDown(User user) {
		RemotingStateRegistry remotingStateRegistry = user.getRemotingStateRegistry();

		if (!remotingStateRegistry.hasRemotingState(getType()))
			throw new IllegalStateException("Can't tear down remote connection for protocol " + getType()
					+ "! There is no remoting state for the user " + user + " and the transport protocol " + getType()
					+ " registered! Set up remote connection first!");

		
		RemotingState remotingState = remotingStateRegistry.getRemotingState(getType());
		remotingStateRegistry.removeRemotingState(getType());
	
		checkedTearDown(remotingState);
	}


	protected abstract void checkedTearDown(RemotingState remotingState);

}
