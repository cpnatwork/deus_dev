package deus.core.access.transport.plugins.local.receiving;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import deus.core.transport.messages.TransportMessage;
import deus.core.transport.receiving.message.MessageReceiver;

@Component
public class LocalMessageReceiver {

	@Resource(name = "transportProtocolId")
	private String transportProtocolId;

	@Autowired
	private MessageReceiver messageReceiver;


	public void receive(TransportMessage transportMessage) {
		messageReceiver.receive(transportProtocolId, transportMessage);
	}

}
