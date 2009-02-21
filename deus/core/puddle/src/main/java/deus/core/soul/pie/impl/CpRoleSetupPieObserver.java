package deus.core.soul.pie.impl;

import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import deus.core.access.storage.api.dossier.api.DossierDao;
import deus.gatekeeper.registrator.UserRegistrationStateObserver;
import deus.model.dossier.DigitalCard;
import deus.model.dossier.deus.PersonalPatientFile;
import deus.model.user.id.UserId;

//FIXME: add as observer to UserRoleSetup
@Component
public class CpRoleSetupPieObserver implements UserRegistrationStateObserver {

	@Autowired
	private DossierDao dossierDao;
	
	
	@Override
	public void registered(UserId userId) {
		// FIXME: which subtype of PIF to create here?
		dossierDao.store(new PersonalPatientFile(new HashSet<DigitalCard>()));
	}

	@Override
	public void unregistered(UserId userId) {
		dossierDao.deletePIF(userId);
	}

}
