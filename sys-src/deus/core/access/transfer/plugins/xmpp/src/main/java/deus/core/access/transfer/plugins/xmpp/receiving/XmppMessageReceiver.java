package deus.core.access.transfer.plugins.xmpp.receiving;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import deus.core.access.transfer.common.messages.TransferMessage;
import deus.core.access.transfer.common.protocol.messagereceiver.MessageReceiver;

@Component
public class XmppMessageReceiver {

	@Autowired
	private MessageReceiver messageReceiver;


	public void receive(TransferMessage command) {
		messageReceiver.receive(command);
	}

}
