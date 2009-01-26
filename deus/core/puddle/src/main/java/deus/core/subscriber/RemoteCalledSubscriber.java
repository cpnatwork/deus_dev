package deus.core.subscriber;

import deus.model.dossier.generic.ForeignInformationFile;
import deus.model.sub.PublisherMetadata;

/**
 * Groups methods of the interface <code>Subscriber</code>, that are called remotely on the subscriber subsystem. These
 * methods are e.g. called from an instance of the class <code>XmppSubscriberSkeleton</code>, which is the part of the
 * stub-skeleton pair, that resides on the subscriber side.
 * 
 * 
 * @see Subscriber
 * 
 * @author Florian Rampp (Florian.Rampp@informatik.stud.uni-erlangen.de)
 * 
 */
public interface RemoteCalledSubscriber {

	public void update(PublisherMetadata publisherMetadata, ForeignInformationFile fif);


	public void acknowledgeSubscription(PublisherMetadata publisherMetadata);


	public void denySubscription(PublisherMetadata publisherMetadata);

}
