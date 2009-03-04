package deus.core.soul.subscription.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import deus.core.access.storage.api.sub.LopEntryDoRep;
import deus.core.access.transport.core.receiving.soulcallback.SubscriberExportedToPeer;
import deus.core.soul.barker.BarkerExportedToSubsystems;
import deus.model.attention.decision.BinaryDecisionToMake;
import deus.model.attention.decision.PublisherOffer;
import deus.model.attention.notice.Notice;
import deus.model.attention.notice.PublisherInitiatedTerminationNotice;
import deus.model.attention.notice.SubscriptionRequestDeniedNotice;
import deus.model.attention.notice.SubscriptionRequestGrantedNotice;
import deus.model.attention.notice.UpdateNotice;
import deus.model.dossier.DigitalCard;
import deus.model.sub.LopEntry;
import deus.model.user.UserMetadata;
import deus.model.user.id.UserId;

@Component
@Qualifier("proxy")
public class SubscriberExportedToPeerBarkerProxy implements SubscriberExportedToPeer {

	private final Logger logger = LoggerFactory.getLogger(SubscriberExportedToPeerBarkerProxy.class);

	@Autowired
	@Qualifier("target")
	private SubscriberExportedToPeer proxiedSubscriber;

	@Autowired
	private BarkerExportedToSubsystems barker;

	@Autowired
	private LopEntryDoRep lopEntryDoRep;


	@Override
	public void noticeSubscriptionRequestGranted(UserId subscriberId, UserId publisherId) {
		logger.debug("proxying call to acknowledgeSubscription");

		LopEntry lopEntry = lopEntryDoRep.getByNaturalId(publisherId, subscriberId);

		// get publisher metadata out of LoP
		UserMetadata publisherMetadata = lopEntry.getPublisherMetadata();
		Notice notice = new SubscriptionRequestGrantedNotice(publisherMetadata);
		barker.addUnnoticedAttentionElement(subscriberId, notice);

		logger.debug("added {} to barker", notice);
		
		proxiedSubscriber.noticeSubscriptionRequestGranted(subscriberId, publisherId);
	}


	@Override
	public void noticeSubscriptionRequestDenied(UserId subscriberId, UserId publisherId) {
		logger.debug("proxying call to denySubscription");

		LopEntry lopEntry = lopEntryDoRep.getByNaturalId(publisherId, subscriberId);

		// get publisher metadata out of LoP
		UserMetadata publisherMetadata = lopEntry.getPublisherMetadata();
		Notice notice = new SubscriptionRequestDeniedNotice(publisherMetadata);
		barker.addUnnoticedAttentionElement(subscriberId, notice);

		logger.debug("added {} to barker", notice);
		
		proxiedSubscriber.noticeSubscriptionRequestDenied(subscriberId, publisherId);
	}


	@Override
	public void update(UserId subscriberId, UserId publisherId, DigitalCard digitalCard) {
		logger.debug("proxying call to update");

		proxiedSubscriber.update(subscriberId, publisherId, digitalCard);

		LopEntry lopEntry = lopEntryDoRep.getByNaturalId(publisherId, subscriberId);
		Notice notice = new UpdateNotice(lopEntry.getPublisherMetadata(), digitalCard);
		barker.addUnnoticedAttentionElement(subscriberId, notice);

		logger.debug("added {} to barker", notice);
	}


	@Override
	public void addPublisher(UserId subscriberId, UserId publisherId, UserMetadata publisherMetadata) {
		logger.debug("proxying call to addPublisher");

		// PLACE PUBLISHER REQUEST
		BinaryDecisionToMake decision = new PublisherOffer(subscriberId, publisherMetadata);
		barker.addUnnoticedAttentionElement(publisherId, decision);
		
		logger.trace("added {} to barker", decision);
	}


	@Override
	public void deletePublisher(UserId subscriberId, UserId publisherId) {
		logger.debug("proxying call to deletePublisher");
		
		// DELETE PUBLISHER
		proxiedSubscriber.deletePublisher(publisherId, subscriberId);

		LopEntry lopEntry = lopEntryDoRep.getByNaturalId(publisherId, subscriberId);
		
		// PLACE NOTICE
		UserMetadata publisherMetadata = lopEntry.getPublisherMetadata();
		Notice notice = new PublisherInitiatedTerminationNotice(publisherMetadata);
		barker.addUnnoticedAttentionElement(publisherId, notice);
		
		logger.trace("added {} to barker", notice);
	}

}