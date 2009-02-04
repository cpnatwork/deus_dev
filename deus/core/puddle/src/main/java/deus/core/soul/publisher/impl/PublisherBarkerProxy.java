package deus.core.soul.publisher.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import deus.core.soul.barker.Barker;
import deus.core.soul.publisher.RemoteCalledPublisher;
import deus.core.soul.subscriber.impl.SubscriberBarkerProxy;
import deus.model.attention.decision.BinaryDecisionToMake;
import deus.model.attention.decision.SubscriberRequest;
import deus.model.attention.notice.Notice;
import deus.model.attention.notice.SubscribedProfileDeletedNotice;
import deus.model.pub.ListOfSubscribers;
import deus.model.user.UserMetadata;
import deus.model.user.id.UserId;

public class PublisherBarkerProxy implements RemoteCalledPublisher {

	private final Logger logger = LoggerFactory.getLogger(PublisherBarkerProxy.class);
	
	private final RemoteCalledPublisher proxiedPublisher;
	private final Barker barkerImpl;
	private final ListOfSubscribers listOfSubscribers;


	public PublisherBarkerProxy(RemoteCalledPublisher proxiedPublisher, Barker barkerImpl, ListOfSubscribers listOfSubscribers) {
		this.proxiedPublisher = proxiedPublisher;
		this.barkerImpl = barkerImpl;
		this.listOfSubscribers = listOfSubscribers;
	}


	@Override
	public void addObserver(UserId subscriberId, UserMetadata subscriberMetadata) {
		logger.trace("proxying call to addObserver");
		
		// PLACE SUBSCRIBER REQUEST
		BinaryDecisionToMake decision = new SubscriberRequest(subscriberId, subscriberMetadata);
		barkerImpl.addUnnoticedAttentionElement(decision);
		
		logger.trace("added {} to barker", decision);
	}


	@Override
	public void deleteObserver(UserId subscriberId) {
		logger.trace("proxying call to deleteObserver");
		
		// DELETE OBSERVER
		proxiedPublisher.deleteObserver(subscriberId);

		// PLACE NOTICE
		UserMetadata subscriberMetadata = listOfSubscribers.get(subscriberId).getSubscriberMetadata();
		Notice notice = new SubscribedProfileDeletedNotice(subscriberMetadata);
		barkerImpl.addUnnoticedAttentionElement(notice);
		
		logger.trace("added {} to barker", notice);
	}

}
