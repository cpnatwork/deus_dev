package deus.core.transport.sender;

import deus.core.transport.command.Command;
import deus.core.transport.id.TransportId;

public interface RemoteCommandSender {

	public void send(Command command, TransportId senderTid, TransportId receiverTid);
	
}
