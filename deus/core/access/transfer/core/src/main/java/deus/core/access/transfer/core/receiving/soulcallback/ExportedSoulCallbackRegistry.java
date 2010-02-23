package deus.core.access.transfer.core.receiving.soulcallback;

import deus.core.access.transfer.core.receiving.soulcallback.publication.PublisherExportedToPeers;
import deus.core.access.transfer.core.receiving.soulcallback.repatriationhub.RepatriationHubExportedToPeers;
import deus.core.access.transfer.core.receiving.soulcallback.subscription.SubscriberExportedToPeers;

public interface ExportedSoulCallbackRegistry {

	public void registerPublisher(PublisherExportedToPeers publisher);

	public void registerSubscriber(SubscriberExportedToPeers subscriber);

	public void registerRepatriationHub(RepatriationHubExportedToPeers repatriationHub);

}