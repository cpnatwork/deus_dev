package deus.nsi.xmpp.publisher.impl.skeleton;

import deus.core.publisher.RemoteCalledPublisher;
import deus.model.user.id.XmppUserId;
import deus.nsi.xmpp.common.packetfilter.UserMetadataParsingFilteredPacketListener;

abstract class PublisherPacketListener extends UserMetadataParsingFilteredPacketListener {

	protected final RemoteCalledPublisher<XmppUserId> publisher;

	
	public PublisherPacketListener(RemoteCalledPublisher<XmppUserId> publisher) {
		this.publisher = publisher;
	}
	
}
