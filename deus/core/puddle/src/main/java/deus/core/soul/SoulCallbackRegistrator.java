package deus.core.soul;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import deus.core.access.transport.core.receiving.soulcallback.ExportedSoulCallbackRegistry;
import deus.core.access.transport.core.receiving.soulcallback.PublisherExportedToPeer;
import deus.core.access.transport.core.receiving.soulcallback.SubscriberExportedToPeer;

@Component
public class SoulCallbackRegistrator {

	@Autowired
	private ExportedSoulCallbackRegistry registry;

	@Autowired
	@Qualifier("proxy")
	private PublisherExportedToPeer publisher;

	@Autowired
	@Qualifier("proxy")
	private SubscriberExportedToPeer subscriber;


	@PostConstruct
	public void registerCommandReceivers() {
		registry.registerPublisher(publisher);
		registry.registerSubscriber(subscriber);
	}
	
}
