package deus.nsi.xmpp.common;

import org.jivesoftware.smack.ConnectionConfiguration;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;
import org.springframework.beans.factory.annotation.Required;

import deus.model.user.UserMetadata;
import deus.model.user.id.XmppUserId;


/**
 * Creates connections to XMPP accounts by using the <code>login</code> method. A configuration for the connection to
 * the server can be set.
 * 
 * @author Florian Rampp (Florian.Rampp@informatik.stud.uni-erlangen.de)
 * 
 */
public class XmppNetwork {

	private XmppServerConnectionConfiguration configuration;

	// / property name of XMPP property 'fullName'
	private String xmppPropertyFullName;


	public XmppAccount login(UserMetadata<XmppUserId> userMetadata, String password) {
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
			connection.login(xmppUserId.getUsername(), password);
		}
		catch (XMPPException e) {
			// if the the user cannot be logged in his local XMPP server, something fatal went wrong!
			throw new RuntimeException("the XMPP user " + xmppUserId + " cannot be logged in his local XMPP server", e);
		}

		XmppAccount xmppAccount = new XmppAccount(connection, userMetadata);
		xmppAccount.setXmppPropertyFullName(xmppPropertyFullName);
		return xmppAccount;
	}


	@Required
	public void setXmppPropertyNameFromFullName(String xmppPropertyNameFromFullName) {
		this.xmppPropertyFullName = xmppPropertyNameFromFullName;
	}

	@Required
	public void setXmppServerConnectionConfiguration(XmppServerConnectionConfiguration configuration) {
		this.configuration = configuration;
	}

}
