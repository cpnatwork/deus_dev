package deus.core.soul.pifgoverning.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import deus.core.access.storage.api.pie.PifDoRep;
import deus.core.soul.pifgoverning.AssimilationStrategy;
import deus.core.soul.pifgoverning.PifGovernor;
import deus.model.common.dossier.DigitalCard;
import deus.model.common.dossier.Patch;
import deus.model.common.user.id.UserId;
import deus.model.pifgoverning.PersonalInformationFile;

@Component("pifGovernor")
public class PifGovernorImpl implements PifGovernor {

	@Autowired
	private AssimilationStrategy assimilationStrategy;


	@Autowired
	private PifDoRep pifDoRep;
	

	@Override
	public Patch assimilateRepatriatedDigitalCard(UserId cpId, DigitalCard digitalCard) {
		PersonalInformationFile personalInformationFile = pifDoRep.getByNaturalId(cpId);

		Patch patch = assimilationStrategy.update(personalInformationFile, digitalCard);

		pifDoRep.updateEntity(cpId, personalInformationFile);
		
		return patch;
	}


	@Override
	public PersonalInformationFile getPersonalInformationFile(UserId cpId) {
		return pifDoRep.getByNaturalId(cpId);
	}

}
