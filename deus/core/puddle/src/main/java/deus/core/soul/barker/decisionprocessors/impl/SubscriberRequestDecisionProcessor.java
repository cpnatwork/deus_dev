package deus.core.soul.barker.decisionprocessors.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;

import deus.core.soul.barker.decisionprocessors.DecisionProcessor;
import deus.core.soul.common.BarkerCommandExecutor;
import deus.core.soul.publisher.Publisher;
import deus.model.attention.decision.SubscriberRequest;
import deus.model.user.UserMetadata;

@Configurable
public class SubscriberRequestDecisionProcessor implements DecisionProcessor<SubscriberRequest> {

	private final Publisher publisher;
	
	@Autowired
	private BarkerCommandExecutor barkerCommandExecutor;


	public SubscriberRequestDecisionProcessor(Publisher publisher) {
		super();
		this.publisher = publisher;
	}


	@Override
	public void process(SubscriberRequest subscriberRequest) {
		if (!subscriberRequest.isDecisionMade())
			throw new IllegalStateException("decision (" + subscriberRequest + ") is not made yet");

		UserMetadata subscriberMetadata = subscriberRequest.getSubscriberMetadata();
		
		if (subscriberRequest.isDecisionPositive()) {
			publisher.addObserver(subscriberMetadata);
	
			barkerCommandExecutor.grantSubscription(subscriberMetadata.getUserId(), publisher.getPublisherMetadata().getUserId());
		}
		else {
			// do not add observer
			
			barkerCommandExecutor.denySubscription(subscriberMetadata.getUserId(), publisher.getPublisherMetadata().getUserId());
		}
	}

}
