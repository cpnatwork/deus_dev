package deus.core.soul.repatriationhub.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import deus.core.soul.hci.barker.BarkerExportedToSubsystems;
import deus.core.soul.pifgoverning.PifGovernor;
import deus.core.soul.repatriationhub.RepatriationHub;
import deus.model.common.dossier.DigitalCard;
import deus.model.common.user.UserMetadata;
import deus.model.common.user.frids.ContributorId;
import deus.model.common.user.frids.RepatriationAuthorityId;
import deus.model.common.user.id.UserId;
import deus.model.hci.attention.BinaryDecisionToMake;
import deus.model.hci.attention.repatriation.Repatriation;

@Component("repatriationHub")
public class RepatriationHubImpl implements RepatriationHub {

	@Autowired
	private PifGovernor pifGovernor;


	@Autowired
	private BarkerExportedToSubsystems barker;

	@Override
	public void accept(RepatriationAuthorityId repatriationAuthorityId, ContributorId contributorId, DigitalCard repatriatedDigitalCard) {
		if (!repatriationAuthorityId.equals(repatriatedDigitalCard.getDigitalCardId().getCpId()))
			throw new IllegalArgumentException(
					"ID of the CP is not the ID of the user, that is handled in this repatriation hub");

		if (!contributorId.equals(repatriatedDigitalCard.getDigitalCardId().getContributorId()))
			throw new IllegalArgumentException("ID of the informationProvider does not match the id in the digital card!");


		if (repatriationAuthorityId.equals(contributorId)) {
			// if 'I' am the informationProvider
			pifGovernor.assimilateRepatriatedDigitalCard(repatriationAuthorityId, repatriatedDigitalCard);
		}
		else {
			// if the informationProvider is another person
			
			// FIXME: do contributors need to register before contributing????
			// if not, than a UserMetadata of should be passed to contribute()
			// otherwise a Map<UserId, UserMetadata> of the contributors should be added

			UserMetadata contributorMetadata = null;

			BinaryDecisionToMake decision = new Repatriation(contributorMetadata, repatriatedDigitalCard);
			barker.addUnnoticedAttentionElement(repatriationAuthorityId.getUserId(), decision);
		}
		
	}


	
	@Override
	@Deprecated
	public void fireAndForgetAccept(UserId cpId, DigitalCard repatriatedDigitalCard) {
		throw new UnsupportedOperationException("fireAndForgetAccept is not implemented yet");
	}

}
