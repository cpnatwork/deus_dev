package deus.transport.local.sender;

import javax.annotation.Resource;

import deus.core.transport.message.TransportMessage;
import deus.core.transport.message.receiver.MessageReceiver;
import deus.core.transport.message.sender.MessageSender;

public class LocalMessageSender implements MessageSender {

	private MessageReceiver messageReceiver;
	
	@Resource(name="transportProtocolId")
	private String transportProtocolId;

	@Override
	public void send(TransportMessage transportMessage) {
		messageReceiver.receive(transportMessage, transportProtocolId);
	}


	public void setMessageReceiver(MessageReceiver messageReceiver) {
		this.messageReceiver = messageReceiver;
	}

}
