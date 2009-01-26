package deus.remoting.commandexecutor.impl;

import java.util.Map;

import deus.core.User;
import deus.model.user.transportid.TransportIdType;
import deus.remoting.command.RemoteCommand;
import deus.remoting.setup.RemoteSendingSetup;
import deus.remoting.state.RemotingState;

// TODO: think about decorator pattern for this instead of inheritence from TransportProtocolChoosingRemoteCommandExecutor
public class RemoteSendingSetupRemoteCommandExecutor extends TransportProtocolChoosingRemoteCommandExecutor {
	
	private final Map<TransportIdType, RemoteSendingSetup> remoteSendingSetups;
	
	public RemoteSendingSetupRemoteCommandExecutor(User user, Map<TransportIdType, RemoteSendingSetup> remoteSendingSetups) {
		super(user);
		this.remoteSendingSetups = remoteSendingSetups;
	}

	private void beforeExecute(RemotingState remotingState) {
		RemoteSendingSetup setup = remoteSendingSetups.get(remotingState.getType());
		setup.setUp(user);
	}
	
	private void afterExecute(RemotingState remotingState) {
		RemoteSendingSetup setup = remoteSendingSetups.get(remotingState.getType());
		setup.tearDown(user);
	}

	
	@Override
	protected void execute(RemoteCommand remoteCommand, RemotingState remotingState) {
		beforeExecute(remotingState);
		super.execute(remoteCommand);
		afterExecute(remotingState);
	}

}
