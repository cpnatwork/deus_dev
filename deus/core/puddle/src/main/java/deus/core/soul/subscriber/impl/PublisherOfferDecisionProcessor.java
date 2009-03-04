package deus.core.soul.subscriber.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import deus.core.access.transport.core.receiving.soulcallback.SubscriberExportedToPeer;
import deus.core.access.transport.core.sending.command.SubscriberCommandSender;
import deus.core.soul.decisionprocessor.GenericDecisionProcessor;
import deus.model.attention.decision.PublisherOffer;
import deus.model.user.UserMetadata;
import deus.model.user.id.UserId;

public class PublisherOfferDecisionProcessor implements GenericDecisionProcessor<PublisherOffer> {


	@Autowired
	@Qualifier("target")
	private SubscriberExportedToPeer subscriber;

	
	@Autowired
	private SubscriberCommandSender subscriberCommandSender;


	@Override
	public void process(UserId userId, PublisherOffer publisherOffer) {
		if (!publisherOffer.isDecisionMade())
			throw new IllegalStateException("decision (" + publisherOffer + ") is not made yet");

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
