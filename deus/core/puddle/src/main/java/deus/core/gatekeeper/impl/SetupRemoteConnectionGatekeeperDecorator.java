package deus.core.gatekeeper.impl;

import java.util.Map;

import javax.annotation.Resource;

import deus.core.User;
import deus.core.gatekeeper.Gatekeeper;
import deus.model.user.id.UserId;
import deus.model.user.transportid.TransportIdType;
import deus.remoting.setup.RemoteConnectionSetup;

public class SetupRemoteConnectionGatekeeperDecorator extends AbstractGatekeeperDecorator {

	@Resource(name = "remoteConnectionSetups")
	private Map<TransportIdType, RemoteConnectionSetup> remoteConnectionSetups;


	public SetupRemoteConnectionGatekeeperDecorator(Gatekeeper decoratedGatekeeper) {
		super(decoratedGatekeeper);
	}


	@Override
	protected void doAfterLogin(User user) {
		UserId userId = user.getUserId();
		for (TransportIdType transportIdType : userId.getSupportedTransports()) {
			RemoteConnectionSetup remoteConnectionSetup = remoteConnectionSetups.get(transportIdType);
			if (remoteConnectionSetup == null)
				throw new RuntimeException(
						"there is no RemoteConnectionSetup registered to setup remoting for transport '"
								+ transportIdType + "'");
			else
				remoteConnectionSetup.setUp(user);
		}
	}


	@Override
	protected void doBeforeLogout(User user) {
		UserId userId = user.getUserId();
		for (TransportIdType transportIdType : userId.getSupportedTransports()) {
			RemoteConnectionSetup remoteConnectionSetup = remoteConnectionSetups.get(transportIdType);
			if (remoteConnectionSetup == null)
				throw new RuntimeException(
						"there is no RemoteConnectionSetup registered to tear down remoting for transport '"
								+ transportIdType + "'");
			else
				remoteConnectionSetup.tearDown(user);
		}
	}


}
