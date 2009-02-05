package deus.core.soul.barker.decisionprocessors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;

import deus.core.soul.publisher.Publisher;
import deus.core.transport.sending.command.BarkerCommandSender;
import deus.model.attention.decision.SubscriberRequest;
import deus.model.user.UserMetadata;

@Configurable
public class SubscriberRequestDecisionProcessor implements DecisionProcessor<SubscriberRequest> {

	private final Publisher publisher;
	
	@Autowired
	private BarkerCommandSender barkerCommandSender;


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
			publisher.addObserver(subscriberRequest.getSubscriberId(), subscriberMetadata);
	
			barkerCommandSender.grantSubscription(subscriberRequest.getSubscriberId(), publisher.getPublisherId());
		}
		else {
			// do not add observer
			
			barkerCommandSender.denySubscription(subscriberRequest.getSubscriberId(), publisher.getPublisherId());
		}
	}

}
