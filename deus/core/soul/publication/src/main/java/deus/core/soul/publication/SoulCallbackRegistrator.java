package deus.core.soul.publication;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import deus.core.access.transfer.core.receiving.soulcallback.ExportedSoulCallbackRegistry;
import deus.core.access.transfer.core.receiving.soulcallback.publication.PublisherExportedToPeers;

@Named
public class SoulCallbackRegistrator {

	@Inject
	private ExportedSoulCallbackRegistry registry;

	@Inject
	@Named("publisherProxy")
	private PublisherExportedToPeers publisher;

	@PostConstruct
	public void registerCommandReceivers() {
		registry.registerPublisher(publisher);
	}
	
}
