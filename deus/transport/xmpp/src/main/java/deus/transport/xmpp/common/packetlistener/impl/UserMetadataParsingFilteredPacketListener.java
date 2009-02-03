package deus.transport.xmpp.common.packetlistener.impl;

import org.jivesoftware.smack.packet.Packet;
import org.jivesoftware.smack.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import deus.core.transport.messages.TransportMessage;
import deus.core.transport.receiving.message.MessageReceiver;
import deus.transport.xmpp.common.XmppConfiguration;
import deus.transport.xmpp.common.XmppMessageReceiver;
import deus.transport.xmpp.id.XmppTransportId;

@Component
public abstract class UserMetadataParsingFilteredPacketListener extends AbstractFilteredPacketListener {

	@Autowired
	private XmppConfiguration xmppConfiguration;

	@Autowired
	protected XmppMessageReceiver messageReceiver;


	protected XmppTransportId parseXmppTransportId(String xmppTransportId) {
		if(xmppTransportId.isEmpty())
			throw new IllegalStateException("xmpp transport id to parse is empty");
		String username = StringUtils.parseName(xmppTransportId);
		String server = StringUtils.parseServer(xmppTransportId);
		return new XmppTransportId(username, server);
	}
	
	
	protected void sendCommand(TransportMessage command, Packet packet) {
		//UserMetadata senderMetadata = parseFromUserMetadata(packet);
		
		XmppTransportId senderJid = parseXmppTransportId(packet.getFrom());
		XmppTransportId receiverJid = parseXmppTransportId(packet.getTo());
		
		command.setSenderTid(senderJid);
		command.setReceiverTid(receiverJid);
		
		messageReceiver.receive(command);
	}

}
