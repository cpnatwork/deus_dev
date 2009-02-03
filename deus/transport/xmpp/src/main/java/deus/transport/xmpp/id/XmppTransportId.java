package deus.transport.xmpp.id;

import deus.core.transport.core.protocol.TransportId;

public class XmppTransportId implements TransportId {

	private String xmppUsername;
	private String xmppServer;


	public XmppTransportId() {
	}


	public XmppTransportId(String xmppUsername, String xmppServer) {
		super();
		this.xmppUsername = xmppUsername;
		this.xmppServer = xmppServer;
	}


	public String getXmppUsername() {
		return xmppUsername;
	}


	public void setXmppUsername(String xmppUsername) {
		this.xmppUsername = xmppUsername;
	}


	public String getXmppServer() {
		return xmppServer;
	}


	public void setXmppServer(String xmppServer) {
		this.xmppServer = xmppServer;
	}


	@Override
	public String toString() {
		return xmppUsername + "@" + xmppServer;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((xmppServer == null) ? 0 : xmppServer.hashCode());
		result = prime * result + ((xmppUsername == null) ? 0 : xmppUsername.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		XmppTransportId other = (XmppTransportId) obj;
		if (xmppServer == null) {
			if (other.xmppServer != null)
				return false;
		}
		else if (!xmppServer.equals(other.xmppServer))
			return false;
		if (xmppUsername == null) {
			if (other.xmppUsername != null)
				return false;
		}
		else if (!xmppUsername.equals(other.xmppUsername))
			return false;
		return true;
	}

}
