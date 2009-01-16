package deus.core.publisher;

import deus.model.pub.SubscriberMetadata;
import deus.model.user.id.UserId;

public interface RemoteCalledPublisher<Id extends UserId> {

	/**
	 * Adds an observer to the set of observers for this object, provided
	 * that it is not the same as some observer already in the set.
	 * The order in which notifications will be delivered to multiple
	 * observers is not specified. See the class comment.
	 *
	 * @param   subscriberMetadata   an observer to be added.
	 */
	public abstract void addObserver(SubscriberMetadata<Id> subscriberMetadata);


	/**
	 * Deletes an observer from the set of observers of this object.
	 * Passing <CODE>null</CODE> to this method will have no effect.
	 * @param   subscriberMetadata   the observer to be deleted.
	 */
	public abstract void deleteObserver(SubscriberMetadata<Id> subscriberMetadata);
	
}
