package deus.core.soul.difgoverning.impl;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import deus.core.access.storage.api.sub.DifDoRep;
import deus.core.access.storage.api.sub.FifDoRep;
import deus.core.soul.common.InformationFileUpdateStrategy;
import deus.core.soul.difgoverning.DifGovernor;
import deus.model.dossier.DigitalCard;
import deus.model.dossier.DigitalCardId;
import deus.model.sub.DistributedInformationFolder;
import deus.model.sub.ForeignInformationFile;
import deus.model.user.id.UserId;

@Component("difGovernor")
public class DifGovernorImpl implements DifGovernor {


	@Resource(name = "foreignInformationFileUpdateStrategy")
	private InformationFileUpdateStrategy foreignInformationFileUpdateStrategy;


	@Autowired
	private DifDoRep difDoRep;


	@Autowired
	private FifDoRep fifDoRep;
	
	
	@Override
	public void assimilatePublishedDigitalCard(UserId residentId, UserId cpId, DigitalCard digitalCard) {
		ForeignInformationFile foreignInformationFile = fifDoRep.getByNaturalId(cpId, residentId);

		foreignInformationFileUpdateStrategy.update(foreignInformationFile, digitalCard);

		fifDoRep.updateEntity(residentId, cpId, foreignInformationFile);
	}


	@Override
	public DigitalCard getDigitalCard(UserId residentId, DigitalCardId digitalCardId) {
		return fifDoRep.getDigitalCardInFif(residentId, digitalCardId);
	}


	@Override
	public DistributedInformationFolder getDistributedInformationFolder(UserId residentId) {
		return difDoRep.getByNaturalId(residentId);
	}


	@Override
	public ForeignInformationFile getForeignInformationFile(UserId residentId, UserId cpId) {
		return fifDoRep.getByNaturalId(cpId, residentId);
	}

}
