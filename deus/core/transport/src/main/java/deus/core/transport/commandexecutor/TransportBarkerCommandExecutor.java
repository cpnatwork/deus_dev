package deus.core.transport.commandexecutor;

import deus.core.soul.common.BarkerCommandExecutor;
import deus.model.user.id.UserId;

// TODO: think about common superclass of command executors, with methods to retrieve MessageSender (see old TransportProtocolDiscoveryCommandExecutor)
public class TransportBarkerCommandExecutor implements BarkerCommandExecutor {

	@Override
	public void denySubscription(UserId subscriberId, UserId publisherId) {
		// TODO Auto-generated method stub

	}


	@Override
	public void grantSubscription(UserId subscriberId, UserId publisherId) {
		// TODO Auto-generated method stub

	}

}
