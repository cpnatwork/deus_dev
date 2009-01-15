import org.jivesoftware.smack.Chat;
import org.jivesoftware.smack.ConnectionConfiguration;
import org.jivesoftware.smack.MessageListener;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.ConnectionConfiguration.SecurityMode;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.packet.Presence;
import org.jivesoftware.smack.packet.Presence.Type;

import deus.nsi.xmpp.subscriber.impl.FIFChange;

public class XmppTest {

	public static void main(String[] args) throws XMPPException {
		XMPPConnection.DEBUG_ENABLED = true;
		
		ConnectionConfiguration config = new ConnectionConfiguration("faui6p15", 5222);
		config.setCompressionEnabled(false);
		config.setSASLAuthenticationEnabled(false);
		config.setRosterLoadedAtLogin(false);
		config.setSecurityMode(SecurityMode.disabled);
		config.setSendPresence(false);
		
		XMPPConnection connection = new XMPPConnection(config);
		connection.connect();
		connection.login("testuser", "test", "faui6s15");
		Chat chat = connection.getChatManager().createChat("siflramp@faui6p15", new MessageListener() {

			public void processMessage(Chat chat, Message message) {
				System.out.println("Received message: " + message);
			}
		});
		
		IQ changeIq = new FIFChange(null);
		connection.sendPacket(changeIq);
		
		Presence presence = new Presence(Type.subscribe);
		connection.sendPacket(presence);
	}

}
