package deus.core.gatekeeper.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import deus.core.User;
import deus.core.gatekeeper.Gatekeeper;
import deus.model.user.transportid.TransportIdType;
import deus.remoting.setup.RemoteConnectionSetup;

public class SetupRemoteConnectionGatekeeperDecorator extends AbstractGatekeeperDecorator {

	@Autowired
	private Map<TransportIdType, RemoteConnectionSetup> remoteConnectionSetups;

	
	public SetupRemoteConnectionGatekeeperDecorator(Gatekeeper decoratedGatekeeper) {
		super(decoratedGatekeeper);
	}


	// FIXME: set up only the remote connection, the user has a transport id for
	@Override
	protected void doAfterLogin(User user) {
		for(RemoteConnectionSetup remoteConnectionSetup : remoteConnectionSetups.values())
			remoteConnectionSetup.setUp(user);
	}


	// FIXME: tear down only the remote connection, the user has a transport id for
	@Override
	protected void doBeforeLogout(User user) {
		for(RemoteConnectionSetup remoteConnectionSetup : remoteConnectionSetups.values())
			remoteConnectionSetup.tearDown(user);
	}


}
