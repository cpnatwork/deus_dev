package deus.gatekeeper.registrator.rolesetup;

import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import deus.core.access.storage.api.dossier.api.DossierDao;
import deus.core.access.storage.api.pub.api.PubDao;
import deus.core.access.storage.api.pub.model.ListOfSubscribersImpl;
import deus.model.dossier.DigitalCard;
import deus.model.dossier.deus.PersonalPatientFile;
import deus.model.user.UserRole;
import deus.model.user.id.UserId;

@Component
public class CpRoleSetup implements UserRoleSetup {

	@Autowired
	private PubDao pubDao;


	@Autowired
	private DossierDao dossierDao;


	@Override
	public UserRole getUserRole() {
		return UserRole.cp;
	}


	@Override
	public void setUpRole(UserId userId) {
		pubDao.addNewEntity(new ListOfSubscribersImpl());
		// FIXME: which subtype of PIF to create here?
		dossierDao.store(new PersonalPatientFile(new HashSet<DigitalCard>()));

	}


	@Override
	public void tearDownRole(UserId userId) {
		pubDao.deleteByNaturalId(userId);
		dossierDao.deletePIF(userId);
	}

}
