package deus.core.publisher;

import deus.model.dossier.proj.party.PartyId;
import deus.model.pub.SubscriberMetadata;
import deus.model.sub.PublisherMetadata;


public interface PublisherStub<Id extends PartyId> {


	/**
	 * Adds an observer to the set of observers for this object, provided
	 * that it is not the same as some observer already in the set.
	 * The order in which notifications will be delivered to multiple
	 * observers is not specified. See the class comment.
	 *
	 * @param   o   an observer to be added.
	 * @throws NullPointerException   if the parameter o is null.
	 */
	public abstract void addObserver(SubscriberMetadata<Id> o);


	/**
	 * Deletes an observer from the set of observers of this object.
	 * Passing <CODE>null</CODE> to this method will have no effect.
	 * @param   o   the observer to be deleted.
	 */
	public abstract void deleteObserver(SubscriberMetadata<Id> o);
	
	
	public PublisherMetadata<Id> getPublisherMetadata();

}