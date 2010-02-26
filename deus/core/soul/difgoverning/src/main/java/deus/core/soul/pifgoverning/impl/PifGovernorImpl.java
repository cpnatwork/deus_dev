package deus.core.soul.pifgoverning.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import deus.core.access.storage.api.pifgoverning.PifDao;
import deus.core.soul.pifgoverning.AssimilationStrategy;
import deus.core.soul.pifgoverning.PifGovernor;
import deus.model.common.dossier.DigitalCard;
import deus.model.common.dossier.Patch;
import deus.model.common.user.frids.RepatriationAuthorityId;
import deus.model.pifgoverning.PersonalInformationFile;

@Component("pifGovernor")
public class PifGovernorImpl implements PifGovernor {

	@Autowired
	private AssimilationStrategy assimilationStrategy;


	@Autowired
	private PifDao pifDao;
	

	@Override
	public Patch assimilateRepatriatedDigitalCard(RepatriationAuthorityId repatriationAuthorityId, DigitalCard digitalCard) {
		PersonalInformationFile personalInformationFile = pifDao.getByNaturalId(repatriationAuthorityId);

		Patch patch = assimilationStrategy.update(personalInformationFile, digitalCard);

		pifDao.updateEntity(repatriationAuthorityId, personalInformationFile);
		
		return patch;
	}


	@Override
	public PersonalInformationFile getPersonalInformationFile(RepatriationAuthorityId repatriationAuthorityId) {
		return pifDao.getByNaturalId(repatriationAuthorityId);
	}

}
