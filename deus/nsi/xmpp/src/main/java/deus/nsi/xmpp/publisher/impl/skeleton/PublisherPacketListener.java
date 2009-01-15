package deus.nsi.xmpp.publisher.impl.skeleton;

import deus.core.publisher.Publisher;
import deus.model.user.id.XmppUserId;
import deus.nsi.xmpp.common.packetfilter.UserMetadataParsingFilteredPacketListener;

abstract class PublisherPacketListener extends UserMetadataParsingFilteredPacketListener {

	protected final Publisher<XmppUserId> publisher;

	
	public PublisherPacketListener(Publisher<XmppUserId> publisher) {
		this.publisher = publisher;
	}
	
}
