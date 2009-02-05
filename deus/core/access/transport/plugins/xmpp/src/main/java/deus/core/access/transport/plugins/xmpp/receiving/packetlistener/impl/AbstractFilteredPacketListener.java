package deus.core.access.transport.plugins.xmpp.receiving.packetlistener.impl;

import org.jivesoftware.smack.PacketListener;
import org.jivesoftware.smack.filter.PacketFilter;
import org.jivesoftware.smack.packet.Packet;

import deus.core.access.transport.plugins.xmpp.common.FilteredPacketListener;


/**
 * Abstract template class, that makes it easier to implement a <code>FilteredPacketListener</code>. When inheriting
 * from this class, only the two methods <code>accept</code> and <code>processPacket</code> have to be implemented. No
 * new instances of the classes <code>PacketFilter</code> and <code>PacketListener</code> have to be generated.
 * 
 * @author Florian Rampp (Florian.Rampp@informatik.stud.uni-erlangen.de)
 * 
 */
public abstract class AbstractFilteredPacketListener implements FilteredPacketListener {


	/**
	 * If it is easier to return a <code>PacketFilter</code> instead of implementing the method <code>accept</code>,
	 * overwrite this method and just implement <code>accept</code> by throwing an
	 * <code>UnsupportedOperationException</code>.
	 * 
	 */
	@Override
	public PacketFilter getFilter() {
		return new PacketFilter() {

			@Override
			public boolean accept(Packet packet) {
				return AbstractFilteredPacketListener.this.accept(packet);
			}

		};
	}


	/**
	 * This method decides, if the given packet will be accepted and processed by the method <code>processPacket</code>.
	 * 
	 * Implement this method to restrict the type of packages that are processed by this class.
	 * 
	 * @param packet
	 *            the packet, which should be checked
	 * @return true, if this packet should be processed by the method <code>processPacket</code>
	 * 
	 * @see AbstractFilteredPacketListener#getFilter()
	 */
	protected boolean accept(Packet packet) {
		throw new UnsupportedOperationException("accept not implemented! Either implement this method or getFilter()");
	}


	@Override
	public final PacketListener getPacketListener() {
		return new PacketListener() {

			@Override
			public void processPacket(Packet packet) {
				AbstractFilteredPacketListener.this.processPacket(packet);
			}

		};

	}


	/**
	 * If the packet is accepted by the method <code>accept</code>, it is processed by this method.
	 * 
	 * Implement this method to handle the packet.
	 * 
	 * @param packet
	 *            the packet to be processed.
	 */
	protected abstract void processPacket(Packet packet);

}
