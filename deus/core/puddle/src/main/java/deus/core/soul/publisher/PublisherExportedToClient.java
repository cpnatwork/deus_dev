package deus.core.soul.publisher;

import deus.model.ifcontent.DigitalCard;
import deus.model.pub.ListOfSubscribers;
import deus.model.user.id.UserId;

/**
 * Groups methods of the interface <code>Publisher</code> that trigger remote calls. These methods are implemented using
 * a <code>RemoteCommand</code>, that encapsulates the remote action. The calls are delegated to a
 * <code>SubscriberStub</code>, that implements the remote call.
 * 
 * @author Florian Rampp (Florian.Rampp@informatik.stud.uni-erlangen.de)
 * 
 */
public interface PublisherExportedToClient {

	/**
	 * If this object has changed, as indicated by the <code>hasChanged</code> method, then notify all of its observers
	 * and then call the <code>clearChanged</code> method to indicate that this object has no longer changed.
	 * <p>
	 * Each observer has its <code>update</code> method called with two arguments: this observable object and the
	 * <code>arg</code> argument.
	 * 
	 * @param change any object.
	 * @see java.util.Observable#clearChanged()
	 * @see java.util.Observable#hasChanged()
	 * @see java.util.Observer#update(java.util.Observable, java.lang.ForeignInformationFile)
	 */
	public abstract void notifySubscribers(UserId publisherId, DigitalCard digitalCard);


	public ListOfSubscribers getListOfSubscribers(UserId publisherId);


	/**
	 * Clears the observer list so that this object no longer has any observers.
	 */
	@Deprecated
	public abstract void deleteSubscribers(UserId publisherId);


	/**
	 * Returns the number of observers of this <tt>Observable</tt> object.
	 * 
	 * @return the number of observers of this object.
	 */
	@Deprecated
	public abstract int countSubscribers(UserId publisherId);
}