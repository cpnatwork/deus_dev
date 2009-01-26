package deus.core.subscriber.impl;

import deus.core.barker.Barker;
import deus.core.subscriber.RemoteCalledSubscriber;
import deus.model.attention.notice.SubscriptionDeniedNotice;
import deus.model.attention.notice.SubscriptionGrantedNotice;
import deus.model.attention.notice.UpdateNotice;
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
		barker.addUnnoticedAttentionElement(new SubscriptionGrantedNotice(publisherMetadata));
	}


	@Override
	public void denySubscription(PublisherMetadata publisherMetadata) {
		proxiedSubscriber.denySubscription(publisherMetadata);
		barker.addUnnoticedAttentionElement(new SubscriptionDeniedNotice(publisherMetadata));
	}
	
	
	@Override
	public void update(PublisherMetadata publisherMetadata, ForeignInformationFile fif) {
		proxiedSubscriber.update(publisherMetadata, fif);
		barker.addUnnoticedAttentionElement(new UpdateNotice(publisherMetadata));
	}


}