package deus.nsi.xmpp.subscriber.impl.skeleton.packetlistener;

import deus.core.subscriber.RemoteCalledSubscriber;
import deus.nsi.xmpp.common.packetlistener.UserMetadataParsingFilteredPacketListener;


abstract class SubscriberPacketListener extends UserMetadataParsingFilteredPacketListener {

	protected RemoteCalledSubscriber subscriber;


	public void setRemoteCalledSubscriber(RemoteCalledSubscriber subscriber) {
		this.subscriber = subscriber;
	}

}
