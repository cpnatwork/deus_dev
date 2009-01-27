package deus.model.sub;

import java.util.Map;

import deus.model.user.UserMetadata;

public interface ListOfPublishers extends Map<UserMetadata, SubscriptionState> {

	public void changeState(UserMetadata publisherMetadata, SubscriptionState subscriptionState);

}
