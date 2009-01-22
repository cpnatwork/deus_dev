package deus.core.publisher.impl;


import deus.core.publisher.RemoteCalledPublisher;
import deus.model.pub.ListOfSubscribers;
import deus.model.pub.SubscriberMetadata;

public class RemoteCalledPublisherImpl implements RemoteCalledPublisher {

	protected final ListOfSubscribers listOfSubscribers;


	public RemoteCalledPublisherImpl(ListOfSubscribers listOfSubscribers) {
		super();
		this.listOfSubscribers = listOfSubscribers;
	}


	public synchronized void addObserver(SubscriberMetadata o) {
		if (o == null)
			throw new NullPointerException();
		if (!listOfSubscribers.contains(o)) {
			listOfSubscribers.add(o);
		}
	}


	public synchronized void deleteObserver(SubscriberMetadata o) {
		listOfSubscribers.remove(o);
	}

}