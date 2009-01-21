package deus.nsi.xmpp.common.packetfilter;

import org.jivesoftware.smack.packet.Packet;
import org.jivesoftware.smack.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;

import deus.model.user.UserMetadata;
import deus.model.user.id.XmppUserId;
import deus.nsi.xmpp.common.XmppConfiguration;

@Configurable
public abstract class UserMetadataParsingFilteredPacketListener extends AbstractFilteredPacketListener {

	@Autowired
	private XmppConfiguration xmppConfiguration;


	/**
	 * Returns a UserMetadata object which is filled by parsing the package 'from' element and the package property with
	 * the name, that is set by the method <code>setXmppPropertyFullName</code>.
	 * 
	 * @param packet
	 *            the packet, from which to parse the 'from' data
	 * @param userMetadata
	 *            the user metadata to fill. Since we don't know, whether it's an instance of PublisherMetadata or
	 *            SubscriberMetadata, or another subclass of UserMetadata, the userm metadata is created and then passed
	 *            to the method to fill it.
	 * @return
	 */
	protected void parseFromUserMetadata(Packet packet, UserMetadata<XmppUserId> userMetadata) {
		String from = packet.getFrom();
		if (from == null)
			throw new RuntimeException("'from' field is null at this presence packet: " + packet);

		XmppUserId subscriberJid = new XmppUserId();
		subscriberJid.setServer(StringUtils.parseServer(from));
		subscriberJid.setUsername(StringUtils.parseName(from));

		userMetadata.setUserId(subscriberJid);

		Object fullName = packet.getProperty(xmppConfiguration.getXmppPropertyFullName());
		if (fullName == null)
			throw new RuntimeException("property '" + xmppConfiguration.getXmppPropertyFullName()
					+ "' is null at this presence packet: " + packet);
		userMetadata.setFullName(fullName.toString());
	}

}
