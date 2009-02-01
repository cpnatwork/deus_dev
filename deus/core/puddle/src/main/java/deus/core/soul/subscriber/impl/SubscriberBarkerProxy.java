package deus.core.soul.subscriber.impl;

import deus.core.soul.barker.Barker;
import deus.core.soul.subscriber.RemoteCalledSubscriber;
import deus.model.attention.notice.SubscriptionDeniedNotice;
import deus.model.attention.notice.SubscriptionGrantedNotice;
import deus.model.attention.notice.UpdateNotice;
import deus.model.dossier.generic.ForeignInformationFile;
import deus.model.sub.ListOfPublishers;
import deus.model.user.UserMetadata;
import deus.model.user.id.UserId;

public class SubscriberBarkerProxy implements RemoteCalledSubscriber {

	private final RemoteCalledSubscriber proxiedSubscriber;
	private final Barker barker;

	private final ListOfPublishers listOfPublishers;


	public SubscriberBarkerProxy(RemoteCalledSubscriber proxiedSubscriber, Barker barker,
			ListOfPublishers listOfPublishers) {
		this.proxiedSubscriber = proxiedSubscriber;
		this.barker = barker;
		this.listOfPublishers = listOfPublishers;
	}


	@Override
	public void acknowledgeSubscription(UserId publisherId) {
		proxiedSubscriber.acknowledgeSubscription(publisherId);

		// get publisher metadata out of LoP
		UserMetadata publisherMetadata = listOfPublishers.get(publisherId).getPublisherMetadata();
		barker.addUnnoticedAttentionElement(new SubscriptionGrantedNotice(publisherMetadata));
	}


	@Override
	public void denySubscription(UserId publisherId) {
		proxiedSubscriber.denySubscription(publisherId);

		// get publisher metadata out of LoP
		UserMetadata publisherMetadata = listOfPublishers.get(publisherId).getPublisherMetadata();
		barker.addUnnoticedAttentionElement(new SubscriptionDeniedNotice(publisherMetadata));
	}


	@Override
	public void update(UserMetadata publisherMetadata, ForeignInformationFile fif) {
		proxiedSubscriber.update(publisherMetadata, fif);
		barker.addUnnoticedAttentionElement(new UpdateNotice(publisherMetadata));
	}


}