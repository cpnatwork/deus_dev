package dacus.model.user.transportid;

import deus.model.user.transportid.TransportId;
import deus.model.user.transportid.TransportIdType;

public class LocalTransportId implements TransportId {

	@Override
	public TransportIdType getType() {
		return TransportIdType.local;
	}

}
