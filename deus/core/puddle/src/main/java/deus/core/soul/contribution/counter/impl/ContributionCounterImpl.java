package deus.core.soul.contribution.counter.impl;

import deus.core.soul.barker.Barker;
import deus.core.soul.contribution.counter.ContributionCounter;
import deus.core.soul.contribution.update.Updater;
import deus.model.attention.decision.BinaryDecisionToMake;
import deus.model.attention.decision.Contribution;
import deus.model.dossier.DigitalCard;
import deus.model.user.UserMetadata;
import deus.model.user.id.UserId;

public class ContributionCounterImpl implements ContributionCounter {

	private final UserId userId;

	private final Barker barker;

	private final Updater updater;


	public ContributionCounterImpl(UserId userId, Barker barker, Updater updater) {
		super();
		this.userId = userId;
		this.barker = barker;
		this.updater = updater;
	}


	private void checkDc(DigitalCard contributedDigitalCard) {
		// TODO: do we use RuntimeException here?
		if (!userId.equals(contributedDigitalCard.getCpId()))
			throw new RuntimeException(
					"ID of the CP is not the ID of the user, that is handled in this contribution counter");
	}


	@Override
	public void contributeSelf(DigitalCard contributedDigitalCard) {
		checkDc(contributedDigitalCard);
		updater.commit(contributedDigitalCard);
	}


	@Override
	public void contributeOther(DigitalCard contributedDigitalCard, UserId contributorId) {
		checkDc(contributedDigitalCard);

		// TODO: do we use RuntimeException here?
		if (!contributorId.equals(contributedDigitalCard.getContributorId()))
			throw new RuntimeException("ID of the contributor does not match the id in the digital card!");

		// FIXME: do contributors need to register before contributing????
		// if not, than a UserMetadata of should be passed to contribute()
		// otherwise a Map<UserId, UserMetadata> of the contributors should be added

		UserMetadata contributorMetadata = null;

		BinaryDecisionToMake decision = new Contribution(contributorMetadata, contributedDigitalCard);
		barker.addUnnoticedAttentionElement(decision);
	}

}
