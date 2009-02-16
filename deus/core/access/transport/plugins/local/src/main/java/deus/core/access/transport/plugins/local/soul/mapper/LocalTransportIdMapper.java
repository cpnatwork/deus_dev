package deus.core.access.transport.plugins.local.soul.mapper;

import deus.core.access.transport.core.soul.mapper.TransportIdMapper;
import deus.core.access.transport.core.soul.protocol.TransportId;
import deus.model.user.id.UserId;


public class LocalTransportIdMapper implements TransportIdMapper {

	@Override
	public UserId resolveLocal(TransportId transportId) {
		// FIXME: should we also include the receivers user ID in transport messages, so that this
		// mapper can be avoided completely?

		return null;
	}

}
