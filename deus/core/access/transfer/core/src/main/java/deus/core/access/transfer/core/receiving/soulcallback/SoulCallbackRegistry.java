package deus.core.access.transfer.core.receiving.soulcallback;

import deus.core.access.transfer.core.receiving.soulcallback.publishing.PublisherExportedToPeer;
import deus.core.access.transfer.core.receiving.soulcallback.subscription.SubscriberExportedToPeer;

public interface SoulCallbackRegistry extends ExportedSoulCallbackRegistry {

	public abstract PublisherExportedToPeer getPublisher();


	public abstract SubscriberExportedToPeer getSubscriber();

}