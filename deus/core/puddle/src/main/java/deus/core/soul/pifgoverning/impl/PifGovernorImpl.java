package deus.core.soul.pifgoverning.impl;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import deus.core.access.storage.api.pie.PifDoRep;
import deus.core.soul.common.InformationFileUpdateStrategy;
import deus.core.soul.pifgoverning.PifGovernor;
import deus.model.dossier.DigitalCard;
import deus.model.pie.PersonalInformationFile;
import deus.model.user.id.UserId;

@Component("pifGovernor")
public class PifGovernorImpl implements PifGovernor {


	@Resource(name = "personalInformationFileUpdateStrategy")
	private InformationFileUpdateStrategy personalInformationFileUpdateStrategy;


	@Autowired
	private PifDoRep pifDoRep;
	

	@Override
	public void assimilateRepatriatedDigitalCard(UserId cpId, DigitalCard digitalCard) {
		PersonalInformationFile personalInformationFile = pifDoRep.getByNaturalId(cpId);

		personalInformationFileUpdateStrategy.update(personalInformationFile, digitalCard);

		pifDoRep.updateEntity(cpId, personalInformationFile);
	}


	@Override
	public PersonalInformationFile getPersonalInformationFile(UserId cpId) {
		return pifDoRep.getByNaturalId(cpId);
	}

}
