package deus.core.access.transfer.core.sending.command;

import deus.model.common.user.UserMetadata;
import deus.model.common.user.frids.PublisherId;
import deus.model.common.user.frids.SubscriberId;

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
	public void subscribe(SubscriberId subscriberId, PublisherId publisherId, UserMetadata subscriberMetadata);


	// FIXME: rename to requestSubscription, since use case is called like this
	public void unsubscribe(SubscriberId subscriberId, PublisherId publisherId);
	
	
	

	// USE CASE: publisher initiated connection (used, when in role informationConsumer)
	
	public void confirmSubscriptionOffer(SubscriberId subscriberId, PublisherId publisherId);


	public void repelSubscriptionOffer(SubscriberId subscriberId, PublisherId publisherId);
	
}
