package deus.core.soul.subscription.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import deus.core.access.storage.api.sub.LopEntryDoRep;
import deus.core.access.transfer.core.receiving.soulcallback.subscription.SubscriberExportedToPeers;
import deus.core.soul.hci.barker.BarkerExportedToSubsystems;
import deus.model.common.dossier.Patch;
import deus.model.common.user.UserMetadata;
import deus.model.common.user.id.UserId;
import deus.model.hci.attention.BinaryDecisionToMake;
import deus.model.hci.attention.Notice;
import deus.model.hci.attention.publication.UpdateNotice;
import deus.model.hci.attention.publication.connection.establish.pubinit.PublisherOffer;
import deus.model.hci.attention.publication.connection.establish.subinit.SubscriptionRequestDeniedNotice;
import deus.model.hci.attention.publication.connection.establish.subinit.SubscriptionRequestGrantedNotice;
import deus.model.hci.attention.publication.connection.terminate.PublisherInitiatedTerminationNotice;
import deus.model.subscription.LopEntry;

@Component
@Qualifier("proxy")
public class SubscriberExportedToPeerBarkerProxy implements SubscriberExportedToPeers {

	private final Logger logger = LoggerFactory.getLogger(SubscriberExportedToPeerBarkerProxy.class);

	@Autowired
	@Qualifier("target")
	private SubscriberExportedToPeers proxiedSubscriber;

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
	public void update(UserId subscriberId, UserId publisherId, Patch patch) {
		logger.debug("proxying call to update");

		proxiedSubscriber.update(subscriberId, publisherId, patch);

		LopEntry lopEntry = lopEntryDoRep.getByNaturalId(publisherId, subscriberId);
		Notice notice = new UpdateNotice(lopEntry.getPublisherMetadata(), patch);
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