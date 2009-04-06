package deus.core.soul.contribution.impl;

import deus.core.soul.contribution.Contributor;
import deus.model.dc.DigitalCard;
import deus.model.dc.DigitalCardId;
import deus.model.user.id.UserId;

public class ContributorImpl implements Contributor {

	@Override
	public void forwardToCp(UserId contributorId, UserId cpId, DigitalCard digitalCard) {
		// FIXME: implement (use command sender to repatriate the given digital card to the CP)
	}


	@Override
	public void contributionAcknowledged(UserId contributorId, DigitalCardId digitalCardId) {
		// FIXME: implement (is called by transfer to acknowledge the contribution, add a notice to barker)
	}


	@Override
	public void contributionDenied(UserId contributorId, DigitalCardId digitalCardId) {
		// FIXME: implement (is called by transfer to tell the denial of the contribution, add a notice to barker)
	}

}
