package deus.core.soul.publication.decisionprocessor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import deus.core.access.transport.core.receiving.soulcallback.publishing.PublisherExportedToPeer;
import deus.core.access.transport.core.sending.command.PublisherCommandSender;
import deus.core.soul.common.decisionprocessor.impl.AbstractGenericDecisionProcessor;
import deus.model.attention.publication.connection.establish.subinit.SubscriptionRequest;
import deus.model.user.UserMetadata;
import deus.model.user.id.UserId;

// FIXME: rename it to SubscriptionRequestDec...
@Component
public class SubscriberRequestDecisionProcessor extends AbstractGenericDecisionProcessor<SubscriptionRequest> {

	@Autowired
	@Qualifier("target")
	private PublisherExportedToPeer publisher;
	
	@Autowired
	private PublisherCommandSender publisherCommandSender;


	@Override
	protected void processImpl(UserId userId, SubscriptionRequest subscriptionRequest) {
		UserMetadata subscriberMetadata = subscriptionRequest.getSubscriberMetadata();
				
		if (subscriptionRequest.isDecisionPositive()) {
			// FIXME: add this as method to PublisherExportedToDecisionProcessor
			
			publisher.addSubscriber(userId, subscriptionRequest.getSubscriberId(), subscriberMetadata);
	
			publisherCommandSender.grantSubscriptionRequest(userId, subscriptionRequest.getSubscriberId());
		}
		else {
			// FIXME: add this as method to PublisherExportedToDecisionProcessor
			
			// do not add observer
			
			publisherCommandSender.denySubscriptionRequest(userId, subscriptionRequest.getSubscriberId());
		}
	}

}
