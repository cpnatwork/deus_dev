package deus.core.transport.setup.local;

import deus.core.soul.publisher.stub.PublisherStub;
import deus.core.soul.publisher.stub.local.LocalPublisherStub;
import deus.core.soul.subscriber.stub.SubscriberStub;
import deus.core.soul.subscriber.stub.local.LocalSubscriberStub;
import deus.core.transport.command.Subsystem;
import deus.core.transport.setup.impl.AbstractRemoteSendingSetup;
import deus.core.transport.state.RemotingState;
import deus.model.user.id.UserId;
import deus.model.user.transportid.TransportIdType;

public class LocalRemoteSendingSetup extends AbstractRemoteSendingSetup {

	@Override
	protected void checkedSetUp(RemotingState remotingState, UserId receiverId, Subsystem receiverSubsystem) {
		assert(remotingState.getType().equals(getType()));
		switch (receiverSubsystem) {
		case publisher:
			PublisherStub publisherStub = new LocalPublisherStub(receiverId);
			remotingState.addPublisherStub(publisherStub);
			break;
		case subscriber:
			SubscriberStub subscriberStub = new LocalSubscriberStub(receiverId);
			remotingState.addSubscriberStub(subscriberStub);
			break;
		}
	}

	// TODO: think about pulling this to superclass
	@Override
	protected void checkedTearDown(RemotingState remotingState, UserId receiverId, Subsystem receiverSubsystem) {
		assert(remotingState.getType().equals(getType()));
		switch (receiverSubsystem) {
		case publisher:
			remotingState.removePublisherStub(receiverId);
			break;
		case subscriber:
			remotingState.removeSubscriberStub(receiverId);
			break;
		}
	}


	@Override
	public TransportIdType getType() {
		return TransportIdType.local;
	}


}
