package deus.core.publisher.impl;

import deus.core.User;
import deus.core.publisher.Publisher;
import deus.core.subscriber.SubscriberStub;
import deus.core.subscriber.SubscriberStubFactory;
import deus.model.pub.ListOfSubscribers;
import deus.model.pub.SubscriberMetadata;
import deus.model.sub.PublisherMetadata;
import deus.remoting.initializerdestroyer.RemoteCommand;
import deus.remoting.initializerdestroyer.impl.AbstractPublisherRemoteCommand;

public class PublisherImpl extends RemoteCalledPublisherImpl implements Publisher {

	private final PublisherMetadata publisherMetadata;

	private SubscriberStubFactory subscriberStubFactory;


	public PublisherImpl(ListOfSubscribers listOfSubscribers, PublisherMetadata publisherMetadata) {
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
	public void notifyObservers(final Object change) {
		/*
		 * a temporary array buffer, used as a snapshot of the state of current Observers.
		 */
		Object[] arrLocal;

		synchronized (this) {
			/*
			 * We don't want the Observer doing callbacks into arbitrary code while holding its own Monitor. The code
			 * where we extract each Observable from the Vector and store the state of the Observer needs
			 * synchronization, but notifying observers does not (should not). The worst result of any potential
			 * race-condition here is that: 1) a newly-added Observer will miss a notification in progress 2) a recently
			 * unregistered Observer will be wrongly notified when it doesn't care
			 */
			arrLocal = listOfSubscribers.toArray();
		}

		for (int i = arrLocal.length - 1; i >= 0; i--) {
			// TODO: think about publishing using multiple threads
			SubscriberMetadata subscriberMetadata = (SubscriberMetadata) arrLocal[i];

			RemoteCommand remoteCommand = new AbstractPublisherRemoteCommand(subscriberMetadata) {

				@Override
				public void execute(SubscriberStub subscriberStub) {
					subscriberStub.update(getPublisherMetadata(), change);
				}

			};
			// TODO: where to get user from.
			User user = null;
			remoteCommand.execute(user);

			// SubscriberStub subscriberStub = subscriberStubFactory.createSubscriberStub(subscriberMetadata, publisherMetadata);
			// subscriberStub.update(getPublisherMetadata(), change);
		}
	}


	@Override
	public ListOfSubscribers getListOfSubscribers() {
		return listOfSubscribers;
	}


	@Override
	public PublisherMetadata getPublisherMetadata() {
		return publisherMetadata;
	}


	public void setSubscriberStubFactory(SubscriberStubFactory subscriberStubFactory) {
		this.subscriberStubFactory = subscriberStubFactory;
	}

}
