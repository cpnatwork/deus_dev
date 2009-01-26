package deus.remoting.commandexecutor.impl;


import deus.core.User;
import deus.model.user.transportid.TransportIdType;
import deus.remoting.command.RemoteCommand;
import deus.remoting.commandexecutor.RemoteCommandExecutor;
import deus.remoting.commandexecutor.TransportProtocolChoosingStrategy;
import deus.remoting.state.RemotingState;
import deus.remoting.state.RemotingStateRegistry;


// TODO: javadoc
/**
 *  * 
 * Since the RemoteCommand is agnostic of the transport protocol used to execute it, the strategy pattern is used to
 * inject a chooser for the transport protocol. Each implementation of <code>RemoteCommandExecutor</code> should be
 * aware of the user, to which it belongs, so that a transport protocol can be chosen among the available transport
 * protocols for this user.
 * @author Florian Rampp (Florian.Rampp@informatik.stud.uni-erlangen.de)
 *
 */
public class TransportProtocolChoosingRemoteCommandExecutor implements RemoteCommandExecutor {

	protected TransportProtocolChoosingStrategy choosingStrategy;
	protected final User user;


	public TransportProtocolChoosingRemoteCommandExecutor(User user) {
		super();
		this.user = user;
	}


	protected final RemotingState getRemotingState() {
		// which transport protocol to user for executing the remote command?
		TransportIdType chosenTransportIdType = choosingStrategy.choseTransportIdType(user.getUserMetadata()
				.getUserId());
		RemotingStateRegistry remotingStateRegistry = user.getRemotingStateRegistry();
		RemotingState remotingState = remotingStateRegistry.getRemotingState(chosenTransportIdType);

		return remotingState;
	}


	public void setTransportProtocolChoosingStrategy(TransportProtocolChoosingStrategy choosingStrategy) {
		this.choosingStrategy = choosingStrategy;
	}


	@Override
	public final void execute(RemoteCommand remoteCommand) {
		RemotingState remotingState = getRemotingState();

		execute(remoteCommand, remotingState);
	}


	protected void execute(RemoteCommand remoteCommand, RemotingState remotingState) {
		remoteCommand.execute(remotingState);
	}

}