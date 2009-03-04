package deus.core.soul.repatriation.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import deus.core.soul.barker.BarkerExportedToSubsystems;
import deus.core.soul.pifgoverning.PifGovernor;
import deus.core.soul.repatriation.RepatriationHub;
import deus.model.attention.decision.BinaryDecisionToMake;
import deus.model.attention.decision.Contribution;
import deus.model.dossier.DigitalCard;
import deus.model.user.UserMetadata;
import deus.model.user.id.UserId;

@Component("repatriationHub")
public class RepatriationHubImpl implements RepatriationHub {

	@Autowired
	private PifGovernor pifGovernor;


	@Autowired
	private BarkerExportedToSubsystems barker;


	@Override
	public void accept(UserId cpId, DigitalCard repatriatedDigitalCard, UserId contributorId) {
		if (!cpId.equals(repatriatedDigitalCard.getDigitalCardId().getCpId()))
			throw new IllegalArgumentException(
					"ID of the CP is not the ID of the user, that is handled in this repatriation hub");

		if (!contributorId.equals(repatriatedDigitalCard.getDigitalCardId().getContributorId()))
			throw new IllegalArgumentException("ID of the contributor does not match the id in the digital card!");


		if (cpId.equals(contributorId)) {
			// if 'I' am the contributor
			pifGovernor.assimilateRepatriatedDigitalCard(cpId, repatriatedDigitalCard);
		}
		else {
			// if the contributor is another person
			
			// FIXME: do contributors need to register before contributing????
			// if not, than a UserMetadata of should be passed to contribute()
			// otherwise a Map<UserId, UserMetadata> of the contributors should be added

			UserMetadata contributorMetadata = null;

			BinaryDecisionToMake decision = new Contribution(contributorMetadata, repatriatedDigitalCard);
			barker.addUnnoticedAttentionElement(cpId, decision);
		}
	}


	@Override
	public void fireAndForgetAccept(UserId cpId, DigitalCard repatriatedDigitalCard) {
		// FIXME: implement
		throw new UnsupportedOperationException("fireAndForgetAccept is not implemented yet");
	}

}
