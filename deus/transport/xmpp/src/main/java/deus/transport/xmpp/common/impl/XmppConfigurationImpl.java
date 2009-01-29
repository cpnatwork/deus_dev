package deus.transport.xmpp.common.impl;

import deus.transport.xmpp.common.XmppConfiguration;

public class XmppConfigurationImpl implements XmppConfiguration {

	private String xmppPropertyFullName;


	@Override
	public String getXmppPropertyFullName() {
		return xmppPropertyFullName;
	}


	public void setXmppPropertyFullName(String xmppPropertyFullName) {
		this.xmppPropertyFullName = xmppPropertyFullName;
	}

}
