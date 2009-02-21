package deus.core.soul.pie.impl;

import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import deus.core.access.storage.api.dossier.api.DossierDao;
import deus.core.soul.common.AbstractUserRoleSetupObserver;
import deus.model.dossier.DigitalCard;
import deus.model.dossier.deus.PersonalPatientFile;
import deus.model.user.UserRole;
import deus.model.user.id.UserId;

//FIXME: add as observer to UserRoleSetup
@Component
public class CpRoleSetupPieObserver extends AbstractUserRoleSetupObserver {

	@Autowired
	private DossierDao dossierDao;


	@Override
	protected UserRole getUserRole() {
		return UserRole.cp;
	}


	@Override
	protected void setUpRole(UserId userId) {
		// FIXME: which subtype of PIF to create here?
		dossierDao.store(new PersonalPatientFile(new HashSet<DigitalCard>()));
	}


	@Override
	protected void tearDownRole(UserId userId) {
		dossierDao.deletePIF(userId);
	}

}
