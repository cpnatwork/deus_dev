package deus.core.soul.subscriber.impl;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
public class SubscriberBarkerProxy implements SubscriberExportedToPeer {

	private final Logger logger = LoggerFactory.getLogger(SubscriberBarkerProxy.class);

	@Resource(name = "proxiedSubscriber")
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
		barker.addUnnoticedAttentionElement(notice);

		logger.debug("added {} to barker", notice);
	}


	@Override
	public void update(UserId subscriberId, UserId publisherId, DigitalCard digitalCard) {
		logger.debug("proxying call to update");

		proxiedSubscriber.update(subscriberId, publisherId, digitalCard);

		ListOfPublishers listOfPublishers = subDao.getListOfPublishers(subscriberId);
		Notice notice = new UpdateNotice(listOfPublishers.get(publisherId).getPublisherMetadata(), digitalCard);
		barker.addUnnoticedAttentionElement(notice);

		logger.debug("added {} to barker", notice);
	}


}