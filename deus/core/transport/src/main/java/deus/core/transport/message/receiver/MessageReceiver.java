package deus.core.transport.message.receiver;

import deus.core.transport.message.TransportMessage;

public interface MessageReceiver {

	public void receive(TransportMessage command, String transportProtocolId);
	
}
