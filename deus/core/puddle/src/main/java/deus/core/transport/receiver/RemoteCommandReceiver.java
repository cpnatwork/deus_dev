package deus.core.transport.receiver;

import deus.core.transport.command.Command;
import deus.core.transport.id.TransportId;

public interface RemoteCommandReceiver {

	public void receive(Command command, TransportId senderTid, TransportId receiverTid);
	
}
