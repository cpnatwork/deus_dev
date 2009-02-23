package deus.core.soul.pie.impl;

import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import deus.core.access.storage.api.dossier.api.DossierDao;
import deus.core.soul.common.AbstractUserRoleSetupObserver;
import deus.model.dossier.DigitalCard;
import deus.model.pie.PersonalInformationFile;
import deus.model.user.UserRole;
import deus.model.user.id.UserId;

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
		dossierDao.store(new PersonalInformationFile(userId, new HashSet<DigitalCard>()));
	}


	@Override
	protected void tearDownRole(UserId userId) {
		dossierDao.deletePIF(userId);
	}

}
