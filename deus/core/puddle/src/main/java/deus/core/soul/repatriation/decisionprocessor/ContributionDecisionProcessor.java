package deus.core.soul.repatriation.decisionprocessor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import deus.core.soul.common.decisionprocessor.impl.AbstractGenericDecisionProcessor;
import deus.core.soul.pifgoverning.PifGovernor;
import deus.model.attention.decision.Contribution;
import deus.model.user.id.UserId;

@Component
public class ContributionDecisionProcessor extends AbstractGenericDecisionProcessor<Contribution> {

	@Autowired
	public PifGovernor pifGovernor;


	@Override
	protected void processImpl(UserId userId, Contribution contributionDecision) {
		if (contributionDecision.isDecisionPositive()) {
			pifGovernor.assimilateRepatriatedDigitalCard(userId, contributionDecision.getContributedDigitalCard());
		}
		else {
			// do nothing
		}
	}

}
