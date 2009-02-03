package deus.core.transport.core.protocol;

import deus.core.transport.messages.TransportMessage;

public interface MessageSender {

	public void send(TransportMessage transportMessage);
	
}
