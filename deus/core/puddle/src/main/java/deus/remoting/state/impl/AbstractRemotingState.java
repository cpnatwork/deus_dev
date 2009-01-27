package deus.remoting.state.impl;

import java.util.HashMap;
import java.util.Map;

import deus.core.publisher.stub.PublisherStub;
import deus.core.subscriber.stub.SubscriberStub;
import deus.model.user.id.UserId;
import deus.remoting.command.Subsystem;
import deus.remoting.state.RemotingState;

public abstract class AbstractRemotingState implements RemotingState {

	private final Map<UserId, PublisherStub> publisherStubs;
	private final Map<UserId, SubscriberStub> subscriberStubs;


	public AbstractRemotingState() {
		publisherStubs = new HashMap<UserId, PublisherStub>();
		subscriberStubs = new HashMap<UserId, SubscriberStub>();
	}


	@Override
	public void addPublisherStub(PublisherStub publisherStub) {
		publisherStubs.put(publisherStub.getPublisherId(), publisherStub);
	}


	@Override
	public PublisherStub getPublisherStub(UserId publisherId) {
		PublisherStub stub = publisherStubs.get(publisherId);
		if (stub == null)
			throw new IllegalArgumentException("no publisher stub for the publisher " + publisherId + " added!");
		else
			return stub;
	}


	@Override
	public void removePublisherStub(UserId publisherId) {
		if(!publisherStubs.containsKey(publisherId))
			throw new IllegalArgumentException("remoting state does not contain publisher stub for publisher " + publisherId);
		publisherStubs.remove(publisherId);
	}


	@Override
	public void addSubscriberStub(SubscriberStub subscriberStub) {
		subscriberStubs.put(subscriberStub.getSubscriberId(), subscriberStub);
	}


	@Override
	public SubscriberStub getSubscriberStub(UserId subscriberId) {
		SubscriberStub stub = subscriberStubs.get(subscriberId);
		if (stub == null)
			throw new IllegalArgumentException("no subscriber stub for the subscriber " + subscriberId + " added!");
		else
			return stub;
	}


	@Override
	public void removeSubscriberStub(UserId subscriberId) {
		if(!subscriberStubs.containsKey(subscriberId))
			throw new IllegalArgumentException("remoting state does not contain subscriber stub for subscriber " + subscriberId);
		subscriberStubs.remove(subscriberId);
 	}


	@Override
	public boolean isSendingReady(UserId receiverId, Subsystem subsystem) {
		switch (subsystem) {
		case publisher:
			return publisherStubs.containsKey(receiverId);
		case subscriber:
			return subscriberStubs.containsKey(receiverId);
		}
		throw new IllegalArgumentException("cannot handle subsystem " + subsystem);
	}


}