package deus.nsi.xmpp.setup;

import org.springframework.stereotype.Component;

import deus.core.User;
import deus.core.publisher.stub.PublisherStub;
import deus.core.subscriber.stub.SubscriberStub;
import deus.model.pub.ListOfSubscribers;
import deus.model.pub.SubscriberMetadata;
import deus.model.sub.ListOfPublishers;
import deus.model.sub.PublisherMetadata;
import deus.model.user.transportid.TransportIdType;
import deus.nsi.xmpp.publisher.impl.stub.XmppPublisherStub;
import deus.nsi.xmpp.subscriber.impl.stub.XmppSubscriberStub;
import deus.remoting.setup.impl.AbstractRemoteSendingSetup;
import deus.remoting.state.RemotingState;

// TODO: think about not setting up all stubs, but only the ones, that are necessary for the following sending
@Component
public class XmppRemoteSendingSetup extends AbstractRemoteSendingSetup {

	@Override
	protected void checkedSetUp(User user, RemotingState remotingState) {
		XmppRemotingState xmppRemotingState = (XmppRemotingState)remotingState;
				
		ListOfSubscribers los = user.getListOfSubscribers();
		for (SubscriberMetadata subscriberMetadata : los) {
			SubscriberStub subscriberStub = new XmppSubscriberStub(subscriberMetadata, xmppRemotingState
					.getXmppConversation());
			xmppRemotingState.addSubscriberStub(subscriberStub);
		}

		ListOfPublishers lop = user.getListOfPublishers();
		for (PublisherMetadata publisherMetadata : lop) {
			PublisherStub publisherStub = new XmppPublisherStub(publisherMetadata, xmppRemotingState.getXmppConversation());
			xmppRemotingState.addPublisherStub(publisherStub);
		}
	}


	@Override
	protected void checkedTearDown(RemotingState remotingState) {
		// TODO: think about this: if this implementation is right, we cannot enforce disconnection of stubs with this
		// implementation!

		remotingState.clearSubscriberStubList();
		remotingState.clearPublisherStubList();
	}


	@Override
	public TransportIdType getType() {
		return TransportIdType.xmpp;
	}

}
