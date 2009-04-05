package deus.core.access.transport.core.receiving.soulcallback;

import deus.core.access.transport.core.receiving.soulcallback.publishing.PublisherExportedToPeer;
import deus.core.access.transport.core.receiving.soulcallback.subscription.SubscriberExportedToPeer;


public interface ExportedSoulCallbackRegistry {

	public abstract void registerPublisher(PublisherExportedToPeer publisher);


	public abstract void registerSubscriber(SubscriberExportedToPeer subscriber);

}