package deus.core.soul.publication.impl;

import javax.inject.Inject;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import deus.core.access.storage.api.publication.LosEntryDao;
import deus.core.access.transfer.core.receiving.soulcallback.publication.PublisherExportedToPeers;
import deus.core.soul.hci.barker.BarkerExportedToSubsystems;
import deus.model.common.user.UserMetadata;
import deus.model.common.user.frids.PublisherId;
import deus.model.common.user.frids.SubscriberId;
import deus.model.hci.attention.BinaryDecisionToMake;
import deus.model.hci.attention.Notice;
import deus.model.hci.attention.publication.connection.establish.pubinit.SubscriptionConfirmedNotice;
import deus.model.hci.attention.publication.connection.establish.pubinit.SubscriptionRepelNotice;
import deus.model.hci.attention.publication.connection.establish.subinit.SubscriptionRequest;
import deus.model.hci.attention.publication.connection.terminate.SubscriberInitiatedTerminationNotice;
import deus.model.publication.LosEntry;

@Named("publisherProxy")
public class PublisherExportedToPeerBarkerProxy implements PublisherExportedToPeers {

	private final Logger logger = LoggerFactory.getLogger(PublisherExportedToPeerBarkerProxy.class);
	
	@Inject
	@Named("targetedPublisher")
	private PublisherExportedToPeers proxiedPublisher;
	
	@Inject
	private BarkerExportedToSubsystems barker;
	
	@Inject
	private LosEntryDao losEntryDao;

	
	@Override
	public void addSubscriber(PublisherId publisherId, SubscriberId subscriberId, UserMetadata subscriberMetadata) {
		logger.trace("proxying call to addObserver");
		
		// PLACE SUBSCRIBER REQUEST
		BinaryDecisionToMake decision = new SubscriptionRequest(subscriberId, subscriberMetadata);
		barker.addUnnoticedAttentionElement(publisherId.getUserId(), decision);
		
		logger.trace("added {} to barker", decision);
	}


	@Override
	public void deleteSubscriber(PublisherId publisherId, SubscriberId subscriberId) {
		logger.trace("proxying call to deleteObserver");
		
		// DELETE OBSERVER
		proxiedPublisher.deleteSubscriber(publisherId, subscriberId);

		LosEntry losEntry = losEntryDao.getByNaturalId(publisherId, subscriberId);
		
		// PLACE NOTICE
		UserMetadata subscriberMetadata = losEntry.getSubscriberMetadata();
		Notice notice = new SubscriberInitiatedTerminationNotice(subscriberMetadata);
		barker.addUnnoticedAttentionElement(publisherId.getUserId(), notice);
		
		logger.trace("added {} to barker", notice);
	}

	
	@Override
	public void subscriptionConfirmed(PublisherId publisherId, SubscriberId subscriberId) {
		logger.debug("proxying call to subscriptionConfirmed");
	
		LosEntry losEntry = losEntryDao.getByNaturalId(publisherId, subscriberId);

		// get publisher metadata out of LoP
		UserMetadata subscriberMetadata = losEntry.getSubscriberMetadata();
		Notice notice = new SubscriptionConfirmedNotice(subscriberMetadata);
		barker.addUnnoticedAttentionElement(publisherId.getUserId(), notice);

		logger.debug("added {} to barker", notice);
		
		proxiedPublisher.subscriptionConfirmed(publisherId, subscriberId);
	}
	

	@Override
	public void subscriptionAbstained(PublisherId publisherId, SubscriberId subscriberId) {
		logger.debug("proxying call to subscriptionAbstained");

		LosEntry losEntry = losEntryDao.getByNaturalId(publisherId, subscriberId);

		// get publisher metadata out of LoP
		UserMetadata subscriberMetadata = losEntry.getSubscriberMetadata();
		Notice notice = new SubscriptionRepelNotice(subscriberMetadata);
		barker.addUnnoticedAttentionElement(publisherId.getUserId(), notice);

		logger.debug("added {} to barker", notice);
		
		proxiedPublisher.subscriptionAbstained(publisherId, subscriberId);
	}

}
