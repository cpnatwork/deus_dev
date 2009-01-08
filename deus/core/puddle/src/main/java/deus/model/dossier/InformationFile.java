package deus.model.dossier;

import deus.model.user.UserMetadata;
import deus.model.user.id.UserId;

abstract class InformationFile<Id extends UserId> {

	private UserMetadata<Id> userMetadata;
	
}
