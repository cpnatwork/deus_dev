package deus.transport.xmpp.common.packetlistener.impl;

import org.jivesoftware.smack.packet.Packet;
import org.jivesoftware.smack.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;

import deus.core.transport.command.Command;
import deus.core.transport.receiver.RemoteCommandReceiver;
import deus.model.user.UserMetadata;
import deus.model.user.id.UserId;
import deus.model.user.id.UserUrl;
import deus.transport.xmpp.common.XmppConfiguration;
import deus.transport.xmpp.id.XmppTransportId;

@Configurable
public abstract class UserMetadataParsingFilteredPacketListener extends AbstractFilteredPacketListener {

	@Autowired
	private XmppConfiguration xmppConfiguration;


	@Autowired
	protected RemoteCommandReceiver remoteCommandReceiver;


	/**
	 * Returns a UserMetadata object which is filled by parsing the package 'from' element and the package property with
	 * the name, that is set by the method <code>setXmppPropertyFullName</code>.
	 * 
	 * @param packet the packet, from which to parse the 'from' data
	 * @return
	 */
	protected UserMetadata parseFromUserMetadata(Packet packet) {
		UserMetadata userMetadata = new UserMetadata();
		// String from = packet.getFrom();
		// if (from == null)
		// throw new RuntimeException("'from' field is null at this presence packet: " + packet);

		UserId userId = new UserUrl();

		// FIXME: parse userURL (also think about parsing UserUrl vs. UserXri, ...)

		userMetadata.setUserId(userId);

		Object fullName = packet.getProperty(xmppConfiguration.getXmppPropertyFullName());
		if (fullName == null)
			throw new RuntimeException("property '" + xmppConfiguration.getXmppPropertyFullName()
					+ "' is null at this presence packet: " + packet);
		userMetadata.setFullName(fullName.toString());

		return userMetadata;
	}


	protected XmppTransportId parseXmppTransportId(String xmppTransportId) {
		if(xmppTransportId.isEmpty())
			throw new IllegalStateException("xmpp transport id to parse is empty");
		String username = StringUtils.parseName(xmppTransportId);
		String server = StringUtils.parseServer(xmppTransportId);
		return new XmppTransportId(username, server);
	}
	
	
	protected void sendCommand(Command command, Packet packet) {
		UserMetadata senderMetadata = parseFromUserMetadata(packet);
		
		// FIXME: how to get UserId here? it is not in received package!
		command.setReceiverId(null);
		command.setSenderMetadata(senderMetadata);
		
		
		XmppTransportId senderJid = parseXmppTransportId(packet.getFrom());
		XmppTransportId receiverJid = parseXmppTransportId(packet.getTo());
		
		remoteCommandReceiver.receive(command, senderJid, receiverJid);
	}

}
