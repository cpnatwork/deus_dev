package deus.core.soul.pifgoverning.impl;

import javax.inject.Inject;
import javax.inject.Named;

import deus.core.access.storage.api.pifgoverning.PifDao;
import deus.core.soul.pifgoverning.AssimilationStrategy;
import deus.core.soul.pifgoverning.PifGovernor;
import deus.model.common.dossier.DigitalCard;
import deus.model.common.dossier.Patch;
import deus.model.common.user.frids.RepatriationAuthorityId;
import deus.model.pifgoverning.PersonalInformationFile;

@Named("pifGovernor")
public class PifGovernorImpl implements PifGovernor {

	@Inject
	private AssimilationStrategy assimilationStrategy;


	@Inject
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
