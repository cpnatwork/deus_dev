package deus.nsi.xmpp.setup;

import org.springframework.stereotype.Component;

import deus.core.User;
import deus.core.publisher.PublisherStub;
import deus.core.subscriber.SubscriberStub;
import deus.model.pub.ListOfSubscribers;
import deus.model.pub.SubscriberMetadata;
import deus.model.sub.ListOfPublishers;
import deus.model.sub.PublisherMetadata;
import deus.model.user.transportid.TransportIdType;
import deus.nsi.xmpp.publisher.impl.stub.XmppPublisherStub;
import deus.nsi.xmpp.subscriber.impl.stub.XmppSubscriberStub;
import deus.remoting.setup.RemoteSendingSetup;
import deus.remoting.state.RemotingStateRegistry;

// TODO: think about not setting up all stubs, but only the ones, that are necessary for the following sending
//FIXME: think about refactoring some of the stuff of this methods to abstract super class!
@Component
public class XmppRemoteSendingSetup implements RemoteSendingSetup {

	@Override
	public void setUp(User user) {
		RemotingStateRegistry remotingStateRegistry = user.getRemotingStateRegistry();

		XmppRemotingState remotingState = (XmppRemotingState) remotingStateRegistry
				.getRemotingState(getType());

		ListOfSubscribers los = user.getListOfSubscribers();
		for (SubscriberMetadata subscriberMetadata : los) {
			SubscriberStub subscriberStub = new XmppSubscriberStub(subscriberMetadata, remotingState
					.getXmppConversation());
			remotingState.addSubscriberStub(subscriberStub);
		}

		ListOfPublishers lop = user.getListOfPublishers();
		for (PublisherMetadata publisherMetadata : lop) {
			PublisherStub publisherStub = new XmppPublisherStub(publisherMetadata, remotingState.getXmppConversation());
			remotingState.addPublisherStub(publisherStub);
		}
	}


	@Override
	public void tearDown(User user) {
		RemotingStateRegistry remotingStateRegistry = user.getRemotingStateRegistry();

		XmppRemotingState remotingState = (XmppRemotingState) remotingStateRegistry
				.getRemotingState(getType());

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
