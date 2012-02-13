package deus.core.access.transfer.core.receiving.soulcallback;

import javax.inject.Named;

import deus.core.access.transfer.core.receiving.soulcallback.publication.PublisherExportedToPeers;
import deus.core.access.transfer.core.receiving.soulcallback.repatriationhub.RepatriationHubExportedToPeers;
import deus.core.access.transfer.core.receiving.soulcallback.subscription.SubscriberExportedToPeers;


@Named("soulCallbackRegistry")
public class SoulCallbackRegistryImpl implements SoulCallbackRegistry {

	private PublisherExportedToPeers publisher;

	private SubscriberExportedToPeers subscriber;

	private RepatriationHubExportedToPeers repatriationHub;

	@Override
	public PublisherExportedToPeers getPublisher() {
		return publisher;
	}


	@Override
	public SubscriberExportedToPeers getSubscriber() {
		return subscriber;
	}


	@Override
	public void registerPublisher(PublisherExportedToPeers publisher) {
		this.publisher = publisher;
	}


	@Override
	public void registerSubscriber(SubscriberExportedToPeers subscriber) {
		this.subscriber = subscriber;
	}

	@Override
	public void registerRepatriationHub(RepatriationHubExportedToPeers repatriationHub) {
		this.repatriationHub = repatriationHub;
	}


	@Override
	public RepatriationHubExportedToPeers getRepatriationHub() {
		return repatriationHub;
	}
	
}
