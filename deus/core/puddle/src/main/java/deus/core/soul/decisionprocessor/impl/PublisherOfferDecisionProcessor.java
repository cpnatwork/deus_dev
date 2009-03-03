package deus.core.soul.decisionprocessor.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import deus.core.access.transport.core.receiving.soulcallback.SubscriberExportedToPeer;
import deus.core.access.transport.core.sending.command.BarkerCommandSender;
import deus.model.attention.decision.PublisherOffer;
import deus.model.user.UserMetadata;
import deus.model.user.id.UserId;

public class PublisherOfferDecisionProcessor implements GenericDecisionProcessor<PublisherOffer> {


	@Autowired
	@Qualifier("target")
	private SubscriberExportedToPeer subscriber;

	
	// FIXME: change to use subscriberCommandSender
	@Autowired
	private BarkerCommandSender barkerCommandSender;


	@Override
	public void process(UserId userId, PublisherOffer publisherOffer) {
		if (!publisherOffer.isDecisionMade())
			throw new IllegalStateException("decision (" + publisherOffer + ") is not made yet");

		UserMetadata publisherMetadata = publisherOffer.getPublisherMetadata();

		if (publisherOffer.isDecisionPositive()) {
			subscriber.addPublisher(userId, publisherOffer.getPublisherId(), publisherMetadata);

			barkerCommandSender.confirmSubscription(userId, publisherOffer.getPublisherId());
		}
		else {
			// do not add observer

			barkerCommandSender.abstainSubscription(userId, publisherOffer.getPublisherId());
		}
	}

}
