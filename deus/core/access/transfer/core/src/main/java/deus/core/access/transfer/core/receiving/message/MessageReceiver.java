package deus.core.access.transfer.core.receiving.message;

import deus.core.access.transfer.core.messages.TransferMessage;

public interface MessageReceiver {

	public void receive(TransferMessage command);
	
}
