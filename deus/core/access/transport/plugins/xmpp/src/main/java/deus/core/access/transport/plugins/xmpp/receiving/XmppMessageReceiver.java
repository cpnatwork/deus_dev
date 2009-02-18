package deus.core.access.transport.plugins.xmpp.receiving;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import deus.core.access.transport.core.messages.TransportMessage;
import deus.core.access.transport.core.receiving.message.MessageReceiver;

@Component
public class XmppMessageReceiver {

	@Autowired
	private MessageReceiver messageReceiver;


	public void receive(TransportMessage command) {
		messageReceiver.receive(command);
	}

}
