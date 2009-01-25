package deus.model.sub;

public interface ListOfPublishers {

	public void add(PublisherMetadata publisherMetadata, SubscriptionState subscriptionState);


	public void remove(PublisherMetadata publisherMetadata);


	public boolean contains(PublisherMetadata publisherMetadata);


	public void changeState(PublisherMetadata publisherMetadata, SubscriptionState subscriptionState);

}
