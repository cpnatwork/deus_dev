package deus.core.access.transfer.core.receiving.soulcallback.publication;


import deus.model.common.user.UserMetadata;
import deus.model.common.user.id.UserId;

/**
 * Groups methods of the interface <code>Publisher</code>, that are called remotely. These methods are e.g. called from
 * an instance of the class <code>XmppPublisherSkeleton</code>, which is the part of the stub-skeleton pair, that
 * resides on the publisher side.
 * 
 * @see Publisher
 * 
 * @author Florian Rampp (Florian.Rampp@informatik.stud.uni-erlangen.de)
 * 
 */
public interface PublisherExportedToPeers {

	// USE CASE: subscriber initiated connection
	
	/**
	 * Adds an observer to the set of observers for this object, provided that it is not the same as some observer
	 * already in the set. The order in which notifications will be delivered to multiple observers is not specified.
	 * See the class comment.
	 * 
	 * @param subscriberMetadata an observer to be added.
	 */
	public abstract void addSubscriber(UserId publisherId, UserId subscriberId, UserMetadata subscriberMetadata);


	// USE CASE: subscriber initiated termination
	
	/**
	 * Deletes an observer from the set of observers of this object. Passing <CODE>null</CODE> to this method will have
	 * no effect.
	 * 
	 * @param subscriberMetadata the observer to be deleted.
	 */
	public abstract void deleteSubscriber(UserId publisherId, UserId subscriberId);

	
	
	
	// USE CASE: publisher initiated connection
	
	// FIXME: rename this to subscriptionOfferConfirmed
	public abstract void subscriptionConfirmed(UserId publisherId, UserId subscriberId);
	
	// FIXME: rename this to subscriptionOfferRepelled
	public abstract void subscriptionAbstained(UserId publisherId, UserId subscriberId);
}
