package deus.remoting.state.impl;

import java.util.ArrayList;
import java.util.List;

import deus.core.publisher.stub.PublisherStub;
import deus.core.subscriber.stub.SubscriberStub;
import deus.model.user.id.UserId;
import deus.remoting.state.RemotingState;

public abstract class AbstractRemotingState implements RemotingState {

	private final List<PublisherStub> publisherStubs;
	private final List<SubscriberStub> subscriberStubs;


	public AbstractRemotingState() {
		publisherStubs = new ArrayList<PublisherStub>();
		subscriberStubs = new ArrayList<SubscriberStub>();
	}


	@Override
	public void addPublisherStub(PublisherStub publisherStub) {
		publisherStubs.add(publisherStub);
	}


	@Override
	public void addSubscriberStub(SubscriberStub subscriberStub) {
		subscriberStubs.add(subscriberStub);
	}


	@Override
	public void clearPublisherStubList() {
		publisherStubs.clear();
	}


	@Override
	public void clearSubscriberStubList() {
		subscriberStubs.clear();
	}


	@Override
	public PublisherStub getPublisherStub(UserId publisherId) {
		for (PublisherStub stub : publisherStubs)
			if (stub.getPublisherMetadata().getUserId().equals(publisherId))
				return stub;
		throw new IllegalArgumentException("no publisher stub for the publisher " + publisherId);
	}


	@Override
	public SubscriberStub getSubscriberStub(UserId subscriberId) {
		for (SubscriberStub stub : subscriberStubs)
			if (stub.getSubscriberMetadata().getUserId().equals(subscriberId))
				return stub;
		throw new IllegalArgumentException("no subscriber stub for the subscriber " + subscriberId);
	}

	
	public boolean isSendingReady(UserId receiverId) {
		
	}
	
}