package deus.transport.xmpp.sender;

import org.jivesoftware.smack.packet.Presence;
import org.springframework.beans.factory.annotation.Autowired;

import deus.core.transport.connectionstate.ConnectionStateRegistry;
import deus.core.transport.message.DenySubscriptionMessage;
import deus.core.transport.message.GrantSubscriptionMessage;
import deus.core.transport.message.TransportMessage;
import deus.core.transport.message.RequestSubscriptionMessage;
import deus.core.transport.message.SubscribeMessage;
import deus.core.transport.message.UnsubscribeMessage;
import deus.core.transport.message.sender.MessageSender;
import deus.transport.xmpp.common.XmppConversation;
import deus.transport.xmpp.connectionstate.XmppConnectionState;
import deus.transport.xmpp.id.XmppTransportId;

public class XmppRemoteCommandSender implements MessageSender {

	@Autowired
	private ConnectionStateRegistry connectionStateRegistry;
	
	@Override
	public void send(TransportMessage command) {
		XmppTransportId senderJid = (XmppTransportId)command.getSenderTid();
		XmppTransportId receiverJid = (XmppTransportId)command.getReceiverTid();
		
		XmppConnectionState state = (XmppConnectionState)connectionStateRegistry.getConnectionState(senderJid);
		if(!state.isConnectionEstablished())
			throw new IllegalStateException("XMPP connection is not established!");
		
		
		XmppConversation xmppConversation = state.getXmppConversation();
		
		// USE CASE: SUBSCRIBE
		if(command instanceof SubscribeMessage) {
			if(command instanceof RequestSubscriptionMessage) {
				// TODO: implement this method properly
				// Roster roster = subscriberXmppConversation.getRoster();

				// roster.createEntry(publisherJid.toString(), getPublisherMetadata().getFullName(), null);

				Presence presencePacket = new Presence(Presence.Type.subscribe);
				xmppConversation.sendPacket(presencePacket, receiverJid);
			}
			else if(command instanceof GrantSubscriptionMessage) {
				// TODO: implement
			}
			else if(command instanceof DenySubscriptionMessage) {
				// TODO: implement
			}
			else 
				throw new IllegalArgumentException("cannot handle command " + command);
			
		}
		// USE CASE: UNSUBSCRIBE
		else if(command instanceof UnsubscribeMessage) {
			// TODO: implement this method properly
			// Roster roster = subscriberXmppConversation.getRoster();

			// roster.removeEntry(roster.getEntry(publisherJid.toString()));

			Presence presencePacket = new Presence(Presence.Type.unsubscribe);
			xmppConversation.sendPacket(presencePacket, receiverJid);
		}
		else {
			throw new IllegalArgumentException("cannot handle command " + command);
		}
	}

}
