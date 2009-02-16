package deus.core.access.transport.core.soul.mapper;

import deus.core.access.transport.core.soul.protocol.TransportId;
import deus.model.user.id.UserId;

// FIXME: remove this mapper completely
@Deprecated
public interface TransportIdMapper {

	@Deprecated
	public UserId resolveLocal(TransportId transportId);

}
