package deus.core.access.transfer.core.receiving.soulcallback;

import deus.core.access.transfer.core.receiving.soulcallback.publication.PublisherExportedToPeers;
import deus.core.access.transfer.core.receiving.soulcallback.repatriationhub.RepatriationHubExportedToPeers;
import deus.core.access.transfer.core.receiving.soulcallback.subscription.SubscriberExportedToPeers;

public interface SoulCallbackRegistry extends ExportedSoulCallbackRegistry {

	public PublisherExportedToPeers getPublisher();

	public SubscriberExportedToPeers getSubscriber();

	public RepatriationHubExportedToPeers getRepatriationHub();

}