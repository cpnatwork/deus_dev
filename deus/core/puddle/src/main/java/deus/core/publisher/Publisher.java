package deus.core.publisher;

import deus.model.pub.ListOfSubscribers;
import deus.model.user.UserMetadata;

// TODO: think about whether we need all the methods here

/**
 * Central facade of the publisher subsystem.
 * 
 * Methods from <code>RemoteCalledPublisher</code> are called remotely on this publisher. Methods from
 * <code>RemoteCallingPublisher</code> are called locally and result in a remote call on a subscriber stub. The other
 * methods specified in this interface are methods, that currently aren't called remotely and are deprecated, or return
 * information about the publisher subsystem for local usage.
 *
 * @see RemoteCalledPublisher
 * @see RemoteCallingPublisher
 * 
 * @author Florian Rampp (Florian.Rampp@informatik.stud.uni-erlangen.de)
 */
public interface Publisher extends RemoteCalledPublisher, RemoteCallingPublisher {


	/**
	 * Clears the observer list so that this object no longer has any observers.
	 */
	@Deprecated
	public abstract void deleteObservers();


	/**
	 * Returns the number of observers of this <tt>Observable</tt> object.
	 * 
	 * @return the number of observers of this object.
	 */
	@Deprecated
	public abstract int countObservers();


	public ListOfSubscribers getListOfSubscribers();


	public abstract UserMetadata getPublisherMetadata();

}