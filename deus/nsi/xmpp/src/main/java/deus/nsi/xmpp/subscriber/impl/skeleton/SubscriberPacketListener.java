package deus.nsi.xmpp.subscriber.impl.skeleton;

import deus.core.subscriber.Subscriber;
import deus.model.user.id.XmppUserId;
import deus.nsi.xmpp.common.packetfilter.UserMetadataParsingFilteredPacketListener;


abstract class SubscriberPacketListener<DifContentType> extends UserMetadataParsingFilteredPacketListener {

	protected final Subscriber<XmppUserId, DifContentType> subscriber;


	public SubscriberPacketListener(Subscriber<XmppUserId, DifContentType> subscriber) {
		super();
		this.subscriber = subscriber;
	}

}
