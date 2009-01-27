package deus.remoting.commandexecutor.impl;

import java.util.Map;

import deus.core.User;
import deus.model.user.transportid.TransportIdType;
import deus.remoting.command.RemoteCommand;
import deus.remoting.setup.RemoteSendingSetup;
import deus.remoting.state.RemotingState;

/**
 * <code>RemoteCommandExecutor</code>, that sets up remote sending before executing the remote command.
 * Only the sending of the transport protocol, that is used by the remote command is set up!
 * 
 * @author Florian Rampp (Florian.Rampp@informatik.stud.uni-erlangen.de)
 */
//TODO: think about decorator pattern for this instead of inheritence from TransportProtocolChoosingRemoteCommandExecutor
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
		super.execute(remoteCommand, remotingState);
		afterExecute(remotingState);
	}

}
