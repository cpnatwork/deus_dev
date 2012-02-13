package deus.core.soul.subscription;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import deus.core.access.transfer.core.receiving.soulcallback.ExportedSoulCallbackRegistry;
import deus.core.access.transfer.core.receiving.soulcallback.subscription.SubscriberExportedToPeers;

@Named
public class SoulCallbackRegistrator {

	@Inject
	private ExportedSoulCallbackRegistry registry;

	@Inject
	@Named("subscriberProxy")
	private SubscriberExportedToPeers subscriber;

	@PostConstruct
	public void registerCommandReceivers() {
		registry.registerSubscriber(subscriber);
	}
	
}
