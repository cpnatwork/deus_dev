package deus.core.publisher.impl;


import deus.core.publisher.RemoteCalledPublisher;
import deus.model.pub.ListOfSubscribers;
import deus.model.pub.SubscriberMetadata;

public abstract class RemoteCalledPublisherImpl implements RemoteCalledPublisher {

	protected final ListOfSubscribers listOfSubscribers;


	public RemoteCalledPublisherImpl(ListOfSubscribers listOfSubscribers) {
		super();
		this.listOfSubscribers = listOfSubscribers;
	}


	public synchronized void addObserver(SubscriberMetadata subscriberMetadata) {
		if (subscriberMetadata == null)
			throw new NullPointerException();
		if (!listOfSubscribers.contains(subscriberMetadata)) {
			listOfSubscribers.add(subscriberMetadata);
		}
	}


	public synchronized void deleteObserver(SubscriberMetadata subscriberMetadata) {
		listOfSubscribers.remove(subscriberMetadata);
	}

}