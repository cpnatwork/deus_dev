package deus.nsi.xmpp.bootstrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import deus.core.User;
import deus.core.publisher.PublisherStub;
import deus.core.subscriber.SubscriberStub;
import deus.model.pub.ListOfSubscribers;
import deus.model.pub.SubscriberMetadata;
import deus.model.sub.ListOfPublishers;
import deus.model.sub.PublisherMetadata;
import deus.model.user.id.UserIdType;
import deus.model.user.id.XmppUserId;
import deus.nsi.xmpp.publisher.impl.stub.XmppPublisherStub;
import deus.nsi.xmpp.subscriber.impl.stub.XmppSubscriberStub;
import deus.remoting.initializerdestroyer.RemoteSendingInitializerDestroyer;
import deus.remoting.initializerdestroyer.RemotingState;
import deus.remoting.initializerdestroyer.RemotingStateRegistry;

@Component
public class XmppRemoteSendingInitializerDestroyer implements RemoteSendingInitializerDestroyer {

	@Autowired
	private RemotingStateRegistry remotingStateRegistry;
	
	@Override
	public void setUp(User user) {
		XmppRemotingState remotingState = getRemotingState(user);
		
		ListOfSubscribers<XmppUserId> los = user.getListOfSubscribers();
		for(SubscriberMetadata subscriberMetadata : los) {
			SubscriberStub subscriberStub = new XmppSubscriberStub(subscriberMetadata, remotingState.getXmppConversation());
			remotingState.addSubscriberStub(subscriberStub);
		}
		
		ListOfPublishers<XmppUserId> lop = user.getListOfPublishers();
		for(PublisherMetadata publisherMetadata : lop) {
			PublisherStub publisherStub = new XmppPublisherStub(publisherMetadata, remotingState.getXmppConversation());
			remotingState.addPublisherStub(publisherStub);
		}
	}


	@Override
	public void tearDown(User user) {
		XmppRemotingState remotingState = getRemotingState(user);
		
		// TODO: think about if this implementation is right, we cannot enforce disconnection of stubs with this implementation!
		
		remotingState.clearSubscriberStubList();
		remotingState.clearPublisherStubList();
	}

	
	// TODO: externalize this method into superclass or helper
	private XmppRemotingState getRemotingState(User user) {
		RemotingState remotingState = remotingStateRegistry.getRemotingState(user);

		if (!remotingState.getUserIdType().equals(UserIdType.xmpp))
			throw new RuntimeException("cannot tear down remoting for user " + user + " since the stored"
					+ "remoting state for this user is not of type XmppRemoting, but of type "
					+ remotingState.getClass());

		return (XmppRemotingState) remotingState;
	}
}
