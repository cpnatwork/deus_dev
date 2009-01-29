package deus.core.transport.setup.impl;

import deus.core.transport.command.Subsystem;
import deus.core.transport.setup.RemoteSendingSetup;
import deus.core.transport.state.RemotingState;
import deus.model.user.id.UserId;

public abstract class AbstractRemoteSendingSetup implements RemoteSendingSetup {

	@Override
	public void setUpSending(RemotingState remotingState, UserId receiverId, Subsystem receiverSubsystem) {
		if (!remotingState.getType().equals(getType()))
			throw new IllegalStateException("cannot set up remote sending for transport protocol " + getType()
					+ ", remotingState is not for this transport protocol, but for " + remotingState.getType() + "!");

		checkedSetUp(remotingState, receiverId, receiverSubsystem);
	}


	protected abstract void checkedSetUp(RemotingState remotingState, UserId receiverId, Subsystem receiverSubsystem);


	@Override
	public void tearDownSending(RemotingState remotingState, UserId receiverId, Subsystem receiverSubsystem) {
		if (!remotingState.getType().equals(getType()))
			throw new IllegalStateException("cannot tear down remote sending for transport protocol " + getType()
					+ ", remotingState is not for this transport protocol, but for " + remotingState.getType() + "!");
		
		checkedTearDown(remotingState, receiverId, receiverSubsystem);
	}


	protected abstract void checkedTearDown(RemotingState remotingState, UserId receiverId, Subsystem receiverSubsystem);

}
