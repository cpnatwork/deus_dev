package deus.model.sub;

import deus.model.user.UserMetadata;

public interface ListOfPublishers extends Iterable<UserMetadata> {

	public void add(UserMetadata publisherMetadata, SubscriptionState subscriptionState);


	public void remove(UserMetadata publisherMetadata);


	public boolean contains(UserMetadata publisherMetadata);


	public void changeState(UserMetadata publisherMetadata, SubscriptionState subscriptionState);
	
	
	public int size();

}
