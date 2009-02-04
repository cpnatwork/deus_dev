package deus.core.soul.subscriber;

import deus.model.dossier.generic.ForeignInformationFile;
import deus.model.user.id.UserId;

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
//FIXME: think about how this relates to SubscriberCommandReceiver
public interface RemoteCalledSubscriber {

	public void update(UserId publisherId, ForeignInformationFile change);


	public void acknowledgeSubscription(UserId publisherId);


	public void denySubscription(UserId publisherId);

}
