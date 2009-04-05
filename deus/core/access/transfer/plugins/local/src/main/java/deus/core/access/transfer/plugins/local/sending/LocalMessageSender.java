package deus.core.access.transfer.plugins.local.sending;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import deus.core.access.transfer.plugins.local.receiving.LocalMessageForwarder;
import deus.core.access.transport.core.messages.TransportMessage;
import deus.core.access.transport.core.soul.protocol.MessageSender;

@Component
public class LocalMessageSender implements MessageSender {

	@Autowired
	private LocalMessageForwarder localMessageForwarder;

	@Override
	public void send(TransportMessage transportMessage) {
		localMessageForwarder.forward(transportMessage);
	}

}
