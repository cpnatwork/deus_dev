package deus.core.access.transfer.core.soul.protocol;

import deus.core.access.transfer.core.messages.TransferMessage;

public interface MessageSender {

	public void send(TransferMessage transferMessage);
	
}
