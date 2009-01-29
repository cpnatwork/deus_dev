package deus.nsi.xmpp.remoting.setup;

import org.springframework.stereotype.Component;

import deus.core.soul.publisher.stub.PublisherStub;
import deus.core.soul.subscriber.stub.SubscriberStub;
import deus.core.transportOLD.command.Subsystem;
import deus.core.transportOLD.setup.impl.AbstractRemoteSendingSetup;
import deus.core.transportOLD.state.RemotingState;
import deus.model.user.id.UserId;
import deus.model.user.transportid.TransportIdType;
import deus.nsi.xmpp.publisher.impl.stub.XmppPublisherStub;
import deus.nsi.xmpp.remoting.state.XmppRemotingState;
import deus.nsi.xmpp.subscriber.impl.stub.XmppSubscriberStub;

// TODO: think about not setting up all stubs, but only the ones, that are necessary for the following sending
@Component
public class XmppRemoteSendingSetup extends AbstractRemoteSendingSetup {


	@Override
	protected void checkedSetUp(RemotingState remotingState, UserId receiverId, Subsystem receiverSubsystem) {
		assert (remotingState.getType().equals(getType()));
		XmppRemotingState xmppRemotingState = (XmppRemotingState) remotingState;
		switch (receiverSubsystem) {
		case publisher:
			PublisherStub publisherStub = new XmppPublisherStub(receiverId, xmppRemotingState.getXmppConversation());
			remotingState.addPublisherStub(publisherStub);
			break;
		case subscriber:
			SubscriberStub subscriberStub = new XmppSubscriberStub(receiverId, xmppRemotingState.getXmppConversation());
			remotingState.addSubscriberStub(subscriberStub);
			break;
		}
	}


	// TODO: think about pulling this to superclass
	@Override
	protected void checkedTearDown(RemotingState remotingState, UserId receiverId, Subsystem receiverSubsystem) {
		assert (remotingState.getType().equals(getType()));
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
		return TransportIdType.xmpp;
	}

}
