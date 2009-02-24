package deus.core.soul.decisionprocessor.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import deus.core.soul.common.pifupdate.Updater;
import deus.model.attention.decision.Contribution;
import deus.model.user.id.UserId;

@Component
public class ContributionDecisionProcessor implements GenericDecisionProcessor<Contribution> {

	@Autowired
	public Updater updater;


	@Override
	public void process(UserId userId, Contribution contributionDecision) {
		if (!contributionDecision.isDecisionMade())
			throw new IllegalStateException("decision (" + contributionDecision + ") is not made yet");


		if (contributionDecision.isDecisionPositive()) {
			updater.commit(userId, contributionDecision.getContributedDigitalCard());
		}
		else {
			// do nothing
		}
	}

}
