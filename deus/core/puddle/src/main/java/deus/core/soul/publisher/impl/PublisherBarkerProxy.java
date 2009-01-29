package deus.core.soul.publisher.impl;

import deus.core.soul.barker.Barker;
import deus.core.soul.publisher.RemoteCalledPublisher;
import deus.model.attention.decision.BinaryDecisionToMake;
import deus.model.attention.decision.SubscriberRequest;
import deus.model.attention.notice.Notice;
import deus.model.attention.notice.SubscribedProfileDeletedNotice;
import deus.model.user.UserMetadata;

public class PublisherBarkerProxy implements RemoteCalledPublisher {

	private final RemoteCalledPublisher proxiedPublisher;
	private final Barker barker;


	public PublisherBarkerProxy(RemoteCalledPublisher proxiedPublisher, Barker barker) {
		this.proxiedPublisher = proxiedPublisher;
		this.barker = barker;
	}


	@Override
	public void addObserver(UserMetadata subscriberMetadata) {
		// PLACE SUBSCRIBER REQUEST
		BinaryDecisionToMake decision = new SubscriberRequest(subscriberMetadata);
		barker.addUnnoticedAttentionElement(decision);
	}


	@Override
	public void deleteObserver(UserMetadata subscriberMetadata) {
		// DELETE OBSERVER
		proxiedPublisher.deleteObserver(subscriberMetadata);

		// PLACE NOTICE
		Notice notice = new SubscribedProfileDeletedNotice(subscriberMetadata);
		barker.addUnnoticedAttentionElement(notice);
	}

}
