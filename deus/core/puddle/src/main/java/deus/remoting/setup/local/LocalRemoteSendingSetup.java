package deus.remoting.setup.local;

import deus.core.User;
import deus.model.user.transportid.TransportIdType;
import deus.remoting.setup.impl.AbstractRemoteSendingSetup;
import deus.remoting.state.RemotingState;

// TODO: where to put this package??
public class LocalRemoteSendingSetup extends AbstractRemoteSendingSetup {

	@Override
	public TransportIdType getType() {
		return TransportIdType.local;
	}

	@Override
	protected void checkedSetUp(User user, RemotingState remotingState) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void checkedTearDown(RemotingState remotingState) {
		// TODO Auto-generated method stub
		
	}

}
