package deus.remoting.setup.local;

import deus.core.User;
import deus.core.publisher.stub.PublisherStub;
import deus.core.subscriber.stub.SubscriberStub;
import deus.model.pub.ListOfSubscribers;
import deus.model.pub.SubscriberMetadata;
import deus.model.sub.ListOfPublishers;
import deus.model.sub.PublisherMetadata;
import deus.model.user.transportid.TransportIdType;
import deus.remoting.setup.impl.AbstractRemoteSendingSetup;
import deus.remoting.state.RemotingState;
import deus.remoting.state.local.LocalRemotingState;

public class LocalRemoteSendingSetup extends AbstractRemoteSendingSetup {


	@Override
	protected void checkedSetUp(User user, RemotingState remotingState) {
		LocalRemotingState localRemotingState = (LocalRemotingState)remotingState;
		
		ListOfSubscribers los = user.getListOfSubscribers();
		for (SubscriberMetadata subscriberMetadata : los) {
			SubscriberStub subscriberStub = new LocalSubscriberStub(subscriberMetadata);
			localRemotingState.addSubscriberStub(subscriberStub);
		}

		ListOfPublishers lop = user.getListOfPublishers();
		for (PublisherMetadata publisherMetadata : lop) {
			PublisherStub publisherStub = new LocalPublisherStub(publisherMetadata);
			localRemotingState.addPublisherStub(publisherStub);
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
		return TransportIdType.local;
	}
}
