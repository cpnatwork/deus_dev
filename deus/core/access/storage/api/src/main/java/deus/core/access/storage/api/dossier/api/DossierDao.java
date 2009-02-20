package deus.core.access.storage.api.dossier.api;

import deus.model.dossier.generic.PersonalInformationFile;
import deus.model.user.id.UserId;


public interface DossierDao { // extends Dao<DomT, KeyT> { 

	public PersonalInformationFile getByNaturalId(UserId userId);
	
	public void store(PersonalInformationFile personalInformationFile);

	public void deletePIF(UserId userId);
	
}
