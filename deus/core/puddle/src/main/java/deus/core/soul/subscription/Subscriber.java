package deus.core.soul.subscription;

import deus.core.access.transport.core.receiving.soulcallback.subscription.SubscriberExportedToPeer;


/**
 * Central facade of the informationConsumer subsystem.
 * 
 * Methods from the interface <code>SubscriberExportedToPeer</code> are called remotely on this informationConsumer. The other
 * methods of this interface are methods to retrieve information about the informationConsumer subsystem locally.
 * 
 * @see SubscriberExportedToPeer
 * 
 * @author Florian Rampp (Florian.Rampp@informatik.stud.uni-erlangen.de)
 * 
 */
public interface Subscriber extends SubscriberExportedToPeer, SubscriberExportedToClient {


}