package deus.core.access.transport.core.soul.mapper;

import deus.core.access.transport.core.soul.protocol.TransportId;
import deus.model.user.id.UserId;

public interface TransportIdMapper {

	public UserId resolveLocal(TransportId transportId);


	public UserId resolveRemote(TransportId transportId);

}
