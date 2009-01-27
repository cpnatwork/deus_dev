package deus.core.gatekeeper.impl;

import org.springframework.beans.factory.annotation.Autowired;

import deus.core.User;
import deus.core.gatekeeper.Gatekeeper;
import deus.model.user.id.UserId;
import deus.model.user.transportid.TransportIdType;
import deus.remoting.setup.MultiRemoteConnectionSetup;

public class SetupRemoteConnectionGatekeeperDecorator extends AbstractGatekeeperDecorator {

	@Autowired
	private MultiRemoteConnectionSetup multiRemoteConnectionSetup;


	public SetupRemoteConnectionGatekeeperDecorator(Gatekeeper decoratedGatekeeper) {
		super(decoratedGatekeeper);
	}


	@Override
	protected void doAfterLogin(User user) {
		UserId userId = user.getUserId();
		for (TransportIdType transportIdType : userId.getSupportedTransports())
			multiRemoteConnectionSetup.setUpConnection(user, transportIdType);
	}


	@Override
	protected void doBeforeLogout(User user) {
		UserId userId = user.getUserId();
		for (TransportIdType transportIdType : userId.getSupportedTransports())
			multiRemoteConnectionSetup.tearDownConnection(user, transportIdType);
	}

}
