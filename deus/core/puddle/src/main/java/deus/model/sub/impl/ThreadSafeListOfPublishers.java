package deus.model.sub.impl;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import deus.model.sub.ListOfPublishers;
import deus.model.sub.SubscriptionState;
import deus.model.user.UserMetadata;

// TODO: think about thread safety! (before, this was implemented using a Vector!)
public class ThreadSafeListOfPublishers implements ListOfPublishers {

	private final Map<UserMetadata, SubscriptionState> publishers;

	

	public ThreadSafeListOfPublishers() {
		super();
		this.publishers = new HashMap<UserMetadata, SubscriptionState>();
	}


	@Override
	public void add(UserMetadata publisherMetadata, SubscriptionState subscriptionState) {
		if (publishers.containsKey(publisherMetadata))
			throw new IllegalArgumentException("cannot add publisher (" + publisherMetadata
					+ " to list, it has already been added.");

		publishers.put(publisherMetadata, subscriptionState);
	}


	@Override
	public void changeState(UserMetadata publisherMetadata, SubscriptionState subscriptionState) {
		if (publishers.containsKey(publisherMetadata))
			throw new IllegalStateException("cannot change state of publisher (" + publisherMetadata
					+ ", it has not been added yet.");
	}


	@Override
	public boolean contains(UserMetadata publisherMetadata) {
		return publishers.containsKey(publisherMetadata);
	}


	@Override
	public void remove(UserMetadata publisherMetadata) {
		publishers.remove(publisherMetadata);
	}


	@Override
	public Iterator<UserMetadata> iterator() {
		return publishers.keySet().iterator();
	}


	@Override
	public int size() {
		return publishers.size();
	}

}
