package deus.nsi.xmpp.common;

import org.jivesoftware.smack.ConnectionConfiguration;
import org.jivesoftware.smack.XMPPConnection;
import org.springframework.beans.factory.annotation.Required;

import deus.model.user.UserMetadata;
import deus.model.user.id.XmppUserId;
import deus.nsi.xmpp.common.impl.XmppConversationImpl;


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


	public XmppConversation login(UserMetadata<XmppUserId> userMetadata, String password) {
		XmppUserId xmppUserId = userMetadata.getUserId();

		// connect to the XMPP account of the subscriber.
		ConnectionConfiguration connectionConfiguration = new ConnectionConfiguration(xmppUserId.getServer());
		connectionConfiguration.setCompressionEnabled(configuration.isCompression());
		connectionConfiguration.setSASLAuthenticationEnabled(configuration.isSaslAuthentication());
		connectionConfiguration.setSecurityMode(configuration.getSecurityMode());

		XMPPConnection connection = new XMPPConnection(connectionConfiguration);
		
		XmppConversationImpl xmppConversation = new XmppConversationImpl(connection, userMetadata, password);
		xmppConversation.setXmppPropertyFullName(xmppPropertyFullName);
		return xmppConversation;
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
