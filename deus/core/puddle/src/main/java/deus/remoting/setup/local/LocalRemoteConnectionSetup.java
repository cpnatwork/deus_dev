package deus.remoting.setup.local;

import deus.core.User;
import deus.model.user.transportid.TransportIdType;
import deus.remoting.setup.impl.AbstractRemoteConnectionSetup;
import deus.remoting.state.RemotingState;
import deus.remoting.state.local.LocalRemotingState;

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
