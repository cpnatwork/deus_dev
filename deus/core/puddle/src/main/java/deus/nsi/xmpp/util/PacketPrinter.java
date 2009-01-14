package deus.nsi.xmpp.util;

import java.util.Collection;

import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.packet.Packet;
import org.jivesoftware.smack.packet.Presence;

public class PacketPrinter {

	public static String newLine = System.getProperty("line.separator");
	
	public String printPacket(Packet packet) {
		StringBuilder sb = new StringBuilder();
		sb.append("from: " + packet.getFrom() + newLine);
		sb.append("to: " + packet.getTo() + newLine);
		sb.append("packetId: " + packet.getPacketID() + newLine);

		sb.append("properties:" + newLine);
		Collection<String> propertyNames = packet.getPropertyNames();
		for (String propertyName : propertyNames)
			sb.append("  " + propertyName + ": " + packet.getProperty(propertyName) + newLine);


		if (packet instanceof Presence)
			printPresencePacket((Presence) packet, sb);
		else if (packet instanceof IQ)
			printIqPacket((IQ) packet, sb);
		else if (packet instanceof Message)
			printMessagePacket((Message) packet, sb);
		else
			throw new RuntimeException("packet " + packet + " of unknown type");

		return sb.toString();
	}


	private void printPresencePacket(Presence presence, StringBuilder sb) {
		sb.append("packet is Presence" + newLine);
		sb.append("  mode: " + presence.getMode() + newLine);
		sb.append("  priority: " + presence.getPriority() + newLine);
		sb.append("  status: " + presence.getStatus() + newLine);
		sb.append("  type: " + presence.getType() + newLine);
		sb.append("  available: " + presence.isAvailable() + newLine);
		sb.append("  away: " + presence.isAway());
	}


	private void printIqPacket(IQ iq, StringBuilder sb) {
		sb.append("packet is IQ" + newLine);
		sb.append("  type: " + iq.getType());
	}


	private void printMessagePacket(Message message, StringBuilder sb) {
		sb.append("packet is Message" + newLine);
		sb.append("  bodies:" + newLine);
		Collection<Message.Body> bodies = message.getBodies();
		for(Message.Body body : bodies)
			sb.append("    lang: " + body.getLanguage() + ", msg: " + body.getMessage() + newLine);
		
		sb.append("  subject: " + message.getSubject() + newLine);
		sb.append("  thread: " + message.getThread() + newLine);
		sb.append("  type: " + message.getType());
	}

}
