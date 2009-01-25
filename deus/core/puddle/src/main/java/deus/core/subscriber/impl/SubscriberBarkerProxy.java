package deus.core.subscriber.impl;

import deus.core.barker.Barker;
import deus.core.subscriber.RemoteCalledSubscriber;
import deus.model.attention.SubscriptionGrantedNotice;
import deus.model.attention.UpdateNotice;
import deus.model.dossier.generic.ForeignInformationFile;
import deus.model.sub.PublisherMetadata;

public class SubscriberBarkerProxy implements RemoteCalledSubscriber {

	private final RemoteCalledSubscriber proxiedSubscriber;
	private final Barker barker;


	public SubscriberBarkerProxy(RemoteCalledSubscriber proxiedSubscriber, Barker barker) {
		this.proxiedSubscriber = proxiedSubscriber;
		this.barker = barker;
	}
	
	@Override
	public void acknowledgeSubscription(PublisherMetadata publisherMetadata) {
		proxiedSubscriber.acknowledgeSubscription(publisherMetadata);
		barker.addAttentionElement(new SubscriptionGrantedNotice(publisherMetadata));
	}


	@Override
	public void update(PublisherMetadata publisherMetadata, ForeignInformationFile fif) {
		proxiedSubscriber.update(publisherMetadata, fif);
		barker.addAttentionElement(new UpdateNotice(publisherMetadata));
	}

}
