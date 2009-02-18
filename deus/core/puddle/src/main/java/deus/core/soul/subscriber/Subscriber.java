package deus.core.soul.subscriber;


/**
 * Central facade of the subscriber subsystem.
 * 
 * Methods from the interface <code>SubscriberExportedToPeer</code> are called remotely on this subscriber. The other
 * methods of this interface are methods to retrieve information about the subscriber subsystem locally.
 * 
 * @see SubscriberExportedToPeer
 * 
 * @author Florian Rampp (Florian.Rampp@informatik.stud.uni-erlangen.de)
 * 
 */
public interface Subscriber extends SubscriberExportedToPeer, SubscriberExportedToClient {


}