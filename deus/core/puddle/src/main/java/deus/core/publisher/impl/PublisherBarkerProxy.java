package deus.core.publisher.impl;

import deus.core.barker.Barker;
import deus.core.publisher.RemoteCalledPublisher;
import deus.model.attention.BinaryDecisionToMake;
import deus.model.attention.Notice;
import deus.model.attention.SubscriberRequest;
import deus.model.attention.SubscriptionCanceledNotice;
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
		BinaryDecisionToMake decision = new SubscriberRequest(subscriberMetadata);
		barker.addAttentionElement(decision);
	}


	@Override
	public void deleteObserver(SubscriberMetadata subscriberMetadata) {
		proxiedPublisher.deleteObserver(subscriberMetadata);

		Notice notice = new SubscriptionCanceledNotice(subscriberMetadata);
		barker.addAttentionElement(notice);
	}

}
