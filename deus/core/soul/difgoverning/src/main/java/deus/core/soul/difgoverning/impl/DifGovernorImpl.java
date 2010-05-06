package deus.core.soul.difgoverning.impl;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import deus.core.access.storage.api.difgoverning.FifDao;
import deus.core.soul.difgoverning.DifGovernor;
import deus.model.common.dossier.DigitalCard;
import deus.model.common.dossier.DigitalCardId;
import deus.model.common.dossier.Patch;
import deus.model.common.user.frids.PublisherId;
import deus.model.common.user.frids.SubscriberId;
import deus.model.common.user.id.UserId;
import deus.model.difgoverning.ForeignInformationFile;

@Named("difGovernor")
public class DifGovernorImpl implements DifGovernor {

	@Inject
	private PatchStrategy patchStrategy;


	@Inject
	private FifDao fifDao;


	@Override
	public void applyPatch(SubscriberId subscriberId, PublisherId publisherId, Patch patch) {
		ForeignInformationFile foreignInformationFile = fifDao.getByNaturalId(subscriberId, publisherId);

		patchStrategy.patch(foreignInformationFile, patch);

		fifDao.updateEntity(subscriberId, publisherId, foreignInformationFile);
	}


	@Override
	public List<UserId> getPublishersInDif(UserId subscriberId) {
		// FIXME: implement
		return null;
	}


	@Override
	public List<DigitalCardId> getDigitalCardIdsInFif(UserId subscriberId, UserId publisherId) {
		// FIXME: implement
		return null;
	}


	@Override
	public DigitalCard getDigitalCardInFif(UserId subscriberId, DigitalCardId digitalCardId) {
		// FIXME: implement
		return null;
	}

}
