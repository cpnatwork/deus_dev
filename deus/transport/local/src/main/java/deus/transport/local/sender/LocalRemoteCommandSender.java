package deus.transport.local.sender;

import deus.core.transport.command.Command;
import deus.core.transport.id.TransportId;
import deus.core.transport.receiver.RemoteCommandReceiver;
import deus.core.transport.sender.RemoteCommandSender;

public class LocalRemoteCommandSender implements RemoteCommandSender {

	private RemoteCommandReceiver remoteCommandReceiver;


	@Override
	public void send(Command command, TransportId senderTid, TransportId receiverTid) {
		remoteCommandReceiver.receive(command, senderTid, receiverTid);
	}


	public void setRemoteCommandReceiver(RemoteCommandReceiver remoteCommandReceiver) {
		this.remoteCommandReceiver = remoteCommandReceiver;
	}

}
