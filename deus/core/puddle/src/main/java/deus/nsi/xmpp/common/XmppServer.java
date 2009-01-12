package deus.nsi.xmpp.common;

import org.jivesoftware.smack.ConnectionConfiguration;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;

import deus.model.user.UserMetadata;
import deus.model.user.id.XmppUserId;


/**
 * Creates connections to XMPP accounts by using the <code>login</code> method.
 * A configuration for the connection to the server can be set.
 * @author Florian Rampp (Florian.Rampp@informatik.stud.uni-erlangen.de)
 *
 */
public class XmppServer {

	private XmppServerConnectionConfiguration configuration;
	
	/// property name of XMPP property 'fullName'
	private String xmppPropertyNameFromFullName;


	public XmppAccount login(UserMetadata<XmppUserId> userMetadata) {
		XmppUserId xmppUserId = userMetadata.getUserId();

		// connect to the XMPP account of the subscriber.
		ConnectionConfiguration connectionConfiguration = new ConnectionConfiguration(xmppUserId.getServer());
		connectionConfiguration.setCompressionEnabled(configuration.isCompression());
		connectionConfiguration.setSASLAuthenticationEnabled(configuration.isSaslAuthentication());
		connectionConfiguration.setSecurityMode(configuration.getSecurityMode());

		XMPPConnection connection = new XMPPConnection(connectionConfiguration);
		try {
			connection.connect();
		}
		catch (XMPPException e) {
			// if the subscriber XMPP server is not available, something fatal went wrong!
			throw new RuntimeException("the local XMPP server of the user " + xmppUserId + " is not available", e);
		}

		try {
			// FIXME: what to do with password?
			connection.login(xmppUserId.getUsername(), "test");
		}
		catch (XMPPException e) {
			// if the the user cannot be logged in his local XMPP server, something fatal went wrong!
			throw new RuntimeException("the XMPP user " + xmppUserId + " cannot be logged in his local XMPP server", e);
		}

		return new XmppAccount(connection, userMetadata);
	}


	public void setXmppPropertyNameFromFullName(String xmppPropertyNameFromFullName) {
		this.xmppPropertyNameFromFullName = xmppPropertyNameFromFullName;
		// TODO: how to pass this to XmppAccount ?
	}


	public void setXmppServerConnectionConfiguration(XmppServerConnectionConfiguration configuration) {
		this.configuration = configuration;
	}

}
