package deus.core.access.transfer.core.receiving.soulcallback;

import org.springframework.stereotype.Component;

import deus.core.access.transfer.core.receiving.soulcallback.publication.PublisherExportedToPeers;
import deus.core.access.transfer.core.receiving.soulcallback.subscription.SubscriberExportedToPeers;


@Component("soulCallbackRegistry")
public class SoulCallbackRegistryImpl implements SoulCallbackRegistry {

	private PublisherExportedToPeers publisher;

	private SubscriberExportedToPeers subscriber;


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
	
}
