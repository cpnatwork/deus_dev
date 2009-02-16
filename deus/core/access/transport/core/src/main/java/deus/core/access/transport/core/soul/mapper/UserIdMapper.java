package deus.core.access.transport.core.soul.mapper;

import deus.core.access.transport.core.soul.protocol.TransportId;
import deus.model.user.id.UserId;

public interface UserIdMapper {

	public TransportId resolveLocal(UserId userId);


	public TransportId resolveRemote(UserId userId);
	
}
