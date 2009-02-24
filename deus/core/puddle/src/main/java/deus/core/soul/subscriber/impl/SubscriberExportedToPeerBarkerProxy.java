package deus.core.soul.subscriber.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import deus.core.access.storage.api.sub.LopEntryDoRep;
import deus.core.access.transport.core.receiving.soulcallback.SubscriberExportedToPeer;
import deus.core.soul.barker.BarkerExportedToSubsystems;
import deus.model.attention.notice.Notice;
import deus.model.attention.notice.SubscriptionDeniedNotice;
import deus.model.attention.notice.SubscriptionGrantedNotice;
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
	public void acknowledgeSubscription(UserId subscriberId, UserId publisherId) {
		logger.debug("proxying call to acknowledgeSubscription");

		proxiedSubscriber.acknowledgeSubscription(subscriberId, publisherId);

		LopEntry lopEntry = lopEntryDoRep.getByNaturalId(publisherId, subscriberId);

		// get publisher metadata out of LoP
		UserMetadata publisherMetadata = lopEntry.getPublisherMetadata();
		Notice notice = new SubscriptionGrantedNotice(publisherMetadata);
		barker.addUnnoticedAttentionElement(subscriberId, notice);

		logger.debug("added {} to barker", notice);
	}


	@Override
	public void denySubscription(UserId subscriberId, UserId publisherId) {
		logger.debug("proxying call to denySubscription");

		proxiedSubscriber.denySubscription(subscriberId, publisherId);

		LopEntry lopEntry = lopEntryDoRep.getByNaturalId(publisherId, subscriberId);

		// get publisher metadata out of LoP
		UserMetadata publisherMetadata = lopEntry.getPublisherMetadata();
		Notice notice = new SubscriptionDeniedNotice(publisherMetadata);
		barker.addUnnoticedAttentionElement(subscriberId, notice);

		logger.debug("added {} to barker", notice);
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

}