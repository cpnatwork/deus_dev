package deus.core.transport.message.sender;

import deus.core.transport.message.TransportMessage;

public interface MessageSender {

	public void send(TransportMessage transportMessage);
	
}
