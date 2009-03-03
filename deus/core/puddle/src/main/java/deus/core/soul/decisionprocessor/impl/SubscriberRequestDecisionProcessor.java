package deus.core.soul.decisionprocessor.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import deus.core.access.transport.core.receiving.soulcallback.PublisherExportedToPeer;
import deus.core.access.transport.core.sending.command.BarkerCommandSender;
import deus.model.attention.decision.SubscriberRequest;
import deus.model.user.UserMetadata;
import deus.model.user.id.UserId;

@Component
public class SubscriberRequestDecisionProcessor implements GenericDecisionProcessor<SubscriberRequest> {

	@Autowired
	@Qualifier("target")
	private PublisherExportedToPeer publisher;
	
	@Autowired
	private BarkerCommandSender barkerCommandSender;


	@Override
	public void process(UserId userId, SubscriberRequest subscriberRequest) {
		if (!subscriberRequest.isDecisionMade())
			throw new IllegalStateException("decision (" + subscriberRequest + ") is not made yet");
		
		UserMetadata subscriberMetadata = subscriberRequest.getSubscriberMetadata();
				
		if (subscriberRequest.isDecisionPositive()) {
			publisher.addSubscriber(userId, subscriberRequest.getSubscriberId(), subscriberMetadata);
	
			barkerCommandSender.grantSubscription(userId, subscriberRequest.getSubscriberId());
		}
		else {
			// do not add observer
			
			barkerCommandSender.denySubscription(userId, subscriberRequest.getSubscriberId());
		}
	}

}
