package deus.core.publisher;

import deus.model.pub.ListOfSubscribers;
import deus.model.sub.PublisherMetadata;

// TODO: think about whether we need all the methods here
public interface Publisher extends RemoteCalledPublisher, RemoteCallingPublisher {


	/**
	 * Clears the observer list so that this object no longer has any observers.
	 */
	public abstract void deleteObservers();


	/**
	 * Returns the number of observers of this <tt>Observable</tt> object.
	 * 
	 * @return the number of observers of this object.
	 */
	public abstract int countObservers();


	public ListOfSubscribers getListOfSubscribers();


	public abstract PublisherMetadata getPublisherMetadata();

}