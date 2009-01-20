package deus.model.dossier;

import deus.model.user.UserMetadata;
import deus.model.user.id.UserId;

// TODO: remove ID template (it makes no sense here, lod and cp may have different id types!)
public abstract class DigitalCard<Id extends UserId> {

	private UserMetadata<Id> lod;
	private UserMetadata<Id> cp;
	private String nameOfDcInLodEhr;

	private String label;
	
	// TODO: add dates?
	
}
