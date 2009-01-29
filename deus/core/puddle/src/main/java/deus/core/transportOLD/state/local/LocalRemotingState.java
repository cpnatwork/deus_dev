package deus.core.transportOLD.state.local;

import deus.core.transportOLD.state.impl.AbstractRemotingState;
import deus.model.user.transportid.TransportIdType;

public class LocalRemotingState extends AbstractRemotingState {

	@Override
	public TransportIdType getType() {
		return TransportIdType.local;
	}

}
