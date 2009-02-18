package deus.core.access.storage.dossier.api;

import deus.model.dossier.generic.PersonalInformationFile;
import deus.model.user.id.UserId;


public interface DossierDao { // extends Dao<DomT, KeyT> { 

	public PersonalInformationFile getByNaturalId(UserId userId);
	
	public void store(PersonalInformationFile personalInformationFile);
	
}
