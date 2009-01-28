package deus.model.attention.notice;

import deus.model.user.UserMetadata;

public class SubscriptionCanceledNotice extends PublisherSentNotice {

	public SubscriptionCanceledNotice(UserMetadata publisherMetadata) {
		super(publisherMetadata);
	}

	@Override
	public String getCatchphare() {
		//I18N
		//GENDER
		return "Your contact "+getPublisherMetadata().getFullName()+" shits on you (and has canceled your subscription to ITS file)";
	}


}
