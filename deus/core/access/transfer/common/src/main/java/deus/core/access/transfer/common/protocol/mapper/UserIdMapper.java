package deus.core.access.transfer.common.protocol.mapper;

import deus.core.access.transfer.common.protocol.TransferId;
import deus.model.common.user.id.UserId;

public interface UserIdMapper {

	public TransferId resolveLocal(UserId userId);


	public TransferId resolveRemote(UserId userId);
	
}
