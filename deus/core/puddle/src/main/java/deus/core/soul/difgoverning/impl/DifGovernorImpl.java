package deus.core.soul.difgoverning.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import deus.core.access.storage.api.sub.DifDoRep;
import deus.core.access.storage.api.sub.FifDoRep;
import deus.core.soul.difgoverning.DifGovernor;
import deus.model.dc.DigitalCard;
import deus.model.dc.DigitalCardId;
import deus.model.difgoverning.ForeignInformationFile;
import deus.model.dossier.Patch;
import deus.model.user.id.UserId;

@Component("difGovernor")
public class DifGovernorImpl implements DifGovernor {

	@Autowired
	private PatchStrategy patchStrategy;


	@Autowired
	private DifDoRep difDoRep;


	@Autowired
	private FifDoRep fifDoRep;


	@Override
	public void applyPatch(UserId residentId, UserId cpId, Patch patch) {
		ForeignInformationFile foreignInformationFile = fifDoRep.getByNaturalId(cpId, residentId);

		patchStrategy.patch(foreignInformationFile, patch);

		fifDoRep.updateEntity(residentId, cpId, foreignInformationFile);
	}


	@Override
	public List<UserId> getPublishersInDif(UserId subscriberId) {
		return difDoRep.getPublishersInDif(subscriberId);
	}


	@Override
	public List<DigitalCardId> getDigitalCardIdsInFif(UserId subscriberId, UserId publisherId) {
		return fifDoRep.getDigitalCardsInFif(subscriberId, publisherId);
	}


	@Override
	public DigitalCard getDigitalCardInFif(UserId subscriberId, DigitalCardId digitalCardId) {
		return fifDoRep.getDigitalCardInFif(subscriberId, digitalCardId);
	}

}
