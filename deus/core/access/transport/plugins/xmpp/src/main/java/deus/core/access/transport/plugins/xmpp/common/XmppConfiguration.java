package deus.core.access.transport.plugins.xmpp.common;

public class XmppConfiguration {

	private String xmppPropertyFullName;

	private String xmppPropertySenderId;

	private String xmppPropertyReceiverId;


	public String getXmppPropertyFullName() {
		return xmppPropertyFullName;
	}


	public void setXmppPropertyFullName(String xmppPropertyFullName) {
		this.xmppPropertyFullName = xmppPropertyFullName;
	}


	public String getXmppPropertySenderId() {
		return xmppPropertySenderId;
	}


	public void setXmppPropertySenderId(String xmppPropertySenderId) {
		this.xmppPropertySenderId = xmppPropertySenderId;
	}


	public String getXmppPropertyReceiverId() {
		return xmppPropertyReceiverId;
	}


	public void setXmppPropertyReceiverId(String xmppPropertyReceiverId) {
		this.xmppPropertyReceiverId = xmppPropertyReceiverId;
	}

}
