package deus.core.access.transfer.plugins.xmpp.receiving;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import deus.core.access.transfer.core.messages.TransportMessage;
import deus.core.access.transfer.core.receiving.message.MessageReceiver;

@Component
public class XmppMessageReceiver {

	@Autowired
	private MessageReceiver messageReceiver;


	public void receive(TransportMessage command) {
		messageReceiver.receive(command);
	}

}
