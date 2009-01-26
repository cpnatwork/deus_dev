package deus.core.publisher.stub;

import deus.model.pub.SubscriberMetadata;
import deus.model.sub.PublisherMetadata;

/**
 * Classes implementing this interface <b>reside on the subscriber side<b> and <b>talk to the remote publisher</b>.
 * 
 * @author Florian Rampp (Florian.Rampp@informatik.stud.uni-erlangen.de)
 * 
 */
public interface PublisherStub {


	/**
	 * Adds an observer to the set of observers for this object, provided that it is not the same as some observer
	 * already in the set. The order in which notifications will be delivered to multiple observers is not specified.
	 * See the class comment.
	 * 
	 * @param subscriberMetadata an observer to be added.
	 */
	public abstract void addObserver(SubscriberMetadata subscriberMetadata);


	/**
	 * Deletes an observer from the set of observers of this object. Passing <CODE>null</CODE> to this method will have
	 * no effect.
	 * 
	 * @param subscriberMetadata the observer to be deleted.
	 */
	public abstract void deleteObserver(SubscriberMetadata subscriberMetadata);


	/**
	 * Returns the metadata of the publisher, to which this stub connects to communicate.
	 * 
	 * @return metadata of the publisher, to which is talked
	 */
	public PublisherMetadata getPublisherMetadata();

}