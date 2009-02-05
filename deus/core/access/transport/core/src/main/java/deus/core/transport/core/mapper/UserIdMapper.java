package deus.core.transport.core.mapper;

import deus.core.transport.core.protocol.TransportId;
import deus.model.user.id.UserId;

public interface UserIdMapper {

	public TransportId resolveLocal(UserId userId, String transportProtocolId);


	public TransportId resolveRemote(UserId userId, String transportProtocolId);
	
}
