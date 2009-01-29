package deus.core.transportOLD.setup.impl;

import java.util.Map;

import deus.core.soul.User;
import deus.core.transportOLD.setup.MultiRemoteConnectionSetup;
import deus.core.transportOLD.setup.RemoteConnectionSetup;
import deus.model.user.transportid.TransportIdType;

// TODO: implement and inject into GateKepper
public class MultiRemoteConnectionSetupImpl implements MultiRemoteConnectionSetup {

	private final Map<TransportIdType, RemoteConnectionSetup> remoteConnectionSetups;


	public MultiRemoteConnectionSetupImpl(Map<TransportIdType, RemoteConnectionSetup> remoteConnectionSetups) {
		super();
		this.remoteConnectionSetups = remoteConnectionSetups;
	}


	@Override
	public void setUpConnection(User user, TransportIdType type) {
		if (user.getRemotingStateRegistry().hasRemotingState(type))
			throw new IllegalStateException("Can't setup remote connection for protocol " + type
					+ "! There already is a remoting state for the transport protocol " + type + " registered!");

		RemoteConnectionSetup remoteConnectionSetup = remoteConnectionSetups.get(type);
		if (remoteConnectionSetup == null)
			throw new RuntimeException(
					"Cannot setup connection. There is no RemoteConnectionSetup for transport protocol " + type
							+ " registered!");

		remoteConnectionSetup.setUp(user);
	}


	@Override
	public void tearDownConnection(User user, TransportIdType type) {
		if (!user.getRemotingStateRegistry().hasRemotingState(type))
			throw new IllegalStateException("Can't tear down remote connection for protocol " + type
					+ "! There is no remoting state for the transport protocol " + type + " registered!");

		RemoteConnectionSetup remoteConnectionSetup = remoteConnectionSetups.get(type);
		if (remoteConnectionSetup == null)
			throw new RuntimeException(
					"Cannot tear down connection. There is no RemoteConnectionSetup for transport protocol " + type
							+ " registered!");

		remoteConnectionSetup.tearDown(user);
	}

}
