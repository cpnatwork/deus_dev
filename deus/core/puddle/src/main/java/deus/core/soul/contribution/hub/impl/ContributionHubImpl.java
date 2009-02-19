package deus.core.soul.contribution.hub.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import deus.core.soul.barker.BarkerExportedToSubsystems;
import deus.core.soul.contribution.hub.ContributionHub;
import deus.core.soul.contribution.update.Updater;
import deus.model.attention.decision.BinaryDecisionToMake;
import deus.model.attention.decision.Contribution;
import deus.model.dossier.DigitalCard;
import deus.model.user.UserMetadata;
import deus.model.user.id.UserId;

@Component("contributionHub")
public class ContributionHubImpl implements ContributionHub {

	@Autowired
	private BarkerExportedToSubsystems barker;

	@Autowired
	private Updater updater;


	private void checkDc(UserId cpId, DigitalCard contributedDigitalCard) {
		if (!cpId.equals(contributedDigitalCard.getCpId()))
			throw new IllegalArgumentException(
					"ID of the CP is not the ID of the user, that is handled in this contribution counter");
	}


	@Override
	public void contributeSelf(UserId cpId, DigitalCard contributedDigitalCard) {
		checkDc(cpId, contributedDigitalCard);
		updater.commit(cpId, contributedDigitalCard);
	}


	@Override
	public void contributeOther(UserId cpId, DigitalCard contributedDigitalCard, UserId contributorId) {
		checkDc(cpId, contributedDigitalCard);

		if (!contributorId.equals(contributedDigitalCard.getContributorId()))
			throw new IllegalArgumentException("ID of the contributor does not match the id in the digital card!");

		// FIXME: do contributors need to register before contributing????
		// if not, than a UserMetadata of should be passed to contribute()
		// otherwise a Map<UserId, UserMetadata> of the contributors should be added

		UserMetadata contributorMetadata = null;

		BinaryDecisionToMake decision = new Contribution(contributorMetadata, contributedDigitalCard);
		decision.setUserId(cpId);
		barker.addUnnoticedAttentionElement(decision);
	}

}
