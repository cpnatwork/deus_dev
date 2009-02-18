package deus.core.soul.barker.decisionprocessors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import deus.core.access.transport.core.sending.command.BarkerCommandSender;
import deus.core.soul.publisher.PublisherExportedToPeer;
import deus.model.attention.decision.SubscriberRequest;
import deus.model.user.UserMetadata;
import deus.model.user.id.UserId;

@Component
public class SubscriberRequestDecisionProcessor implements DecisionProcessor<SubscriberRequest> {

	@Autowired
	private PublisherExportedToPeer publisher;
	
	@Autowired
	private BarkerCommandSender barkerCommandSender;


	@Override
	public void process(SubscriberRequest subscriberRequest) {
		if (!subscriberRequest.isDecisionMade())
			throw new IllegalStateException("decision (" + subscriberRequest + ") is not made yet");

		UserId userId = subscriberRequest.getUserId();
		
		
		UserMetadata subscriberMetadata = subscriberRequest.getSubscriberMetadata();
				
		if (subscriberRequest.isDecisionPositive()) {
			publisher.addSubscriber(userId, subscriberRequest.getSubscriberId(), subscriberMetadata);
	
			barkerCommandSender.grantSubscription(subscriberRequest.getSubscriberId(), userId);
		}
		else {
			// do not add observer
			
			barkerCommandSender.denySubscription(subscriberRequest.getSubscriberId(), userId);
		}
	}

}
