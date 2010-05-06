package deus.core.soul.subscription.impl;

import javax.inject.Inject;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import deus.core.access.storage.api.subscription.LopEntryDao;
import deus.core.access.transfer.core.receiving.soulcallback.subscription.SubscriberExportedToPeers;
import deus.core.soul.hci.barker.BarkerExportedToSubsystems;
import deus.model.common.dossier.Patch;
import deus.model.common.user.UserMetadata;
import deus.model.common.user.frids.PublisherId;
import deus.model.common.user.frids.SubscriberId;
import deus.model.hci.attention.BinaryDecisionToMake;
import deus.model.hci.attention.Notice;
import deus.model.hci.attention.publication.UpdateNotice;
import deus.model.hci.attention.publication.connection.establish.pubinit.PublisherOffer;
import deus.model.hci.attention.publication.connection.establish.subinit.SubscriptionRequestDeniedNotice;
import deus.model.hci.attention.publication.connection.establish.subinit.SubscriptionRequestGrantedNotice;
import deus.model.hci.attention.publication.connection.terminate.PublisherInitiatedTerminationNotice;
import deus.model.subscription.LopEntry;

@Named("SubscriberProxy")
public class SubscriberExportedToPeerBarkerProxy implements SubscriberExportedToPeers {

	private final Logger logger = LoggerFactory.getLogger(SubscriberExportedToPeerBarkerProxy.class);

	@Inject
	@Named("targetedSubscriber")
	private SubscriberExportedToPeers proxiedSubscriber;

	@Inject
	private BarkerExportedToSubsystems barker;

	@Inject
	private LopEntryDao lopEntryDao;


	@Override
	public void noticeSubscriptionRequestGranted(SubscriberId subscriberId, PublisherId publisherId) {
		logger.debug("proxying call to acknowledgeSubscription");

		LopEntry lopEntry = lopEntryDao.getByNaturalId(subscriberId, publisherId);

		// get publisher metadata out of LoP
		UserMetadata publisherMetadata = lopEntry.getPublisherMetadata();
		Notice notice = new SubscriptionRequestGrantedNotice(publisherMetadata);
		barker.addUnnoticedAttentionElement(subscriberId.getUserId(), notice);

		logger.debug("added {} to barker", notice);
		
		proxiedSubscriber.noticeSubscriptionRequestGranted(subscriberId, publisherId);
	}


	@Override
	public void noticeSubscriptionRequestDenied(SubscriberId subscriberId, PublisherId publisherId) {
		logger.debug("proxying call to denySubscription");

		LopEntry lopEntry = lopEntryDao.getByNaturalId(subscriberId, publisherId);

		// get publisher metadata out of LoP
		UserMetadata publisherMetadata = lopEntry.getPublisherMetadata();
		Notice notice = new SubscriptionRequestDeniedNotice(publisherMetadata);
		barker.addUnnoticedAttentionElement(subscriberId.getUserId(), notice);

		logger.debug("added {} to barker", notice);
		
		proxiedSubscriber.noticeSubscriptionRequestDenied(subscriberId, publisherId);
	}


	@Override
	public void update(SubscriberId subscriberId, PublisherId publisherId, Patch patch) {
		logger.debug("proxying call to update");

		proxiedSubscriber.update(subscriberId, publisherId, patch);

		LopEntry lopEntry = lopEntryDao.getByNaturalId(subscriberId, publisherId);
		Notice notice = new UpdateNotice(lopEntry.getPublisherMetadata(), patch);
		barker.addUnnoticedAttentionElement(subscriberId.getUserId(), notice);

		logger.debug("added {} to barker", notice);
	}


	@Override
	public void addPublisher(SubscriberId subscriberId, PublisherId publisherId, UserMetadata publisherMetadata) {
		logger.debug("proxying call to addPublisher");

		// PLACE PUBLISHER REQUEST
		BinaryDecisionToMake decision = new PublisherOffer(publisherId, publisherMetadata);
		barker.addUnnoticedAttentionElement(subscriberId.getUserId(), decision);
		
		logger.trace("added {} to barker", decision);
	}


	@Override
	public void deletePublisher(SubscriberId subscriberId, PublisherId publisherId) {
		logger.debug("proxying call to deletePublisher");
		
		// DELETE PUBLISHER
		proxiedSubscriber.deletePublisher(subscriberId, publisherId);

		LopEntry lopEntry = lopEntryDao.getByNaturalId(subscriberId, publisherId);
		
		// PLACE NOTICE
		UserMetadata publisherMetadata = lopEntry.getPublisherMetadata();
		Notice notice = new PublisherInitiatedTerminationNotice(publisherMetadata);
		barker.addUnnoticedAttentionElement(subscriberId.getUserId(), notice);
		
		logger.trace("added {} to barker", notice);
	}

}