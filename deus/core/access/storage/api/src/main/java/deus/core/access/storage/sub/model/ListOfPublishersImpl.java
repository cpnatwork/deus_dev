package deus.core.access.storage.sub.model;

import java.util.HashMap;

import deus.model.sub.ListOfPublishers;
import deus.model.sub.LopEntry;
import deus.model.sub.SubscriptionState;
import deus.model.user.id.UserId;

// TODO: think about thread safety! (before, this was implemented using a Vector!)
public class ListOfPublishersImpl extends HashMap<UserId, LopEntry> implements ListOfPublishers {

	private static final long serialVersionUID = -4125982682692931045L;


	@Override
	public void changeState(UserId publisherId, SubscriptionState subscriptionState) {
		if (!containsKey(publisherId))
			throw new IllegalArgumentException("cannot change state of publisher " + publisherId
					+ ", it is not on the list!");
		get(publisherId).setSubscriptionState(subscriptionState);
	}

}
