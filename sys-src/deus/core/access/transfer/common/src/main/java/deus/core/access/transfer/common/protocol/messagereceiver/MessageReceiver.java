package deus.core.access.transfer.common.protocol.messagereceiver;

import deus.core.access.transfer.common.messages.TransferMessage;

public interface MessageReceiver {

	public void receive(TransferMessage command);
	
}
