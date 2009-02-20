package deus.core.access.storage.inmemory.dossier;

import org.springframework.stereotype.Component;

import deus.core.access.storage.api.dossier.api.DossierDao;
import deus.model.dossier.generic.PersonalInformationFile;
import deus.model.user.id.UserId;

@Component("dossierDao")
public class DossierDaoInmemoryImpl implements DossierDao {

	@Override
	public PersonalInformationFile getByNaturalId(UserId userId) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void store(PersonalInformationFile personalInformationFile) {
		// TODO Auto-generated method stub

	}


	@Override
	public void deletePIF(UserId userId) {
		// TODO Auto-generated method stub
		
	}

}
