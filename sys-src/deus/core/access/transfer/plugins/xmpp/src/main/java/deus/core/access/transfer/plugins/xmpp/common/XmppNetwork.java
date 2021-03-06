package deus.core.access.transfer.plugins.xmpp.common;

import org.jivesoftware.smack.ConnectionConfiguration;
import org.jivesoftware.smack.XMPPConnection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import deus.core.access.transfer.plugins.xmpp.common.impl.XmppConversationImpl;
import deus.core.access.transfer.plugins.xmpp.core.protocol.XmppTransferId;


/**
 * Creates connections to XMPP accounts by using the <code>login</code> method. A configuration for the connection to
 * the server can be set.
 * 
 * @author Florian Rampp (Florian.Rampp@informatik.stud.uni-erlangen.de)
 * 
 */
@Component
public class XmppNetwork {

	@Autowired
	private XmppServerConnectionConfiguration configuration;


	public XmppConversation createConversation(XmppTransferId xmppTransferId, String password) {
		// connect to the XMPP account of the informationConsumer.
		ConnectionConfiguration connectionConfiguration = new ConnectionConfiguration(xmppTransferId.getXmppServer());
		connectionConfiguration.setCompressionEnabled(configuration.isCompression());
		connectionConfiguration.setSASLAuthenticationEnabled(configuration.isSaslAuthentication());
		connectionConfiguration.setSecurityMode(configuration.getSecurityMode());

		XMPPConnection connection = new XMPPConnection(connectionConfiguration);

		XmppConversation xmppConversation = new XmppConversationImpl(connection, xmppTransferId, password);
		return xmppConversation;
	}

}
