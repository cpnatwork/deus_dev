package deus.model.attention.decision;

import deus.model.dossier.DigitalCard;
import deus.model.user.UserMetadata;

public class Contribution extends BinaryDecisionToMake {

	private final UserMetadata contributorMetadata;

	private final DigitalCard contributedDigitalCard;


	public Contribution(UserMetadata contributorMetadata, DigitalCard contributedDigitalCard) {
		super();
		this.contributorMetadata = contributorMetadata;
		this.contributedDigitalCard = contributedDigitalCard;
	}


	public UserMetadata getContributorMetadata() {
		return contributorMetadata;
	}


	public DigitalCard getContributedDigitalCard() {
		return contributedDigitalCard;
	}


	@Override
	public DecisionType getType() {
		return DecisionType.contribution;
	}


	@Override
	public String getCatchphare() {
		// TODO Auto-generated method stub
		return null;
	}

}
