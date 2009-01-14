package deus.nsi.xmpp.common.packetfilter;

import org.jivesoftware.smack.packet.Packet;
import org.jivesoftware.smack.util.StringUtils;

import deus.model.user.UserMetadata;
import deus.model.user.id.XmppUserId;

public abstract class AbstractFilteredPacketListener implements FilteredPacketListener {

	private String xmppPropertyFullName = null;


	/**
	 * Returns a UserMetadata object which is filled by parsing the package 'from' element and the package property
	 * 'fullName'.
	 * 
	 * @param packet
	 * @param userMetadata
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

		Object fullName = packet.getProperty(xmppPropertyFullName);
		if (fullName == null)
			throw new RuntimeException("property '" + xmppPropertyFullName + "' is null at this presence packet: "
					+ packet);
		userMetadata.setFullName(fullName.toString());
	}


	// TODO: get xmppPropertyFullName from class XmppNetwork
	public void setXmppPropertyFullName(String xmppPropertyFullName) {
		this.xmppPropertyFullName = xmppPropertyFullName;
	}

}
