package deus.core.soul.publisher.impl;

import deus.core.soul.barker.Barker;
import deus.core.soul.publisher.RemoteCalledPublisher;
import deus.model.attention.decision.BinaryDecisionToMake;
import deus.model.attention.decision.SubscriberRequest;
import deus.model.attention.notice.Notice;
import deus.model.attention.notice.SubscribedProfileDeletedNotice;
import deus.model.pub.ListOfSubscribers;
import deus.model.user.UserMetadata;
import deus.model.user.id.UserId;

public class PublisherBarkerProxy implements RemoteCalledPublisher {

	private final RemoteCalledPublisher proxiedPublisher;
	private final Barker barker;
	private final ListOfSubscribers listOfSubscribers;


	public PublisherBarkerProxy(RemoteCalledPublisher proxiedPublisher, Barker barker, ListOfSubscribers listOfSubscribers) {
		this.proxiedPublisher = proxiedPublisher;
		this.barker = barker;
		this.listOfSubscribers = listOfSubscribers;
	}


	@Override
	public void addObserver(UserId subscriberId, UserMetadata subscriberMetadata) {
		// PLACE SUBSCRIBER REQUEST
		BinaryDecisionToMake decision = new SubscriberRequest(subscriberMetadata);
		barker.addUnnoticedAttentionElement(decision);
	}


	@Override
	public void deleteObserver(UserId subscriberId) {
		// DELETE OBSERVER
		proxiedPublisher.deleteObserver(subscriberId);

		// PLACE NOTICE
		UserMetadata subscriberMetadata = listOfSubscribers.get(subscriberId).getSubscriberMetadata();
		Notice notice = new SubscribedProfileDeletedNotice(subscriberMetadata);
		barker.addUnnoticedAttentionElement(notice);
	}

}
