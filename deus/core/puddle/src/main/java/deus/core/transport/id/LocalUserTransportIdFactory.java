package deus.core.transport.id;

import deus.model.user.id.UserId;

/**
 * Creates a transport ID for a given user ID for local users.
 * @author Florian Rampp (Florian.Rampp@informatik.stud.uni-erlangen.de)
 *
 */
public interface LocalUserTransportIdFactory {

	public TransportId createTransportId(UserId userId);
	
}
