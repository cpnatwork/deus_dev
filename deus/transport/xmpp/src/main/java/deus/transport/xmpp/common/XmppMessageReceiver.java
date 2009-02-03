package deus.transport.xmpp.common;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import deus.core.transport.messages.TransportMessage;
import deus.core.transport.receiving.message.MessageReceiver;

@Component
public class XmppMessageReceiver {

	@Resource(name = "transportProtocolId")
	private String transportProtocolId;

	@Autowired
	private MessageReceiver messageReceiver;


	public void receive(TransportMessage command) {
		messageReceiver.receive(transportProtocolId, command);
	}

}
