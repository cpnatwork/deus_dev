package deus.core.access.transfer.core.soul.mapper;

import deus.core.access.transfer.core.soul.protocol.TransferId;
import deus.model.user.id.UserId;

public interface UserIdMapper {

	public TransferId resolveLocal(UserId userId);


	public TransferId resolveRemote(UserId userId);
	
}
