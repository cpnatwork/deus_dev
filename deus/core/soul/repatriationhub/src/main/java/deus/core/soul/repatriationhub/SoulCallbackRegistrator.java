package deus.core.soul.repatriationhub;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import deus.core.access.transfer.core.receiving.soulcallback.ExportedSoulCallbackRegistry;
import deus.core.access.transfer.core.receiving.soulcallback.repatriationhub.RepatriationHubExportedToPeers;

@Component
public class SoulCallbackRegistrator {

	@Autowired
	private ExportedSoulCallbackRegistry registry;

	@Autowired
	private RepatriationHubExportedToPeers repatriationHub;

	@PostConstruct
	public void registerCommandReceivers() {
		registry.registerRepatriationHub(repatriationHub);
	}
	
}
