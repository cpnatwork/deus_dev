package deus.core.access.transport.plugins.local.soul.mapper;

import deus.core.access.transport.core.soul.mapper.UserIdMapper;
import deus.core.access.transport.core.soul.protocol.TransportId;
import deus.core.access.transport.plugins.local.soul.protocol.LocalTransportId;
import deus.model.user.id.UserId;

/**
 * Returns local transport IDs, where the username is just taken from the UserId.
 * 
 * @author Florian Rampp (Florian.Rampp@informatik.stud.uni-erlangen.de)
 *
 */
public class LocalUserIdMapper implements UserIdMapper {

	@Override
	public TransportId resolveLocal(UserId userId) {
		return new LocalTransportId(userId.getUsername());
	}


	@Override
	public TransportId resolveRemote(UserId userId) {
		// FIXME: Implement this by using discovery
		// it should stay here, but maybe use discovery helper classes from transport-core
		
		return new LocalTransportId(userId.getUsername());
	}

}
