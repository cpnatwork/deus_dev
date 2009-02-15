package deus.core.soul.barker.decisionprocessors;

import deus.core.soul.contribution.update.Updater;
import deus.model.attention.decision.Contribution;

public class ContributionDecisionProcessor implements DecisionProcessor<Contribution> {

	public final Updater updater;


	public ContributionDecisionProcessor(Updater updater) {
		super();
		this.updater = updater;
	}


	@Override
	public void process(Contribution contributionDecision) {
		if (!contributionDecision.isDecisionMade())
			throw new IllegalStateException("decision (" + contributionDecision + ") is not made yet");


		if (contributionDecision.isDecisionPositive()) {
			updater.commit(contributionDecision.getContributedDigitalCard());
		}
		else {
			// do nothing
		}
	}

}
