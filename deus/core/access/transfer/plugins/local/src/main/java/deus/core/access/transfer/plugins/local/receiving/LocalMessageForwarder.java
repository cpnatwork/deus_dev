package deus.core.access.transfer.plugins.local.receiving;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import deus.core.access.transfer.common.messages.TransferMessage;
import deus.core.access.transfer.common.protocol.messagereceiver.MessageReceiver;

@Component
public class LocalMessageForwarder {

	@Autowired
	private MessageReceiver messageReceiver;


	public void forward(TransferMessage transferMessage) {
		messageReceiver.receive(transferMessage);
	}

}
