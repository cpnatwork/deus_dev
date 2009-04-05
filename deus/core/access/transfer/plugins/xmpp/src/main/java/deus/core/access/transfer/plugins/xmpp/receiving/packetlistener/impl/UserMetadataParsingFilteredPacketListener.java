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


	protected XmppTransferId parseXmppTransferId(String xmppTransferId) {
		if(xmppTransferId.isEmpty())
			throw new IllegalStateException("xmpp transfer id to parse is empty");
		String username = StringUtils.parseName(xmppTransferId);
		String server = StringUtils.parseServer(xmppTransferId);
		return new XmppTransferId(username, server);
	}
	
	
	protected void receiveCommand(TransferMessage command, Packet packet) {
		//UserMetadata senderMetadata = parseFromUserMetadata(packet);
		
		XmppTransferId senderJid = parseXmppTransferId(packet.getFrom());
		XmppTransferId receiverJid = parseXmppTransferId(packet.getTo());
		
		// FIXME: add sender ID here
		// FIXME: add receiver ID here
		
		command.setSenderTid(senderJid);
		command.setReceiverTid(receiverJid);
		
		messageReceiver.receive(command);
	}

}
