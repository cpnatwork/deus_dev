package deus.model.sub;

import java.util.Map;

import deus.model.user.id.UserId;

public interface ListOfPublishers extends Map<UserId, LopEntry> {

	public void changeState(UserId publisherId, SubscriptionState subscriptionState);

}
