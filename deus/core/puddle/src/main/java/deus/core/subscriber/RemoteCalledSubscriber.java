package deus.core.subscriber;

import deus.model.dossier.generic.ForeignInformationFile;
import deus.model.user.UserMetadata;

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

	public void update(UserMetadata publisherMetadata, ForeignInformationFile fif);


	public void acknowledgeSubscription(UserMetadata publisherMetadata);


	public void denySubscription(UserMetadata publisherMetadata);

}
