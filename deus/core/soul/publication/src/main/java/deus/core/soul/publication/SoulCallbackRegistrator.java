package deus.core.soul.publication;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import deus.core.access.transfer.core.receiving.soulcallback.ExportedSoulCallbackRegistry;
import deus.core.access.transfer.core.receiving.soulcallback.publication.PublisherExportedToPeers;

@Component
public class SoulCallbackRegistrator {

	@Autowired
	private ExportedSoulCallbackRegistry registry;

	@Autowired
	@Qualifier("proxy")
	private PublisherExportedToPeers publisher;

	@PostConstruct
	public void registerCommandReceivers() {
		registry.registerPublisher(publisher);
	}
	
}
