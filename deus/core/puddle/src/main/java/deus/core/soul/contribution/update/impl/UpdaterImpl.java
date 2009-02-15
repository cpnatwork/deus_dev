package deus.core.soul.contribution.update.impl;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Configurable;

import deus.core.soul.common.InformationFileUpdateStrategy;
import deus.core.soul.contribution.update.Updater;
import deus.model.dossier.DigitalCard;
import deus.model.dossier.generic.PersonalInformationFile;

@Configurable
public class UpdaterImpl implements Updater {

	@Resource(name = "personalInformationFileUpdateStrategy")
	private InformationFileUpdateStrategy personalInformationFileUpdateStrategy;

	private final PersonalInformationFile personalInformationFile;


	public UpdaterImpl(PersonalInformationFile personalInformationFile) {
		super();
		this.personalInformationFile = personalInformationFile;
	}


	@Override
	public void commit(DigitalCard digitalCard) {
		personalInformationFileUpdateStrategy.update(personalInformationFile, digitalCard);
	}

}
