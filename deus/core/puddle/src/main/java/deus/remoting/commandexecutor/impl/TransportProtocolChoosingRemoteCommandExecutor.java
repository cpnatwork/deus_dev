package deus.remoting.commandexecutor.impl;


import deus.model.user.id.UserId;
import deus.model.user.transportid.TransportIdType;
import deus.remoting.command.RemoteCommand;
import deus.remoting.commandexecutor.RemoteCommandExecutor;
import deus.remoting.setup.MultiRemoteSendingSetup;
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

	private final UserId senderId;
	private final RemotingStateRegistry remotingStateRegistry;

	private final TransportProtocolChoosingStrategy choosingStrategy;
	private final MultiRemoteSendingSetup remoteSendingSetup;


	public TransportProtocolChoosingRemoteCommandExecutor(UserId userId, RemotingStateRegistry remotingStateRegistry,
			TransportProtocolChoosingStrategy choosingStrategy,
			MultiRemoteSendingSetup remoteSendingSetup) {
		super();
		this.senderId = userId;
		this.remotingStateRegistry = remotingStateRegistry;
		this.choosingStrategy = choosingStrategy;
		this.remoteSendingSetup = remoteSendingSetup;
	}


	protected final TransportIdType chooseTransportProtocol(RemoteCommand remoteCommand) {
		UserId receiverId = remoteCommand.getReceiverId();

		TransportIdType chosenTransportIdType = choosingStrategy.chooseTransportIdType(senderId, receiverId);
		return chosenTransportIdType;
	}


	@Override
	public final void execute(RemoteCommand remoteCommand) {
		TransportIdType transportIdType = chooseTransportProtocol(remoteCommand);

		// SETUP
		RemotingState remotingState = remoteSendingSetup.setUpSending(remotingStateRegistry, transportIdType,
				remoteCommand.getReceiverId(), remoteCommand.getReceiverSubsystem());

		execute(remoteCommand, remotingState);

		// TEAR DOWN
		remoteSendingSetup.tearDownSending(remotingStateRegistry, transportIdType, remoteCommand.getReceiverId(),
				remoteCommand.getReceiverSubsystem());
	}


	protected void execute(RemoteCommand remoteCommand, RemotingState remotingState) {
		if (!remotingState.isSendingReady(remoteCommand.getReceiverId(), remoteCommand.getReceiverSubsystem()))
			throw new IllegalStateException("cannot execute remote command " + remoteCommand
					+ ", remote sending ist not ready!");
		remoteCommand.execute(remotingState);
	}

}