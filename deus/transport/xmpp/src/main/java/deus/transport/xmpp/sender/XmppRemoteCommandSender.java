package deus.transport.xmpp.sender;

import org.jivesoftware.smack.packet.Presence;
import org.springframework.beans.factory.annotation.Autowired;

import deus.core.transport.command.Command;
import deus.core.transport.command.DenySubscriptionCommand;
import deus.core.transport.command.GrantSubscriptionCommand;
import deus.core.transport.command.RequestSubscriptionCommand;
import deus.core.transport.command.SubscribeCommand;
import deus.core.transport.command.UnsubscribeCommand;
import deus.core.transport.connectionstate.ConnectionStateRegistry;
import deus.core.transport.id.TransportId;
import deus.core.transport.sender.RemoteCommandSender;
import deus.transport.xmpp.common.XmppConversation;
import deus.transport.xmpp.connectionstate.XmppConnectionState;
import deus.transport.xmpp.id.XmppTransportId;

public class XmppRemoteCommandSender implements RemoteCommandSender {

	@Autowired
	private ConnectionStateRegistry connectionStateRegistry;
	
	@Override
	public void send(Command command, TransportId senderTid, TransportId receiverTid) {
		XmppConnectionState state = (XmppConnectionState)connectionStateRegistry.getConnectionState(senderTid);
		if(!state.isConnectionEstablished())
			throw new IllegalStateException("XMPP connection is not established!");
		
		XmppTransportId senderJid = (XmppTransportId)senderTid;
		XmppTransportId receiverJid = (XmppTransportId)receiverTid;
		
		
		XmppConversation xmppConversation = state.getXmppConversation();
		
		// USE CASE: SUBSCRIBE
		if(command instanceof SubscribeCommand) {
			if(command instanceof RequestSubscriptionCommand) {
				// TODO: implement this method properly
				// Roster roster = subscriberXmppConversation.getRoster();

				// roster.createEntry(publisherJid.toString(), getPublisherMetadata().getFullName(), null);

				Presence presencePacket = new Presence(Presence.Type.subscribe);
				xmppConversation.sendPacket(presencePacket, receiverJid);
			}
			else if(command instanceof GrantSubscriptionCommand) {
				// TODO: implement
			}
			else if(command instanceof DenySubscriptionCommand) {
				// TODO: implement
			}
			else 
				throw new IllegalArgumentException("cannot handle command " + command);
			
		}
		// USE CASE: UNSUBSCRIBE
		else if(command instanceof UnsubscribeCommand) {
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
