package deus.core.soul.publication.decisionprocessor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import deus.core.access.transfer.core.receiving.soulcallback.publication.PublisherExportedToPeers;
import deus.core.access.transfer.core.sending.command.PublisherCommandSender;
import deus.core.soul.hci.decisionprocessor.impl.AbstractGenericDecisionProcessor;
import deus.model.common.user.UserMetadata;
import deus.model.common.user.id.UserId;
import deus.model.hci.attention.publication.connection.establish.subinit.SubscriptionRequest;

// FIXME: rename it to SubscriptionRequestDec...
@Component
public class SubscriberRequestDecisionProcessor extends AbstractGenericDecisionProcessor<SubscriptionRequest> {

	@Autowired
	@Qualifier("target")
	private PublisherExportedToPeers publisher;
	
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
