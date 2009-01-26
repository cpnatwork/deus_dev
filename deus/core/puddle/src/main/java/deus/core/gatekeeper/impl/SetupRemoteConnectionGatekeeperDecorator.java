package deus.core.gatekeeper.impl;

import java.util.Map;

import deus.core.User;
import deus.core.gatekeeper.Gatekeeper;
import deus.model.user.transportid.TransportIdType;
import deus.remoting.setup.RemoteConnectionSetup;

public class SetupRemoteConnectionGatekeeperDecorator extends AbstractGatekeeperDecorator {

	private Map<TransportIdType, RemoteConnectionSetup> remoteConnectionSetups;

	
	public SetupRemoteConnectionGatekeeperDecorator(Gatekeeper decoratedGatekeeper) {
		super(decoratedGatekeeper);
	}


	@Override
	protected void doAfterLogin(User user) {
		for(RemoteConnectionSetup remoteConnectionSetup : remoteConnectionSetups.values())
			remoteConnectionSetup.setUp(user);
	}


	@Override
	protected void doBeforeLogout(User user) {
		for(RemoteConnectionSetup remoteConnectionSetup : remoteConnectionSetups.values())
			remoteConnectionSetup.tearDown(user);
	}


}
