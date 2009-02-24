package deus.core.soul.publisher.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import deus.core.access.storage.api.pub.api.LosEntryDoRep;
import deus.core.access.transport.core.receiving.soulcallback.PublisherExportedToPeer;
import deus.core.soul.barker.BarkerExportedToSubsystems;
import deus.model.attention.decision.BinaryDecisionToMake;
import deus.model.attention.decision.SubscriberRequest;
import deus.model.attention.notice.Notice;
import deus.model.attention.notice.SubscribedProfileDeletedNotice;
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
		decision.setUserId(publisherId);
		barker.addUnnoticedAttentionElement(decision);
		
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
		Notice notice = new SubscribedProfileDeletedNotice(subscriberMetadata);
		notice.setUserId(publisherId);
		barker.addUnnoticedAttentionElement(notice);
		
		logger.trace("added {} to barker", notice);
	}

}
