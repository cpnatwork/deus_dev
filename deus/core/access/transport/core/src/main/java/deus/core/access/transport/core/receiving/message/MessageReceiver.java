package deus.core.access.transport.core.receiving.message;

import deus.core.access.transport.core.messages.TransportMessage;

public interface MessageReceiver {

	public void receive(String transportProtocolId, TransportMessage command);
	
}
