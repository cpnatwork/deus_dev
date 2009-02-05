package deus.core.access.transport.core.soul.protocol;

import deus.model.user.id.UserId;

/**
 * Creates a transport ID for a given user ID for local users.
 * 
 * @author Florian Rampp (Florian.Rampp@informatik.stud.uni-erlangen.de)
 * 
 */
public interface TransportIdUserIdMapper {

	public TransportId map(UserId userId);


	public UserId map(TransportId transportId);

}
