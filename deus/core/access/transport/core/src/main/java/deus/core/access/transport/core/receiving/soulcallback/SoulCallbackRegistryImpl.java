package deus.core.access.transport.core.receiving.soulcallback;

import org.springframework.stereotype.Component;

import deus.core.access.transport.core.receiving.soulcallback.publishing.PublisherExportedToPeer;
import deus.core.access.transport.core.receiving.soulcallback.subscription.SubscriberExportedToPeer;


@Component("soulCallbackRegistry")
public class SoulCallbackRegistryImpl implements SoulCallbackRegistry {

	private PublisherExportedToPeer publisher;

	private SubscriberExportedToPeer subscriber;


	@Override
	public PublisherExportedToPeer getPublisher() {
		return publisher;
	}


	@Override
	public SubscriberExportedToPeer getSubscriber() {
		return subscriber;
	}


	@Override
	public void registerPublisher(PublisherExportedToPeer publisher) {
		this.publisher = publisher;
	}


	@Override
	public void registerSubscriber(SubscriberExportedToPeer subscriber) {
		this.subscriber = subscriber;
	}
	
}
