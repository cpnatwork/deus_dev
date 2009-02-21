package deus.core.soul.common.pifupdate.impl;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import deus.core.access.storage.api.dossier.api.DossierDao;
import deus.core.soul.common.InformationFileUpdateStrategy;
import deus.core.soul.common.pifupdate.Updater;
import deus.model.dossier.DigitalCard;
import deus.model.dossier.generic.PersonalInformationFile;
import deus.model.user.id.UserId;

@Component
public class UpdaterImpl implements Updater {

	@Resource(name = "personalInformationFileUpdateStrategy")
	private InformationFileUpdateStrategy personalInformationFileUpdateStrategy;

	@Autowired
	private DossierDao dossierDao;


	@Override
	public void commit(UserId cpId, DigitalCard digitalCard) {
		PersonalInformationFile personalInformationFile = dossierDao.getByNaturalId(cpId);

		personalInformationFileUpdateStrategy.update(personalInformationFile, digitalCard);

		dossierDao.store(personalInformationFile);
	}

}
