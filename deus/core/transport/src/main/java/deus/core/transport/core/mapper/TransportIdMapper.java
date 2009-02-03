package deus.core.transport.core.mapper;

import deus.core.transport.core.protocol.TransportId;
import deus.model.user.id.UserId;

public interface TransportIdMapper {

	public UserId resolveLocal(TransportId transportId);


	public UserId resolveRemote(TransportId transportId);

}
