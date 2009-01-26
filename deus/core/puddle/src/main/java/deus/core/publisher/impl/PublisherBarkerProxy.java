package deus.core.publisher.impl;

import deus.core.barker.Barker;
import deus.core.publisher.RemoteCalledPublisher;
import deus.model.attention.decision.BinaryDecisionToMake;
import deus.model.attention.decision.SubscriberRequest;
import deus.model.attention.notice.Notice;
import deus.model.attention.notice.SubscriptionCanceledNotice;
import deus.model.pub.SubscriberMetadata;

public class PublisherBarkerProxy implements RemoteCalledPublisher {

	private final RemoteCalledPublisher proxiedPublisher;
	private final Barker barker;


	public PublisherBarkerProxy(RemoteCalledPublisher proxiedPublisher, Barker barker) {
		this.proxiedPublisher = proxiedPublisher;
		this.barker = barker;
	}


	@Override
	public void addObserver(SubscriberMetadata subscriberMetadata) {
		// PLACE SUBSCRIBER REQUEST
		BinaryDecisionToMake decision = new SubscriberRequest(subscriberMetadata);
		barker.addUnnoticedAttentionElement(decision);
	}


	@Override
	public void deleteObserver(SubscriberMetadata subscriberMetadata) {
		// DELETE OBSERVER
		proxiedPublisher.deleteObserver(subscriberMetadata);

		// PLACE NOTICE
		Notice notice = new SubscriptionCanceledNotice(subscriberMetadata);
		barker.addUnnoticedAttentionElement(notice);
	}

}
