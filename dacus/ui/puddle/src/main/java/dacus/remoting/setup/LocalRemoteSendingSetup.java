package dacus.remoting.setup;

import dacus.core.publisher.impl.LocalPublisherStub;
import dacus.core.subscriber.impl.LocalSubscriberStub;
import dacus.remoting.state.LocalRemotingState;
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
