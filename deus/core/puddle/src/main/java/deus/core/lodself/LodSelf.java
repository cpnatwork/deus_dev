package deus.core.lodself;

import deus.model.dossier.generic.PersonalInformationFile;
import deus.model.user.id.UserId;

public class LodSelf<Id extends UserId, PifContentType> {
	
	// TODO: think about the PIF belonging to LodSelf
	private PersonalInformationFile<UserId, PifContentType> personalInformationFile;

}
