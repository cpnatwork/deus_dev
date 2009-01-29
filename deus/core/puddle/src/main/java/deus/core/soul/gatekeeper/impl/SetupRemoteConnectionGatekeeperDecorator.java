package deus.core.soul.gatekeeper.impl;

import org.springframework.beans.factory.annotation.Autowired;

import deus.core.soul.User;
import deus.core.soul.gatekeeper.Gatekeeper;
import deus.core.transport.setup.MultiRemoteConnectionSetup;
import deus.model.user.id.UserId;
import deus.model.user.transportid.TransportIdType;

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
