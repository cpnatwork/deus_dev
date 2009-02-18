package deus.core.soul.decisionprocessor.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import deus.core.soul.contribution.update.Updater;
import deus.model.attention.decision.Contribution;

@Component
public class ContributionDecisionProcessor implements GenericDecisionProcessor<Contribution> {

	@Autowired
	public Updater updater;


	@Override
	public void process(Contribution contributionDecision) {
		if (!contributionDecision.isDecisionMade())
			throw new IllegalStateException("decision (" + contributionDecision + ") is not made yet");


		if (contributionDecision.isDecisionPositive()) {
			updater.commit(contributionDecision.getUserId(), contributionDecision.getContributedDigitalCard());
		}
		else {
			// do nothing
		}
	}

}
