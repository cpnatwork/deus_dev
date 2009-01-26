package deus.model.sub.impl;

import java.util.Iterator;
import java.util.Map;

import deus.model.sub.ListOfPublishers;
import deus.model.sub.PublisherMetadata;
import deus.model.sub.SubscriptionState;

// TODO: think about thread safety! (before, this was implemented using a Vector!)
public class ThreadSafeListOfPublishers implements ListOfPublishers {

	private Map<PublisherMetadata, SubscriptionState> publishers;


	@Override
	public void add(PublisherMetadata publisherMetadata, SubscriptionState subscriptionState) {
		if (publishers.containsKey(publisherMetadata))
			throw new IllegalArgumentException("cannot add publisher (" + publisherMetadata
					+ " to list, it has already been added.");

		publishers.put(publisherMetadata, subscriptionState);
	}


	@Override
	public void changeState(PublisherMetadata publisherMetadata, SubscriptionState subscriptionState) {
		if (publishers.containsKey(publisherMetadata))
			throw new IllegalStateException("cannot change state of publisher (" + publisherMetadata
					+ ", it has not been added yet.");
	}


	@Override
	public boolean contains(PublisherMetadata publisherMetadata) {
		return publishers.containsKey(publisherMetadata);
	}


	@Override
	public void remove(PublisherMetadata publisherMetadata) {
		publishers.remove(publisherMetadata);
	}


	@Override
	public Iterator<PublisherMetadata> iterator() {
		return publishers.keySet().iterator();
	}

}
