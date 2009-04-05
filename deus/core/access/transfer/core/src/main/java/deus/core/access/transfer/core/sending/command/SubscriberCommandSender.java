package deus.core.access.transfer.core.sending.command;

import deus.model.user.UserMetadata;
import deus.model.user.id.UserId;

/**
 * Realizes use case "request subscription", "send cancel subscription use case".
 * 
 * @author Florian Rampp (Florian.Rampp@informatik.stud.uni-erlangen.de)
 *
 */
//FIXME: rename to subscriptionCommandSender in order to reflect subsystem
public interface SubscriberCommandSender {

	// USE CASE: informationConsumer initiated connection/termination
	
	
	// FIXME: rename to requestSubscription, since use case is called like this
	public void subscribe(UserId subscriberId, UserId publisherId, UserMetadata subscriberMetadata);


	// FIXME: rename to requestSubscription, since use case is called like this
	public void unsubscribe(UserId subscriberId, UserId publisherId);
	
	
	

	// USE CASE: publisher initiated connection (used, when in role informationConsumer)
	
	public void confirmSubscriptionOffer(UserId subscriberId, UserId publisherId);


	public void repelSubscriptionOffer(UserId subscriberId, UserId publisherId);
	
}
