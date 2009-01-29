package deus.core.transport.state.local;

import deus.core.transport.state.impl.AbstractRemotingState;
import deus.model.user.transportid.TransportIdType;

public class LocalRemotingState extends AbstractRemotingState {

	@Override
	public TransportIdType getType() {
		return TransportIdType.local;
	}

}
