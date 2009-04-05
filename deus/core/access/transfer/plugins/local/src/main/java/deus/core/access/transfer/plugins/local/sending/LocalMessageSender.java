package deus.core.access.transfer.plugins.local.sending;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import deus.core.access.transfer.core.messages.TransportMessage;
import deus.core.access.transfer.core.soul.protocol.MessageSender;
import deus.core.access.transfer.plugins.local.receiving.LocalMessageForwarder;

@Component
public class LocalMessageSender implements MessageSender {

	@Autowired
	private LocalMessageForwarder localMessageForwarder;

	@Override
	public void send(TransportMessage transportMessage) {
		localMessageForwarder.forward(transportMessage);
	}

}
