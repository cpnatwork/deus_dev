package deus.core.access.transfer.plugins.xmpp;

import org.jivesoftware.smack.packet.IQ;

public class PatchPacket extends IQ {

	public PatchPacket(Object change) {
		// TODO: do XML binding, have a look at http://www.igniterealtime.org/builds/smack/docs/latest/documentation/providers.html first
	}
	
	@Override
	public String getChildElementXML() {
		return "<PatchPacket/>";
	}

}
