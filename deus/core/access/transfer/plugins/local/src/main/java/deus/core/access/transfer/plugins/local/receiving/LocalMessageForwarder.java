package deus.core.access.transfer.plugins.local.receiving;

import javax.inject.Inject;
import javax.inject.Named;

import deus.core.access.transfer.common.messages.TransferMessage;
import deus.core.access.transfer.common.protocol.messagereceiver.MessageReceiver;

@Named
public class LocalMessageForwarder {

	@Inject
	private MessageReceiver messageReceiver;


	public void forward(TransferMessage transferMessage) {
		messageReceiver.receive(transferMessage);
	}

}
