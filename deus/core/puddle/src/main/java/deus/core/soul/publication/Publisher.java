package deus.core.soul.publication;

import deus.core.access.transport.core.receiving.soulcallback.PublisherExportedToPeer;


/**
 * Central facade of the publisher subsystem.
 * 
 * Methods from <code>PublisherExportedToPeer</code> are called remotely on this publisher. Methods from
 * <code>PublisherExportedToClient</code> are called locally and result in a remote call on a subscriber stub. The other
 * methods specified in this interface are methods, that currently aren't called remotely and are deprecated, or return
 * information about the publisher subsystem for local usage.
 *
 * @see PublisherExportedToPeer
 * @see PublisherExportedToClient
 * 
 * @author Florian Rampp (Florian.Rampp@informatik.stud.uni-erlangen.de)
 */
public interface Publisher extends PublisherExportedToPeer, PublisherExportedToClient {

}