package deus.core.soul.subscriber.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import deus.core.access.storage.sub.api.SubDao;
import deus.core.soul.barker.BarkerExportedToSubsystems;
import deus.core.soul.subscriber.SubscriberExportedToPeer;
import deus.model.attention.notice.Notice;
import deus.model.attention.notice.SubscriptionDeniedNotice;
import deus.model.attention.notice.SubscriptionGrantedNotice;
import deus.model.attention.notice.UpdateNotice;
import deus.model.dossier.DigitalCard;
import deus.model.sub.ListOfPublishers;
import deus.model.user.UserMetadata;
import deus.model.user.id.UserId;

@Component
@Qualifier(value="proxy")
public class SubscriberBarkerProxy implements SubscriberExportedToPeer {

	private final Logger logger = LoggerFactory.getLogger(SubscriberBarkerProxy.class);

	@Autowired
	@Qualifier(value="target")
	private SubscriberExportedToPeer proxiedSubscriber;

	@Autowired
	private BarkerExportedToSubsystems barker;

	@Autowired
	private SubDao subDao;


	@Override
	public void acknowledgeSubscription(UserId subscriberId, UserId publisherId) {
		logger.debug("proxying call to acknowledgeSubscription");

		proxiedSubscriber.acknowledgeSubscription(subscriberId, publisherId);

		ListOfPublishers listOfPublishers = subDao.getListOfPublishers(subscriberId);
		
		// get publisher metadata out of LoP
		UserMetadata publisherMetadata = listOfPublishers.get(publisherId).getPublisherMetadata();
		Notice notice = new SubscriptionGrantedNotice(publisherMetadata);
		notice.setUserId(subscriberId);
		barker.addUnnoticedAttentionElement(notice);

		logger.debug("added {} to barker", notice);
	}


	@Override
	public void denySubscription(UserId subscriberId, UserId publisherId) {
		logger.debug("proxying call to denySubscription");

		proxiedSubscriber.denySubscription(subscriberId, publisherId);

		ListOfPublishers listOfPublishers = subDao.getListOfPublishers(subscriberId);
		
		// get publisher metadata out of LoP
		UserMetadata publisherMetadata = listOfPublishers.get(publisherId).getPublisherMetadata();
		Notice notice = new SubscriptionDeniedNotice(publisherMetadata);
		notice.setUserId(subscriberId);
		barker.addUnnoticedAttentionElement(notice);

		logger.debug("added {} to barker", notice);
	}


	@Override
	public void update(UserId subscriberId, UserId publisherId, DigitalCard digitalCard) {
		logger.debug("proxying call to update");

		proxiedSubscriber.update(subscriberId, publisherId, digitalCard);

		ListOfPublishers listOfPublishers = subDao.getListOfPublishers(subscriberId);
		Notice notice = new UpdateNotice(listOfPublishers.get(publisherId).getPublisherMetadata(), digitalCard);
		notice.setUserId(subscriberId);
		barker.addUnnoticedAttentionElement(notice);

		logger.debug("added {} to barker", notice);
	}


}