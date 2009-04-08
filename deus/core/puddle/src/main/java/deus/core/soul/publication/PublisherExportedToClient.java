package deus.core.soul.publication;

import deus.model.common.dossier.DigitalCard;
import deus.model.common.user.UserMetadata;
import deus.model.common.user.id.UserId;
import deus.model.publication.ListOfSubscribers;

/**
 * Groups methods of the interface <code>Publisher</code> that trigger remote calls. These methods are implemented using
 * a <code>RemoteCommand</code>, that encapsulates the remote action. The calls are delegated to a
 * <code>SubscriberStub</code>, that implements the remote call.
 * 
 * @author Florian Rampp (Florian.Rampp@informatik.stud.uni-erlangen.de)
 * 
 */
public interface PublisherExportedToClient {

	// USE CASE: update
	
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
	// FIXME: replace DC parameter by Patch parameter
	public abstract void notifySubscribers(UserId publisherId, DigitalCard digitalCard);

	// FIXME: replace DC parameter by Patch parameter
	public abstract void notifySubscriber(UserId publisherId, UserId subscriberId, DigitalCard digitalCard);
	
	
	
	// USE CASE: publisher initiated connection/termination
	
	public abstract void inviteSubscriber(UserId publisherId, UserId subscriberId, UserMetadata subscriberMetadata);
	
	public abstract void cancelSubscription(UserId publisherId, UserId subscriberId);
	

	
	// DATA MODEL RETRIEVING
	
	public abstract ListOfSubscribers getListOfSubscribers(UserId publisherId);

}
