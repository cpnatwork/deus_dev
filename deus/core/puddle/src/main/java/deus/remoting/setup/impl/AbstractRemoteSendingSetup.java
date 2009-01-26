package deus.remoting.setup.impl;

import deus.core.User;
import deus.remoting.setup.RemoteSendingSetup;
import deus.remoting.state.RemotingStateRegistry;

public abstract class AbstractRemoteSendingSetup implements RemoteSendingSetup {

	@Override
	public final void setUp(User user) {
		RemotingStateRegistry remotingStateRegistry = user.getRemotingStateRegistry();

		if (!remotingStateRegistry.hasRemotingState(getType()))
			throw new IllegalStateException("Can't setup remote sending for protocol " + getType()
					+ "! There is no remoting state for the user " + user + " and the transport protocol " + getType()
					+ " registered! Set up remote connection first!");

		checkedSetUp(user);
	}


	protected abstract void checkedSetUp(User user);


	@Override
	public final void tearDown(User user) {
		RemotingStateRegistry remotingStateRegistry = user.getRemotingStateRegistry();

		if (!remotingStateRegistry.hasRemotingState(getType()))
			throw new IllegalStateException("Can't tear down remote sending for protocol " + getType()
					+ "! There is no remoting state for the user " + user + " and the transport protocol " + getType()
					+ " registered! Set up remote connection first!");

		checkedTearDown(user);
	}


	protected abstract void checkedTearDown(User user);

}
