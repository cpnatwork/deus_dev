package deus.transport.local.id;

import deus.core.transport.id.LocalUserTransportIdFactory;
import deus.core.transport.id.TransportId;
import deus.model.user.id.UserId;

public class LocalLocalUserTransportIdFactory implements LocalUserTransportIdFactory {

	@Override
	public TransportId createTransportId(UserId userId) {
		// FIXME: create local transport id from user id
		return new LocalTransportId("alice");
	}

}
