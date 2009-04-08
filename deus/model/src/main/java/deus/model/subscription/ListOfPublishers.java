package deus.model.subscription;

import java.util.Map;

import deus.model.common.user.id.UserId;

public interface ListOfPublishers extends Map<UserId, LopEntry> {

	public UserId getOwnerId();
	
	public void changeState(UserId publisherId, SubscriberSideSubscriptionState subscriberSideSubscriptionState);

}
