package deus.model.sub.impl;

import java.util.HashMap;

import deus.model.sub.ListOfPublishers;
import deus.model.sub.SubscriptionState;
import deus.model.user.UserMetadata;

// TODO: think about thread safety! (before, this was implemented using a Vector!)
public class ThreadSafeListOfPublishers extends HashMap<UserMetadata, SubscriptionState> implements ListOfPublishers {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4125982682692931045L;

	@Override
	public void changeState(UserMetadata publisherMetadata, SubscriptionState subscriptionState) {
		if(!containsKey(publisherMetadata))
			throw new IllegalArgumentException("cannot change state of publisher " + publisherMetadata + ", it is not on the list!");
		put(publisherMetadata, subscriptionState);
	}


}
