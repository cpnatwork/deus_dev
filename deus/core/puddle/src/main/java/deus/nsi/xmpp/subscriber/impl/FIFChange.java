package deus.nsi.xmpp.subscriber.impl;

import org.jivesoftware.smack.packet.IQ;

public class FIFChange extends IQ {

	public FIFChange(Object change) {
		// TODO: do XML binding
	}
	
	@Override
	public String getChildElementXML() {
		return "<FIFChange/>";
	}

}
