package deus.transport.local.id;

import deus.core.transport.id.TransportIdUserIdMapper;
import deus.core.transport.id.TransportId;
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
