package deus.core.access.transport.core.soul.protocol;

import deus.core.access.transport.core.messages.TransportMessage;

public interface MessageSender {

	public void send(TransportMessage transportMessage);
	
}
