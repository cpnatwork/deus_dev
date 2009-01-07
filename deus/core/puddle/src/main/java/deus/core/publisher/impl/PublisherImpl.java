package deus.core.publisher.impl;

import deus.core.publisher.Publisher;
import deus.core.subscriber.SubscriberStub;
import deus.core.subscriber.SubscriberStubFactory;
import deus.model.contactprofile.proj.party.PartyId;
import deus.model.pub.ListOfSubscribers;
import deus.model.pub.SubscriberMetadata;
import deus.model.pub.impl.ThreadSafeListOfSubscribers;
import deus.model.sub.PublisherMetadata;

public class PublisherImpl<T extends PartyId> implements Publisher<T> {

	private final PublisherMetadata<T> publisherMetadata;
	private final ListOfSubscribers<T> observers;

	private SubscriberStubFactory subscriberStubFactory;

	public PublisherImpl(PublisherMetadata<T> publisherMetadata) {
		super();
		this.publisherMetadata = publisherMetadata;
		this.observers = new ThreadSafeListOfSubscribers<T>();
	}


	public synchronized void addObserver(SubscriberMetadata<T> o) {
		if (o == null)
			throw new NullPointerException();
		if (!observers.contains(o)) {
			observers.add(o);
		}
	}


	public synchronized void deleteObserver(SubscriberMetadata<T> o) {
		observers.remove(o);
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
			arrLocal = observers.toArray();
		}

		for (int i = arrLocal.length - 1; i >= 0; i--) {
			SubscriberMetadata<T> subscriberMetadata = (SubscriberMetadata<T>) arrLocal[i];
			SubscriberStub<T> subscriber = subscriberStubFactory.createSubscriberStub(subscriberMetadata, publisherMetadata);
			// TODO: remove this
			//SubscriberStub<T> subscriber = new LocalSubscriberStub<T>(subscriberMetadata);
			subscriber.update(this, change);
		}
	}


	public synchronized void deleteObservers() {
		observers.clear();
	}


	public synchronized int countObservers() {
		return observers.size();
	}


	@Override
	public PublisherMetadata<T> getPublisherMetadata() {
		return publisherMetadata;
	}


	public void setSubscriberStubFactory(SubscriberStubFactory subscriberStubFactory) {
		this.subscriberStubFactory = subscriberStubFactory;
	}
	
}
