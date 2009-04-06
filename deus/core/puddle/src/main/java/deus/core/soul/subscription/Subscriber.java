package deus.core.soul.subscription;

import deus.core.access.transfer.core.receiving.soulcallback.subscription.SubscriberExportedToPeers;


/**
 * Central facade of the informationConsumer subsystem.
 * 
 * Methods from the interface <code>SubscriberExportedToPeers</code> are called remotely on this informationConsumer. The other
 * methods of this interface are methods to retrieve information about the informationConsumer subsystem locally.
 * 
 * @see SubscriberExportedToPeers
 * 
 * @author Florian Rampp (Florian.Rampp@informatik.stud.uni-erlangen.de)
 * 
 */
public interface Subscriber extends SubscriberExportedToPeers, SubscriberExportedToClient {


}