package deus.core.access.transport.core.sending.command;

import deus.model.user.UserMetadata;
import deus.model.user.id.UserId;

/**
 * Realizes use case "request subscription", "send cancel subscription use case".
 * 
 * @author Florian Rampp (Florian.Rampp@informatik.stud.uni-erlangen.de)
 *
 */
public interface SubscriberCommandSender {

	// USE CASE: subscriber initiated connection/termination
	
	
	// FIXME: rename to requestSubscription, since use case is called like this
	public void subscribe(UserId subscriberId, UserId publisherId, UserMetadata subscriberMetadata);


	// FIXME: rename to requestSubscription, since use case is called like this
	public void unsubscribe(UserId subscriberId, UserId publisherId);
	
}
