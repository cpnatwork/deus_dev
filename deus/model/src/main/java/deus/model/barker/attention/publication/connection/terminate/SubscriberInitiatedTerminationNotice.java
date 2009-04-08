package deus.model.barker.attention.publication.connection.terminate;

import deus.model.common.user.UserMetadata;

/**
 * Displayed to publisher, when a informationConsumer unsubscribes from his PIF.
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
		return "Your informationConsumer "+getSubscriberMetadata().getFullName()+" shits on you (has deleted your file from ITS folder)";

	}

}
