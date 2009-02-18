package deus.core.access.transport.core.receiving.soulcallback;

import deus.model.dossier.DigitalCard;
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
public interface SubscriberExportedToPeer {

	public void update(UserId subscriberId, UserId publisherId, DigitalCard digitalCard);


	public void acknowledgeSubscription(UserId subscriberId, UserId publisherId);


	public void denySubscription(UserId subscriberId, UserId publisherId);

}
