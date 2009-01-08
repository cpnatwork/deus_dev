package deus.model.dossier;

import deus.model.dossier.proj.party.PartyId;
import deus.model.user.UserMetadata;

public abstract class DigitalCard<Id extends PartyId> {

	private UserMetadata<Id> lod;
	private UserMetadata<Id> cp;
	private String nameOfDcInLodEhr;

	private String label;
	
	// TODO: add dates?
	
}
