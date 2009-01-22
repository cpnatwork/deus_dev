package deus.nsi.xmpp.subscriber.impl.skeleton.packetlistener;

import deus.core.subscriber.RemoteCalledSubscriber;
import deus.model.user.id.XmppUserId;
import deus.nsi.xmpp.common.packetlistener.UserMetadataParsingFilteredPacketListener;


abstract class SubscriberPacketListener<DifContentType> extends UserMetadataParsingFilteredPacketListener {

	protected final RemoteCalledSubscriber subscriber;


	public SubscriberPacketListener(RemoteCalledSubscriber subscriber) {
		super();
		this.subscriber = subscriber;
	}

}
