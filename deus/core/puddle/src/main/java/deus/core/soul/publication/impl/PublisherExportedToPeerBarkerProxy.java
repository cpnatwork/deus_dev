package deus.core.soul.publication.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import deus.core.access.storage.api.pub.LosEntryDoRep;
import deus.core.access.transport.core.receiving.soulcallback.publishing.PublisherExportedToPeer;
import deus.core.soul.barker.BarkerExportedToSubsystems;
import deus.model.attention.decision.BinaryDecisionToMake;
import deus.model.attention.decision.SubscriberRequest;
import deus.model.attention.notice.Notice;
import deus.model.attention.notice.SubscriberInitiatedTerminationNotice;
import deus.model.attention.notice.SubscriptionAbstainedNotice;
import deus.model.attention.notice.SubscriptionConfirmedNotice;
import deus.model.pub.LosEntry;
import deus.model.user.UserMetadata;
import deus.model.user.id.UserId;

@Component
@Qualifier("proxy")
public class PublisherExportedToPeerBarkerProxy implements PublisherExportedToPeer {

	private final Logger logger = LoggerFactory.getLogger(PublisherExportedToPeerBarkerProxy.class);
	
	@Autowired
	@Qualifier("target")
	private PublisherExportedToPeer proxiedPublisher;
	
	@Autowired
	private BarkerExportedToSubsystems barker;
	
	@Autowired
	private LosEntryDoRep losEntryDoRep;

	
	@Override
	public void addSubscriber(UserId publisherId, UserId subscriberId, UserMetadata subscriberMetadata) {
		logger.trace("proxying call to addObserver");
		
		// PLACE SUBSCRIBER REQUEST
		BinaryDecisionToMake decision = new SubscriberRequest(subscriberId, subscriberMetadata);
		barker.addUnnoticedAttentionElement(publisherId, decision);
		
		logger.trace("added {} to barker", decision);
	}


	@Override
	public void deleteSubscriber(UserId publisherId, UserId subscriberId) {
		logger.trace("proxying call to deleteObserver");
		
		// DELETE OBSERVER
		proxiedPublisher.deleteSubscriber(publisherId, subscriberId);

		LosEntry losEntry = losEntryDoRep.getByNaturalId(subscriberId, publisherId);
		
		// PLACE NOTICE
		UserMetadata subscriberMetadata = losEntry.getSubscriberMetadata();
		Notice notice = new SubscriberInitiatedTerminationNotice(subscriberMetadata);
		barker.addUnnoticedAttentionElement(publisherId, notice);
		
		logger.trace("added {} to barker", notice);
	}

	
	@Override
	public void subscriptionConfirmed(UserId publisherId, UserId subscriberId) {
		logger.debug("proxying call to subscriptionConfirmed");
	
		LosEntry losEntry = losEntryDoRep.getByNaturalId(subscriberId, publisherId);

		// get publisher metadata out of LoP
		UserMetadata subscriberMetadata = losEntry.getSubscriberMetadata();
		Notice notice = new SubscriptionConfirmedNotice(subscriberMetadata);
		barker.addUnnoticedAttentionElement(publisherId, notice);

		logger.debug("added {} to barker", notice);
		
		proxiedPublisher.subscriptionConfirmed(publisherId, subscriberId);
	}
	

	@Override
	public void subscriptionAbstained(UserId publisherId, UserId subscriberId) {
		logger.debug("proxying call to subscriptionAbstained");

		LosEntry losEntry = losEntryDoRep.getByNaturalId(subscriberId, publisherId);

		// get publisher metadata out of LoP
		UserMetadata subscriberMetadata = losEntry.getSubscriberMetadata();
		Notice notice = new SubscriptionAbstainedNotice(subscriberMetadata);
		barker.addUnnoticedAttentionElement(publisherId, notice);

		logger.debug("added {} to barker", notice);
		
		proxiedPublisher.subscriptionAbstained(publisherId, subscriberId);
	}

}
