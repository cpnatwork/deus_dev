package dacus.core.publisher;

import dacus.model.contactprofile.proj.party.PartyId;
import dacus.model.pub.SubscriberMetadata;
import dacus.model.sub.PublisherMetadata;


public interface PublisherStub<T extends PartyId> {

	public void addObserver(SubscriberMetadata<T> subscriber);


	public void notifyObservers();


	public PublisherMetadata<T> getPublisherMetadata();

}