package deus.core.soul.repatriationhub;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import deus.core.access.transfer.core.receiving.soulcallback.ExportedSoulCallbackRegistry;
import deus.core.access.transfer.core.receiving.soulcallback.repatriationhub.RepatriationHubExportedToPeers;

@Named
public class SoulCallbackRegistrator {

	@Inject
	private ExportedSoulCallbackRegistry registry;

	@Inject
	private RepatriationHubExportedToPeers repatriationHub;

	@PostConstruct
	public void registerCommandReceivers() {
		registry.registerRepatriationHub(repatriationHub);
	}
	
}
