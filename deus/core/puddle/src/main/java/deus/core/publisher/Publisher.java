package deus.core.publisher;

import deus.model.pub.SubscriberMetadata;
import deus.model.sub.PublisherMetadata;
import deus.model.user.id.UserId;


public interface Publisher<Id extends UserId> {


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
	
		
	/**
	 * If this object has changed, as indicated by the
	 * <code>hasChanged</code> method, then notify all of its observers
	 * and then call the <code>clearChanged</code> method to
	 * indicate that this object has no longer changed.
	 * <p>
	 * Each observer has its <code>update</code> method called with two
	 * arguments: this observable object and <code>null</code>. In other
	 * words, this method is equivalent to:
	 * <blockquote><tt>
	 * notifyObservers(null)</tt></blockquote>
	 *
	 * @see     java.util.Observable#clearChanged()
	 * @see     java.util.Observable#hasChanged()
	 * @see     java.util.Observer#update(java.util.Observable, java.lang.Object)
	 */
	public abstract void notifyObservers();


	/**
	 * If this object has changed, as indicated by the
	 * <code>hasChanged</code> method, then notify all of its observers
	 * and then call the <code>clearChanged</code> method to indicate
	 * that this object has no longer changed.
	 * <p>
	 * Each observer has its <code>update</code> method called with two
	 * arguments: this observable object and the <code>arg</code> argument.
	 *
	 * @param   change   any object.
	 * @see     java.util.Observable#clearChanged()
	 * @see     java.util.Observable#hasChanged()
	 * @see     java.util.Observer#update(java.util.Observable, java.lang.Object)
	 */
	public abstract void notifyObservers(Object change);


	/**
	 * Clears the observer list so that this object no longer has any observers.
	 */
	public abstract void deleteObservers();


	/**
	 * Returns the number of observers of this <tt>Observable</tt> object.
	 *
	 * @return  the number of observers of this object.
	 */
	public abstract int countObservers();


	public abstract PublisherMetadata<Id> getPublisherMetadata();

}