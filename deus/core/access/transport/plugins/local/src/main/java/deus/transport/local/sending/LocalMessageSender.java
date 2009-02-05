package deus.transport.local.sending;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import deus.core.transport.core.protocol.MessageSender;
import deus.core.transport.messages.TransportMessage;
import deus.transport.local.receiving.LocalMessageReceiver;

@Component
public class LocalMessageSender implements MessageSender {

	@Autowired
	private LocalMessageReceiver localMessageReceiver;

	@Override
	public void send(TransportMessage transportMessage) {
		localMessageReceiver.receive(transportMessage);
	}

}
