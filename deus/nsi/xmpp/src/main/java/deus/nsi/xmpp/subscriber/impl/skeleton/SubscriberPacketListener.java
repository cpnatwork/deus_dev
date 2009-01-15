package deus.nsi.xmpp.subscriber.impl.skeleton;

import deus.core.subscriber.Subscriber;
import deus.model.user.id.XmppUserId;
import deus.nsi.xmpp.common.packetfilter.UserMetadataParsingFilteredPacketListener;


abstract class SubscriberPacketListener extends UserMetadataParsingFilteredPacketListener {

	protected final Subscriber<XmppUserId> subscriber;


	public SubscriberPacketListener(Subscriber<XmppUserId> subscriber) {
		super();
		this.subscriber = subscriber;
	}

}
