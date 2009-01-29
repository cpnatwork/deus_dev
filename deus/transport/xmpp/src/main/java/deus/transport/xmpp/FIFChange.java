package deus.transport.xmpp;

import org.jivesoftware.smack.packet.IQ;

public class FIFChange extends IQ {

	public FIFChange(Object change) {
		// TODO: do XML binding, have a look at http://www.igniterealtime.org/builds/smack/docs/latest/documentation/providers.html first
	}
	
	@Override
	public String getChildElementXML() {
		return "<FIFChange/>";
	}

}
