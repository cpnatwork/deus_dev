package deus.core.publisher.impl;


import deus.core.publisher.RemoteCalledPublisher;
import deus.model.pub.ListOfSubscribers;
import deus.model.pub.SubscriberMetadata;
import deus.model.pub.impl.ThreadSafeListOfSubscribers;
import deus.model.user.id.UserId;

public class RemoteCalledPublisherImpl<Id extends UserId> implements RemoteCalledPublisher<Id> {

	final ListOfSubscribers<Id> listOfSubscribers;
	
	public RemoteCalledPublisherImpl() {
		super();
		this.listOfSubscribers = new ThreadSafeListOfSubscribers<Id>();
	}

	public synchronized void addObserver(SubscriberMetadata<Id> o) {
		if (o == null)
			throw new NullPointerException();
		if (!listOfSubscribers.contains(o)) {
			listOfSubscribers.add(o);
		}
	}

	public synchronized void deleteObserver(SubscriberMetadata<Id> o) {
		listOfSubscribers.remove(o);
	}

}