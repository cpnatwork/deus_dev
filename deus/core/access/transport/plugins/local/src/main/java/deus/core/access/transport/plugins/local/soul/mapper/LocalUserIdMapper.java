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
		// FIXME: this is actually done by discovery, right? so it should go to the transport-core-package!
		
		return new LocalTransportId(userId.getUsername());
	}

}
