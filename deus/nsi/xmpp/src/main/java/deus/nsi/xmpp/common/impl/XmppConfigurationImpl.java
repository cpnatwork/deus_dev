package deus.nsi.xmpp.common.impl;

import deus.nsi.xmpp.common.XmppConfiguration;

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
