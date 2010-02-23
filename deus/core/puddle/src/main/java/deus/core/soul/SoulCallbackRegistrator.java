package deus.core.soul;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import deus.core.access.transfer.core.receiving.soulcallback.ExportedSoulCallbackRegistry;
import deus.core.access.transfer.core.receiving.soulcallback.publication.PublisherExportedToPeers;
import deus.core.access.transfer.core.receiving.soulcallback.repatriationhub.RepatriationHubExportedToPeers;
import deus.core.access.transfer.core.receiving.soulcallback.subscription.SubscriberExportedToPeers;

@Component
public class SoulCallbackRegistrator {

	@Autowired
	private ExportedSoulCallbackRegistry registry;

	@Autowired
	@Qualifier("proxy")
	private PublisherExportedToPeers publisher;

	@Autowired
	@Qualifier("proxy")
	private SubscriberExportedToPeers subscriber;
	
	@Autowired
	private RepatriationHubExportedToPeers repatriationHub;

	@PostConstruct
	public void registerCommandReceivers() {
		registry.registerPublisher(publisher);
		registry.registerSubscriber(subscriber);
		registry.registerRepatriationHub(repatriationHub);
	}
	
}
