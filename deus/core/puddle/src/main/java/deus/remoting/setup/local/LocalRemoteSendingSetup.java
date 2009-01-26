package deus.remoting.setup.local;

import deus.core.User;
import deus.model.user.transportid.TransportIdType;
import deus.remoting.setup.impl.AbstractRemoteSendingSetup;

// TODO: where to put this package??
public class LocalRemoteSendingSetup extends AbstractRemoteSendingSetup {

	@Override
	public void checkedSetUp(User user) {
		// TODO Auto-generated method stub

	}


	@Override
	public void checkedTearDown(User user) {
		// TODO Auto-generated method stub

	}


	@Override
	public TransportIdType getType() {
		return TransportIdType.local;
	}

}
