package deus.nsi.xmpp.publisher.impl.skeleton.packetlistener;

import deus.core.publisher.RemoteCalledPublisher;
import deus.nsi.xmpp.common.packetlistener.UserMetadataParsingFilteredPacketListener;

abstract class PublisherPacketListener extends UserMetadataParsingFilteredPacketListener {

	protected RemoteCalledPublisher publisher;

	
	public void setRemoteCalledPublisher(RemoteCalledPublisher publisher) {
		this.publisher = publisher;
	}
	
}
