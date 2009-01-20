package deus.core.publisher.impl;

import deus.core.barker.Barker;
import deus.core.publisher.RemoteCalledPublisher;
import deus.model.attention.DecisionToMake;
import deus.model.attention.Notice;
import deus.model.attention.SubscriberRequest;
import deus.model.attention.SubscriptionCanceledNotice;
import deus.model.pub.SubscriberMetadata;
import deus.model.user.id.UserId;

public class PublisherBarkerProxy<Id extends UserId> implements RemoteCalledPublisher<Id> {

	private final RemoteCalledPublisher<Id> proxiedPublisher;
	private final Barker barker;
	
	public PublisherBarkerProxy(RemoteCalledPublisher<Id> proxiedPublisher, Barker barker) {
		this.proxiedPublisher = proxiedPublisher;
		this.barker = barker;
	}

	@Override
	public void addObserver(SubscriberMetadata<Id> subscriberMetadata) {
		DecisionToMake decision = new SubscriberRequest<Id>(subscriberMetadata);
		barker.addAttentionElement(decision);
	}

	@Override
	public void deleteObserver(SubscriberMetadata<Id> subscriberMetadata) {
		proxiedPublisher.deleteObserver(subscriberMetadata);
		
		Notice notice = new SubscriptionCanceledNotice<Id>(subscriberMetadata);
		barker.addAttentionElement(notice);
	}

}
