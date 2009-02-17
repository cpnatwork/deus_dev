package deus.core.soul.subscriber.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import deus.core.soul.barker.Barker;
import deus.core.soul.subscriber.RemoteCalledSubscriber;
import deus.model.attention.notice.Notice;
import deus.model.attention.notice.SubscriptionDeniedNotice;
import deus.model.attention.notice.SubscriptionGrantedNotice;
import deus.model.attention.notice.UpdateNotice;
import deus.model.dossier.DigitalCard;
import deus.model.dossier.generic.ForeignInformationFile;
import deus.model.sub.ListOfPublishers;
import deus.model.user.UserMetadata;
import deus.model.user.id.UserId;

public class SubscriberBarkerProxy implements RemoteCalledSubscriber {

	private final Logger logger = LoggerFactory.getLogger(SubscriberBarkerProxy.class);
	
	private final RemoteCalledSubscriber proxiedSubscriber;
	private final Barker barker;

	private final ListOfPublishers listOfPublishers;


	public SubscriberBarkerProxy(RemoteCalledSubscriber proxiedSubscriber, Barker barkerImpl,
			ListOfPublishers listOfPublishers) {
		this.proxiedSubscriber = proxiedSubscriber;
		this.barker = barkerImpl;
		this.listOfPublishers = listOfPublishers;
	}


	@Override
	public void acknowledgeSubscription(UserId publisherId) {
		logger.debug("proxying call to acknowledgeSubscription");
		
		proxiedSubscriber.acknowledgeSubscription(publisherId);

		// get publisher metadata out of LoP
		UserMetadata publisherMetadata = listOfPublishers.get(publisherId).getPublisherMetadata();
		Notice notice = new SubscriptionGrantedNotice(publisherMetadata);
		barker.addUnnoticedAttentionElement(notice);
		
		logger.debug("added {} to barker", notice);
	}


	@Override
	public void denySubscription(UserId publisherId) {
		logger.debug("proxying call to denySubscription");
		
		proxiedSubscriber.denySubscription(publisherId);

		// get publisher metadata out of LoP
		UserMetadata publisherMetadata = listOfPublishers.get(publisherId).getPublisherMetadata();
		Notice notice = new SubscriptionDeniedNotice(publisherMetadata);
		barker.addUnnoticedAttentionElement(notice);
		
		logger.debug("added {} to barker", notice);
	}


	@Override
	public void update(UserId publisherId, DigitalCard digitalCard) {
		logger.debug("proxying call to update");
		
		proxiedSubscriber.update(publisherId, digitalCard);
		
		Notice notice = new UpdateNotice(listOfPublishers.get(publisherId).getPublisherMetadata(), digitalCard);
		barker.addUnnoticedAttentionElement(notice);
		
		logger.debug("added {} to barker", notice);
	}


}