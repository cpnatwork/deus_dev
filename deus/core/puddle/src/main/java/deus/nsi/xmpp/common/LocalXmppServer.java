package deus.nsi.xmpp.common;

import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.ConnectionConfiguration.SecurityMode;

import deus.model.user.id.XmppUserId;

public class LocalXmppServer {

	private final LocalXmppServerConnectionConfiguration configuration;


	public LocalXmppServer() {
		configuration = new LocalXmppServerConnectionConfiguration();
		// TODO: make default configuration configurable
		configuration.setEnableCompression(false);
		configuration.setEnableSaslAuthentication(false);
		configuration.setSecurityMode(SecurityMode.disabled);
	}


	public LocalXmppServer(LocalXmppServerConnectionConfiguration configuration) {
		this.configuration = configuration;
	}


	public XMPPConnection login(XmppUserId xmppUserId) {
		// connect to the XMPP account of the subscriber.
		XMPPConnection connection = new XMPPConnection(xmppUserId.getServer());
		try {
			connection.connect();
		}
		catch (XMPPException e) {
			// if the subscriber XMPP server is not available, something fatal went wrong!
			throw new RuntimeException("the local XMPP server of the user " + xmppUserId + " is not available", e);
		}

		try {
			// FIXME: what to do with password?
			connection.login(xmppUserId.getUsername(), "password");
		}
		catch (XMPPException e) {
			// if the the user cannot be logged in his local XMPP server, something fatal went wrong!
			throw new RuntimeException("the XMPP user " + xmppUserId + " cannot be logged in his local XMPP server", e);
		}

		return connection;
	}
}
