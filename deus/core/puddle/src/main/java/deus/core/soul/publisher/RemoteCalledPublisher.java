package deus.core.soul.publisher;

import deus.model.user.UserMetadata;

/**
 * Groups methods of the interface <code>Publisher</code>, that are called remotely. These methods are e.g. called from
 * an instance of the class <code>XmppPublisherSkeleton</code>, which is the part of the stub-skeleton pair, that resides on the
 * publisher side.
 * 
 * @see Publisher
 * 
 * @author Florian Rampp (Florian.Rampp@informatik.stud.uni-erlangen.de)
 * 
 */
public interface RemoteCalledPublisher {

	/**
	 * Adds an observer to the set of observers for this object, provided that it is not the same as some observer
	 * already in the set. The order in which notifications will be delivered to multiple observers is not specified.
	 * See the class comment.
	 * 
	 * @param subscriberMetadata an observer to be added.
	 */
	public abstract void addObserver(UserMetadata subscriberMetadata);


	/**
	 * Deletes an observer from the set of observers of this object. Passing <CODE>null</CODE> to this method will have
	 * no effect.
	 * 
	 * @param subscriberMetadata the observer to be deleted.
	 */
	public abstract void deleteObserver(UserMetadata subscriberMetadata);

}
