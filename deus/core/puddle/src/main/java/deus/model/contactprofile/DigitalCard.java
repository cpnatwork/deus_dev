package deus.model.contactprofile;

import deus.model.contactprofile.proj.party.PartyId;
import deus.model.user.UserMetadata;

public abstract class DigitalCard<T extends PartyId> {

	private UserMetadata<T> lod;
	private UserMetadata<T> cp;
	private String nameOfDcInLodEhr;

	private String label;
	
	// TODO: add dates?
	
}
