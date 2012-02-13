package deus.core.soul.publication.decisionprocessor;

import javax.inject.Inject;
import javax.inject.Named;

import deus.core.access.transfer.core.receiving.soulcallback.publication.PublisherExportedToPeers;
import deus.core.access.transfer.core.sending.command.PublisherCommandSender;
import deus.core.soul.hci.decisionprocessor.AbstractGenericDecisionProcessor;
import deus.model.common.user.UserMetadata;
import deus.model.common.user.frids.PublisherId;
import deus.model.common.user.id.UserId;
import deus.model.hci.attention.publication.connection.establish.subinit.SubscriptionRequest;

// FIXME: rename it to SubscriptionRequestDec...
@Named
public class SubscriberRequestDecisionProcessor extends AbstractGenericDecisionProcessor<SubscriptionRequest> {

	@Inject
	@Named("targetedPublisher")
	private PublisherExportedToPeers publisher;
	
	@Inject
	private PublisherCommandSender publisherCommandSender;


	@Override
	protected void processImpl(UserId userId, SubscriptionRequest subscriptionRequest) {
		UserMetadata subscriberMetadata = subscriptionRequest.getSubscriberMetadata();
		
		PublisherId publisherId = new PublisherId(userId);
		
		if (subscriptionRequest.isDecisionPositive()) {
			// FIXME: add this as method to PublisherExportedToDecisionProcessor
			
			publisher.addSubscriber(publisherId, subscriptionRequest.getSubscriberId(), subscriberMetadata);
	
			publisherCommandSender.grantSubscriptionRequest(publisherId, subscriptionRequest.getSubscriberId());
		}
		else {
			// FIXME: add this as method to PublisherExportedToDecisionProcessor
			
			// do not add observer
			
			publisherCommandSender.denySubscriptionRequest(publisherId, subscriptionRequest.getSubscriberId());
		}
	}

}
