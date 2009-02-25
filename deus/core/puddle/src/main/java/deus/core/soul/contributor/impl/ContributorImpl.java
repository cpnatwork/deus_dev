package deus.core.soul.contributor.impl;

import deus.core.soul.contributor.Contributor;
import deus.model.dossier.DigitalCard;
import deus.model.dossier.DigitalCardId;
import deus.model.user.id.UserId;

public class ContributorImpl implements Contributor {

	@Override
	public void forwardToCp(UserId contributorId, UserId cpId, DigitalCard digitalCard) {
		// FIXME: implement (use command sender to repatriate the given digital card to the CP)
	}


	@Override
	public void acknowledgeContribution(UserId contributorId, DigitalCardId digitalCardId) {
		// FIXME: implement (is called by transport to acknowledge the contribution, add a notice to barker)
	}


	@Override
	public void denyContribution(UserId contributorId, DigitalCardId digitalCardId) {
		// FIXME: implement (is called by transport to tell the denial of the contribution, add a notice to barker)
	}

}
