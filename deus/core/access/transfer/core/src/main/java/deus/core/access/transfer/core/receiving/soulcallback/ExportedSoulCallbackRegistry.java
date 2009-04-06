package deus.core.access.transfer.core.receiving.soulcallback;

import deus.core.access.transfer.core.receiving.soulcallback.publishing.PublisherExportedToPeers;
import deus.core.access.transfer.core.receiving.soulcallback.subscription.SubscriberExportedToPeers;


public interface ExportedSoulCallbackRegistry {

	public abstract void registerPublisher(PublisherExportedToPeers publisher);


	public abstract void registerSubscriber(SubscriberExportedToPeers subscriber);

}