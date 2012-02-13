package deus.model.hci.attention.repatriation;

import deus.model.common.dossier.DigitalCard;
import deus.model.common.user.UserMetadata;
import deus.model.hci.attention.BinaryDecisionToMake;
import deus.model.hci.attention.DecisionType;

public class Repatriation extends BinaryDecisionToMake {

	private final UserMetadata contributorMetadata;

	private final DigitalCard contributedDigitalCard;


	public Repatriation(UserMetadata contributorMetadata, DigitalCard contributedDigitalCard) {
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
