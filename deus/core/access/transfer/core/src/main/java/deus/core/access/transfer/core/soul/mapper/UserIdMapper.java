package deus.core.access.transfer.core.soul.mapper;

import deus.core.access.transfer.core.soul.protocol.TransportId;
import deus.model.user.id.UserId;

public interface UserIdMapper {

	public TransportId resolveLocal(UserId userId);


	public TransportId resolveRemote(UserId userId);
	
}
