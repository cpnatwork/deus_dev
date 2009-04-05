package deus.core.access.transfer.core.soul.protocol;

import deus.core.access.transfer.core.messages.TransportMessage;

public interface MessageSender {

	public void send(TransportMessage transportMessage);
	
}
