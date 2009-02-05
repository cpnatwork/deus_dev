package deus.core.access.transport.plugins.xmpp.common;

import org.jivesoftware.smack.PacketListener;
import org.jivesoftware.smack.filter.PacketFilter;

/**
 * Classes that implement this interface return a packet listener, which listens to XMPP packets, which are first filtered by the
 * filter, that can also be retrieved by this class.
 * 
 * This class basically encapsulates a <code>PacketFilter</code> with the associated <code>PacketListener</code>. 
 * 
 * @author Florian Rampp (Florian.Rampp@informatik.stud.uni-erlangen.de)
 *
 */
public interface FilteredPacketListener {

	/**
	 * Returns the <code>PacketFilter</code> that should be applied to incoming XMPP packets, before
	 * they are processed by the associated <code>PacketListener</code>.
	 * @return
	 */
	public PacketFilter getFilter();
	
	/**
	 * Returns the <code>PacketListener</code> which handles the XMPP packets after they were filtered by the
	 * associated <code>PacketFilter</code>.
	 * @return
	 */
	public PacketListener getPacketListener();
	
}
