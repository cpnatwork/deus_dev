package deus.model.attention.notice;

import deus.model.user.UserMetadata;

public class SubscribedProfileDeletedNotice extends SubscriberSentNotice {

	public SubscribedProfileDeletedNotice(UserMetadata subscriberMetadata) {
		super(subscriberMetadata);
	}

	@Override
	public String getCatchphare() {
		//I18N
		//GENDER
		return "Your subscriber "+getSubscriberMetadata().getFullName()+" shits on you (has deleted your file from ITS folder)";
	}
}
