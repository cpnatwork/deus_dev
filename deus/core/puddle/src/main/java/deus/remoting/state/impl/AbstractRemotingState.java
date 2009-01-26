package deus.remoting.state.impl;

import java.util.ArrayList;
import java.util.List;

import deus.core.publisher.PublisherStub;
import deus.core.subscriber.SubscriberStub;
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
	public List<PublisherStub> getPublisherStubs() {
		return publisherStubs;
	}

	@Override
	public List<SubscriberStub> getSubscriberStubs() {
		return subscriberStubs;
	}

}
