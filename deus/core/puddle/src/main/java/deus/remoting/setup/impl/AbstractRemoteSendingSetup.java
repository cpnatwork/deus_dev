 package deus.remoting.setup.impl;

import deus.core.User;
import deus.remoting.setup.RemoteSendingSetup;
import deus.remoting.state.RemotingState;
import deus.remoting.state.RemotingStateRegistry;

public abstract class AbstractRemoteSendingSetup implements RemoteSendingSetup {

	@Override
	public final void setUp(User user) {
		RemotingStateRegistry remotingStateRegistry = user.getRemotingStateRegistry();

		if (!remotingStateRegistry.hasRemotingState(getType()))
			throw new IllegalStateException("Can't setup remote sending for protocol " + getType()
					+ "! There is no remoting state for the user " + user + " and the transport protocol " + getType()
					+ " registered! Set up remote connection first!");

		RemotingState remotingState = remotingStateRegistry.getRemotingState(getType());		
		checkedSetUp(user, remotingState);
	}


	protected abstract void checkedSetUp(User user, RemotingState remotingState);


	@Override
	public final void tearDown(User user) {
		RemotingStateRegistry remotingStateRegistry = user.getRemotingStateRegistry();

		if (!remotingStateRegistry.hasRemotingState(getType()))
			throw new IllegalStateException("Can't tear down remote sending for protocol " + getType()
					+ "! There is no remoting state for the user " + user + " and the transport protocol " + getType()
					+ " registered! Set up remote connection first!");

		RemotingState remotingState = remotingStateRegistry.getRemotingState(getType());		
		checkedTearDown(remotingState);
	}


	protected abstract void checkedTearDown(RemotingState remotingState);

}
