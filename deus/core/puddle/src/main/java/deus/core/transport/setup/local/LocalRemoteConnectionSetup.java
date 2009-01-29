package deus.core.transport.setup.local;

import deus.core.soul.User;
import deus.core.transport.setup.impl.AbstractRemoteConnectionSetup;
import deus.core.transport.state.RemotingState;
import deus.core.transport.state.local.LocalRemotingState;
import deus.model.user.transportid.TransportIdType;

public class LocalRemoteConnectionSetup extends AbstractRemoteConnectionSetup {

	@Override
	protected RemotingState checkedSetUp(User user) {
		LocalRemotingState remotingState = new LocalRemotingState();

		return remotingState;
	}


	@Override
	protected void checkedTearDown(RemotingState remotingState) {

	}


	@Override
	public TransportIdType getType() {
		return TransportIdType.local;
	}

}
