package deus.core.access.transport.plugins.xmpp.sending;

import org.jivesoftware.smack.packet.Presence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import deus.core.access.transport.core.connectionstate.ConnectionStateRegistry;
import deus.core.access.transport.core.messages.DenySubscriptionMessage;
import deus.core.access.transport.core.messages.GrantSubscriptionMessage;
import deus.core.access.transport.core.messages.RequestSubscriptionMessage;
import deus.core.access.transport.core.messages.SubscribeMessage;
import deus.core.access.transport.core.messages.TransportMessage;
import deus.core.access.transport.core.messages.UnsubscribeMessage;
import deus.core.access.transport.core.soul.protocol.MessageSender;
import deus.core.access.transport.plugins.xmpp.common.XmppConversation;
import deus.core.access.transport.plugins.xmpp.connectionstate.XmppConnectionState;
import deus.core.access.transport.plugins.xmpp.core.protocol.XmppTransportId;

@Component
public class XmppMessageSender implements MessageSender {

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
