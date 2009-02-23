package deus.core.soul.pie.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import deus.core.access.storage.api.dossier.api.DossierDao;
import deus.core.soul.common.pifupdate.Updater;
import deus.core.soul.pie.PersonalInformationEditor;
import deus.model.dossier.PersonalInformationFile;
import deus.model.ifcontent.DigitalCard;
import deus.model.user.id.UserId;

@Component("personalInformationEditor")
public class PersonalInformationEditorImpl implements PersonalInformationEditor {

	@Autowired
	private DossierDao dossierDao;

	@Autowired
	private Updater updater;


	@Override
	public void updatePersonalInformationFile(UserId userId, PersonalInformationFile personalInformationFile) {
		dossierDao.update(userId, personalInformationFile);
	}


	@Override
	public PersonalInformationFile getPersonalInformationFile(UserId userId) {
		return dossierDao.getByNaturalId(userId);
	}


	@Override
	public void contributeDigitalCard(UserId userId, DigitalCard digitalCard) {
		if (!userId.equals(digitalCard.getCpId()))
			throw new IllegalArgumentException(
					"ID of the CP is not the ID of the user, that is handled in this contribution counter");
		
		updater.commit(userId, digitalCard);
	}

}
