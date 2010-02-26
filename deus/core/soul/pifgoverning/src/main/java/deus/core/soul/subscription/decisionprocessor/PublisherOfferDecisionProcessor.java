package deus.core.soul.subscription.decisionprocessor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import deus.core.access.transfer.core.receiving.soulcallback.subscription.SubscriberExportedToPeers;
import deus.core.access.transfer.core.sending.command.SubscriberCommandSender;
import deus.core.soul.hci.decisionprocessor.impl.AbstractGenericDecisionProcessor;
import deus.model.common.user.UserMetadata;
import deus.model.common.user.frids.SubscriberId;
import deus.model.common.user.id.UserId;
import deus.model.hci.attention.publication.connection.establish.pubinit.PublisherOffer;

// FIXME: rename it to SubscriptionOfferDec...
public class PublisherOfferDecisionProcessor extends AbstractGenericDecisionProcessor<PublisherOffer> {


	@Autowired
	@Qualifier("target")
	private SubscriberExportedToPeers subscriber;

	
	@Autowired
	private SubscriberCommandSender subscriberCommandSender;


	@Override
	protected void processImpl(UserId userId, PublisherOffer publisherOffer) {
		UserMetadata publisherMetadata = publisherOffer.getPublisherMetadata();

		if (publisherOffer.isDecisionPositive()) {
			subscriber.addPublisher(new SubscriberId(userId), publisherOffer.getPublisherId(), publisherMetadata);

			subscriberCommandSender.confirmSubscriptionOffer(new SubscriberId(userId), publisherOffer.getPublisherId());
		}
		else {
			// do not add observer

			subscriberCommandSender.repelSubscriptionOffer(new SubscriberId(userId), publisherOffer.getPublisherId());
		}
	}

}
