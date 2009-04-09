package deus.core.soul.subscription;

import deus.model.common.user.UserMetadata;
import deus.model.common.user.frids.PublisherId;
import deus.model.common.user.frids.SubscriberId;
import deus.model.subscription.ListOfPublishers;

/**
 * Groups methods of the interface <code>Subscriber</code> that trigger remote calls. These methods are implemented
 * using a <code>RemoteCommand</code>, that encapsulates the remote action. The calls are delegated to a
 * <code>PublisherStub</code>, that implements the remote call.
 * 
 * @author Florian Rampp (Florian.Rampp@informatik.stud.uni-erlangen.de)
 * 
 */
public interface SubscriberExportedToClient {

	// USE CASE: subscriber initiated connection/termination
	
	public void subscribeToPublisher(SubscriberId subscriberId, PublisherId publisherId, UserMetadata publisherMetadata);

	// FIXME: rename to unsubscribeFromPublisher
	public void unsubscribe(SubscriberId subscriberId, PublisherId publisherId);

	
	// DATA MODEL RETRIEVING
	
	public ListOfPublishers getListOfPublishers(SubscriberId subscriberId);

}
