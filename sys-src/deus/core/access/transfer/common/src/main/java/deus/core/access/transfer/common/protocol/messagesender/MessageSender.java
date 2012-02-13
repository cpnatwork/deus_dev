package deus.core.access.transfer.common.protocol.messagesender;

import deus.core.access.transfer.common.messages.TransferMessage;

public interface MessageSender {

	public void send(TransferMessage transferMessage);
	
}
