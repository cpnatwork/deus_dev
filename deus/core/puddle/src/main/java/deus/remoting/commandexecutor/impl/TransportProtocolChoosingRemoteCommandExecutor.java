package deus.remoting.commandexecutor.impl;


import deus.core.User;
import deus.model.user.id.UserId;
import deus.model.user.transportid.TransportIdType;
import deus.remoting.command.RemoteCommand;
import deus.remoting.commandexecutor.RemoteCommandExecutor;
import deus.remoting.setup.RemoteSendingSetupStrategy;
import deus.remoting.state.RemotingState;
import deus.remoting.state.RemotingStateRegistry;
import deus.remoting.tpchoosing.TransportProtocolChoosingStrategy;


/**
 * Since the <code>RemoteCommand</code> is agnostic of the transport protocol used to execute it, a strategy pattern is
 * used to inject a chooser for the transport protocol. Each implementation of <code>RemoteCommandExecutor</code> should
 * be aware of the user, to which it belongs. Also, each <code>RemoteCommand</code> knows the receiver of the command.
 * Based on these two IDs (sender and receiver), an instance of <code>TransportProtocolChoosingStrategy</code> can
 * choose a transport protocol among the intersection of the available transport protocols of the sender and the
 * receiver.
 * 
 * @author Florian Rampp (Florian.Rampp@informatik.stud.uni-erlangen.de)
 * 
 */
public class TransportProtocolChoosingRemoteCommandExecutor implements RemoteCommandExecutor {

	protected TransportProtocolChoosingStrategy choosingStrategy;
	protected final User user;

	private RemoteSendingSetupStrategy remoteSendingSetupStrategy;

	public TransportProtocolChoosingRemoteCommandExecutor(User user) {
		super();
		this.user = user;
	}


	protected final RemotingState getRemotingState(RemoteCommand remoteCommand) {
		// sender
		UserId senderId = user.getUserId();
		UserId receiverId = remoteCommand.getReceiverId();

		TransportIdType chosenTransportIdType = choosingStrategy.chooseTransportIdType(senderId, receiverId);
		RemotingStateRegistry remotingStateRegistry = user.getRemotingStateRegistry();
		RemotingState remotingState = remotingStateRegistry.getRemotingState(chosenTransportIdType);

		return remotingState;
	}


	public void setTransportProtocolChoosingStrategy(TransportProtocolChoosingStrategy choosingStrategy) {
		this.choosingStrategy = choosingStrategy;
	}
	
	public void setRemoteSendingSetupStrategy(RemoteSendingSetupStrategy remoteSendingSetupStrategy) {
		this.remoteSendingSetupStrategy = remoteSendingSetupStrategy;
	}


	@Override
	public final void execute(RemoteCommand remoteCommand) {
		RemotingState remotingState = getRemotingState(remoteCommand);
		
		remoteSendingSetupStrategy.setupSending(remotingState, remoteCommand.getReceiverId(), remoteCommand.getReceiverSubsystem());
		
		execute(remoteCommand, remotingState);
		
		remoteSendingSetupStrategy.tearDownSending(remotingState, remoteCommand.getReceiverId(), remoteCommand.getReceiverSubsystem());
	}


	protected void execute(RemoteCommand remoteCommand, RemotingState remotingState) {
		if(!remotingState.isSendingReady(remoteCommand.getReceiverId(), remoteCommand.getReceiverSubsystem()))
			throw new IllegalStateException("cannot execute remote command " + remoteCommand + ", remote sending ist not ready!");
		remoteCommand.execute(remotingState);
	}

}