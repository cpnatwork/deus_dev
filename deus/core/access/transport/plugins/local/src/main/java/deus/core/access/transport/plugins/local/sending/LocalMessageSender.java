package deus.core.access.transport.plugins.local.sending;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import deus.core.access.transport.plugins.local.receiving.LocalMessageReceiver;
import deus.core.transport.core.protocol.MessageSender;
import deus.core.transport.messages.TransportMessage;

@Component
public class LocalMessageSender implements MessageSender {

	@Autowired
	private LocalMessageReceiver localMessageReceiver;

	@Override
	public void send(TransportMessage transportMessage) {
		localMessageReceiver.receive(transportMessage);
	}

}
