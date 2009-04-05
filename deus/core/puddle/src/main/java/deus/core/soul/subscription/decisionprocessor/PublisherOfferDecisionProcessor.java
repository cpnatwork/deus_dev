package deus.core.soul.subscription.decisionprocessor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import deus.core.access.transfer.core.receiving.soulcallback.subscription.SubscriberExportedToPeer;
import deus.core.access.transfer.core.sending.command.SubscriberCommandSender;
import deus.core.soul.common.decisionprocessor.impl.AbstractGenericDecisionProcessor;
import deus.model.attention.publication.connection.establish.pubinit.PublisherOffer;
import deus.model.user.UserMetadata;
import deus.model.user.id.UserId;

// FIXME: rename it to SubscriptionOfferDec...
public class PublisherOfferDecisionProcessor extends AbstractGenericDecisionProcessor<PublisherOffer> {


	@Autowired
	@Qualifier("target")
	private SubscriberExportedToPeer subscriber;

	
	@Autowired
	private SubscriberCommandSender subscriberCommandSender;


	@Override
	protected void processImpl(UserId userId, PublisherOffer publisherOffer) {
		UserMetadata publisherMetadata = publisherOffer.getPublisherMetadata();

		if (publisherOffer.isDecisionPositive()) {
			subscriber.addPublisher(userId, publisherOffer.getPublisherId(), publisherMetadata);

			subscriberCommandSender.confirmSubscriptionOffer(userId, publisherOffer.getPublisherId());
		}
		else {
			// do not add observer

			subscriberCommandSender.repelSubscriptionOffer(userId, publisherOffer.getPublisherId());
		}
	}

}
