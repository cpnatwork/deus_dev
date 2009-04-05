package deus.core.access.transfer.plugins.xmpp.receiving.packetlistener.impl;

import org.jivesoftware.smack.packet.Packet;
import org.jivesoftware.smack.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import deus.core.access.transfer.core.messages.TransferMessage;
import deus.core.access.transfer.plugins.xmpp.core.protocol.XmppTransferId;
import deus.core.access.transfer.plugins.xmpp.receiving.XmppMessageReceiver;

@Component
public abstract class UserMetadataParsingFilteredPacketListener extends AbstractFilteredPacketListener {

	@Autowired
	protected XmppMessageReceiver messageReceiver;


	protected XmppTransferId parseXmppTransportId(String xmppTransportId) {
		if(xmppTransportId.isEmpty())
			throw new IllegalStateException("xmpp transport id to parse is empty");
		String username = StringUtils.parseName(xmppTransportId);
		String server = StringUtils.parseServer(xmppTransportId);
		return new XmppTransferId(username, server);
	}
	
	
	protected void receiveCommand(TransferMessage command, Packet packet) {
		//UserMetadata senderMetadata = parseFromUserMetadata(packet);
		
		XmppTransferId senderJid = parseXmppTransportId(packet.getFrom());
		XmppTransferId receiverJid = parseXmppTransportId(packet.getTo());
		
		// FIXME: add sender ID here
		// FIXME: add receiver ID here
		
		command.setSenderTid(senderJid);
		command.setReceiverTid(receiverJid);
		
		messageReceiver.receive(command);
	}

}
