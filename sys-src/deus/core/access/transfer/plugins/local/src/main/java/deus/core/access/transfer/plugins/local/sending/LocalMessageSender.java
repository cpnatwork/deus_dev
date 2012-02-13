package deus.core.access.transfer.plugins.local.sending;

import javax.inject.Inject;
import javax.inject.Named;

import deus.core.access.transfer.common.messages.TransferMessage;
import deus.core.access.transfer.common.protocol.messagesender.MessageSender;
import deus.core.access.transfer.plugins.local.receiving.LocalMessageForwarder;

@Named
public class LocalMessageSender implements MessageSender {

	@Inject
	private LocalMessageForwarder localMessageForwarder;

	@Override
	public void send(TransferMessage transferMessage) {
		localMessageForwarder.forward(transferMessage);
	}

}
