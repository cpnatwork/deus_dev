package dacus.model.user.transportid;

import deus.model.user.id.transportid.TransportId;
import deus.model.user.id.transportid.TransportIdType;

public class LocalTransportId implements TransportId {

	@Override
	public TransportIdType getType() {
		return TransportIdType.local;
	}

}
