package deus.core.soul.publication.decisionprocessor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import deus.core.access.transport.core.receiving.soulcallback.PublisherExportedToPeer;
import deus.core.access.transport.core.sending.command.PublisherCommandSender;
import deus.core.soul.common.decisionprocessor.impl.AbstractGenericDecisionProcessor;
import deus.model.attention.decision.SubscriberRequest;
import deus.model.user.UserMetadata;
import deus.model.user.id.UserId;

@Component
public class SubscriberRequestDecisionProcessor extends AbstractGenericDecisionProcessor<SubscriberRequest> {

	@Autowired
	@Qualifier("target")
	private PublisherExportedToPeer publisher;
	
	@Autowired
	private PublisherCommandSender publisherCommandSender;


	@Override
	protected void processImpl(UserId userId, SubscriberRequest subscriberRequest) {
		UserMetadata subscriberMetadata = subscriberRequest.getSubscriberMetadata();
				
		if (subscriberRequest.isDecisionPositive()) {
			publisher.addSubscriber(userId, subscriberRequest.getSubscriberId(), subscriberMetadata);
	
			publisherCommandSender.grantSubscriptionRequest(userId, subscriberRequest.getSubscriberId());
		}
		else {
			// do not add observer
			
			publisherCommandSender.denySubscriptionRequest(userId, subscriberRequest.getSubscriberId());
		}
	}

}
