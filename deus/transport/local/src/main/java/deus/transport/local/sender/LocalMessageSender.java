package deus.transport.local.sender;

import deus.core.transport.message.TransportMessage;
import deus.core.transport.message.receiver.MessageReceiver;
import deus.core.transport.message.sender.MessageSender;

public class LocalMessageSender implements MessageSender {

	private MessageReceiver messageReceiver;

	@Override
	public void send(TransportMessage transportMessage) {
		messageReceiver.receive(transportMessage);
	}


	public void setMessageReceiver(MessageReceiver messageReceiver) {
		this.messageReceiver = messageReceiver;
	}

}
