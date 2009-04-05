package deus.core.access.transfer.core.receiving.soulcallback;

import deus.core.access.transfer.core.receiving.soulcallback.publishing.PublisherExportedToPeer;
import deus.core.access.transfer.core.receiving.soulcallback.subscription.SubscriberExportedToPeer;


public interface ExportedSoulCallbackRegistry {

	public abstract void registerPublisher(PublisherExportedToPeer publisher);


	public abstract void registerSubscriber(SubscriberExportedToPeer subscriber);

}