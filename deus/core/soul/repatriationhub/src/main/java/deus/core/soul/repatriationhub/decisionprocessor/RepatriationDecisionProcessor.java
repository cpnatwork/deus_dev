package deus.core.soul.repatriationhub.decisionprocessor;

import javax.inject.Inject;
import javax.inject.Named;

import deus.core.soul.hci.decisionprocessor.AbstractGenericDecisionProcessor;
import deus.core.soul.pifgoverning.PifGovernorExportedToSubsystems;
import deus.model.common.user.frids.RepatriationAuthorityId;
import deus.model.common.user.id.UserId;
import deus.model.hci.attention.repatriation.Repatriation;

@Named
public class RepatriationDecisionProcessor extends AbstractGenericDecisionProcessor<Repatriation> {

	@Inject
	public PifGovernorExportedToSubsystems pifGovernor;


	@Override
	protected void processImpl(UserId userId, Repatriation contributionDecision) {
		if (contributionDecision.isDecisionPositive()) {
			pifGovernor.assimilateRepatriatedDigitalCard(new RepatriationAuthorityId(userId), contributionDecision.getContributedDigitalCard());
			
			// FIXME: call contrib.Acked on informationProvider
		}
		else {
			// FIXME: call contrib.Denied on informationProvider
		}
	}

}
