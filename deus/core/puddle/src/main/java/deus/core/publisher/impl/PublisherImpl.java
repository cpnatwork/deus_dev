package deus.core.publisher.impl;

import deus.core.publisher.Publisher;
import deus.core.subscriber.SubscriberStub;
import deus.core.subscriber.SubscriberStubFactory;
import deus.model.pub.ListOfSubscribers;
import deus.model.pub.SubscriberMetadata;
import deus.model.sub.PublisherMetadata;
import deus.model.user.id.UserId;

public class PublisherImpl<Id extends UserId> extends RemoteCalledPublisherImpl<Id> implements Publisher<Id> {

	private final PublisherMetadata<Id> publisherMetadata;

	private SubscriberStubFactory<Id> subscriberStubFactory;

	public PublisherImpl(ListOfSubscribers<Id> listOfSubscribers, PublisherMetadata<Id> publisherMetadata) {
		super(listOfSubscribers);
		this.publisherMetadata = publisherMetadata;
	}


	public synchronized void deleteObservers() {
		listOfSubscribers.clear();
	}


	public synchronized int countObservers() {
		return listOfSubscribers.size();
	}


	public void notifyObservers() {
		notifyObservers(null);
	}


	@SuppressWarnings("unchecked")
	public void notifyObservers(Object change) {
		/*
		 * a temporary array buffer, used as a snapshot of the state of current
		 * Observers.
		 */
		Object[] arrLocal;

		synchronized (this) {
			/*
			 * We don't want the Observer doing callbacks into arbitrary code
			 * while holding its own Monitor. The code where we extract each
			 * Observable from the Vector and store the state of the Observer
			 * needs synchronization, but notifying observers does not (should
			 * not). The worst result of any potential race-condition here is
			 * that: 1) a newly-added Observer will miss a notification in
			 * progress 2) a recently unregistered Observer will be wrongly
			 * notified when it doesn't care
			 */
			arrLocal = listOfSubscribers.toArray();
		}

		for (int i = arrLocal.length - 1; i >= 0; i--) {
			// TODO: think about publishing using multiple threads
			SubscriberMetadata<Id> subscriberMetadata = (SubscriberMetadata<Id>) arrLocal[i];
			SubscriberStub<Id> subscriber = subscriberStubFactory.createSubscriberStub(subscriberMetadata, publisherMetadata);
			subscriber.update(getPublisherMetadata(), change);
		}
	}


	@Override
	public ListOfSubscribers<Id> getListOfSubscribers() {
		return listOfSubscribers;
	}
	
	
	@Override
	public PublisherMetadata<Id> getPublisherMetadata() {
		return publisherMetadata;
	}


	public void setSubscriberStubFactory(SubscriberStubFactory<Id> subscriberStubFactory) {
		this.subscriberStubFactory = subscriberStubFactory;
	}
	
}
