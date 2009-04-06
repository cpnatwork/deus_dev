package deus.core.access.storage.api.dossier.model.dc.party;

import java.util.UUID;

public abstract class AddressPO extends deus.model.party.Address {

	private UUID uuid;
	
	// FIXME: REMOVE
//	@Id
//	@GeneratedValue(generator = "system-uuid")
//	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	public UUID getUuid() {
		return uuid;
	}
		
	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}
	
}
