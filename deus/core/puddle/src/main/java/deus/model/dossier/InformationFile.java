package deus.model.dossier;

import deus.model.dossier.proj.party.PartyId;
import deus.model.user.UserMetadata;

abstract class InformationFile<Id extends PartyId> {

	private UserMetadata<Id> userMetadata;
	
}
