package deus.core.access.transfer.plugins.local.protocol.mapper;

import deus.core.access.transfer.common.protocol.TransferId;
import deus.core.access.transfer.common.protocol.mapper.UserIdMapper;
import deus.core.access.transfer.plugins.local.protocol.LocalTransferId;
import deus.model.common.user.id.UserId;

/**
 * Returns local transfer IDs, where the username is just taken from the UserId.
 * 
 * @author Florian Rampp (Florian.Rampp@informatik.stud.uni-erlangen.de)
 *
 */
public class LocalUserIdMapper implements UserIdMapper {

	@Override
	public TransferId resolveLocal(UserId userId) {
		return new LocalTransferId(userId.getUsername() + "/local");
	}


	@Override
	public TransferId resolveRemote(UserId userId) {
		// FIXME: Implement this by using discovery
		// it should stay here, but maybe use discovery helper classes from transfer-core
		
		return new LocalTransferId(userId.getUsername() + "/local");
	}

}
