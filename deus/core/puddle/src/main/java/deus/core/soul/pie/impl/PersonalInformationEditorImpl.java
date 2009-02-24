package deus.core.soul.pie.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import deus.core.access.storage.api.pie.PifDoRep;
import deus.core.soul.common.pifupdate.Updater;
import deus.core.soul.pie.PersonalInformationEditor;
import deus.model.dossier.DigitalCard;
import deus.model.pie.PersonalInformationFile;
import deus.model.user.id.UserId;

@Component("personalInformationEditor")
public class PersonalInformationEditorImpl implements PersonalInformationEditor {

	@Autowired
	private PifDoRep pifDoRep;

	@Autowired
	private Updater updater;


	@Override
	public void updatePersonalInformationFile(UserId cpId, PersonalInformationFile personalInformationFile) {
		pifDoRep.updateEntity(cpId, personalInformationFile);
	}


	@Override
	public PersonalInformationFile getPersonalInformationFile(UserId cpId) {
		return pifDoRep.getByNaturalId(cpId);
	}


	@Override
	public void contributeDigitalCard(UserId cpId, DigitalCard digitalCard) {
		if (!cpId.equals(digitalCard.getCpId()))
			throw new IllegalArgumentException(
					"ID of the CP is not the ID of the user, that is handled in this contribution counter");
		
		updater.commit(cpId, digitalCard);
	}

}
