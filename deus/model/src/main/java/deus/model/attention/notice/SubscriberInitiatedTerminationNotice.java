package deus.model.attention.notice;

import deus.model.user.UserMetadata;

/**
 * Displayed to publisher, when a subscriber unsubscribes from his PIF.
 * 
 * @author Florian Rampp (Florian.Rampp@informatik.stud.uni-erlangen.de)
 * 
 */
public class SubscriberInitiatedTerminationNotice extends TerminationNotice {

	private final UserMetadata subscriberMetadata;


	public SubscriberInitiatedTerminationNotice(UserMetadata subscriberMetadata) {
		this.subscriberMetadata = subscriberMetadata;
	}


	public UserMetadata getSubscriberMetadata() {
		return subscriberMetadata;
	}


	@Override
	public String getCatchphare() {
		return "Your subscriber "+getSubscriberMetadata().getFullName()+" shits on you (has deleted your file from ITS folder)";

	}

}
