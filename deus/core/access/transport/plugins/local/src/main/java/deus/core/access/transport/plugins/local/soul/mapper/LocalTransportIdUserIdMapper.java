package deus.core.access.transport.plugins.local.soul.mapper;

import deus.core.access.transport.plugins.local.soul.protocol.LocalTransportId;
import deus.core.transport.core.protocol.TransportId;
import deus.core.transport.core.protocol.TransportIdUserIdMapper;
import deus.model.user.id.UserId;

public class LocalTransportIdUserIdMapper implements TransportIdUserIdMapper {

	@Override
	public TransportId map(UserId userId) {
		// FIXME: create local transport id from user id
		return new LocalTransportId("alice");
	}

	@Override
	public UserId map(TransportId transportId) {
		// FIXME Auto-generated method stub
		return null;
	}

}
