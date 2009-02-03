package deus.core.transport.receiving.message;

import deus.core.transport.messages.TransportMessage;

public interface MessageReceiver {

	public void receive(String transportProtocolId, TransportMessage command);
	
}
