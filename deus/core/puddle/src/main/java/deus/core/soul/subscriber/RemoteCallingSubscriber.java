package deus.core.soul.subscriber;

import deus.model.user.UserMetadata;

/**
 * Groups methods of the interface <code>Subscriber</code> that trigger remote calls. These methods are implemented using
 * a <code>RemoteCommand</code>, that encapsulates the remote action. The calls are delegated to a
 * <code>PublisherStub</code>, that implements the remote call.
 * 
 * @author Florian Rampp (Florian.Rampp@informatik.stud.uni-erlangen.de)
 * 
 */
public interface RemoteCallingSubscriber {

	public void subscribe(UserMetadata publisherMetadata);

	void unsubscribe(UserMetadata publisherMetadata);
	
}
