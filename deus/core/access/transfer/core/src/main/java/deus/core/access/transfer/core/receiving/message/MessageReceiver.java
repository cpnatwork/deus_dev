package deus.core.access.transfer.core.receiving.message;

import deus.core.access.transfer.core.messages.TransportMessage;

public interface MessageReceiver {

	public void receive(TransportMessage command);
	
}
