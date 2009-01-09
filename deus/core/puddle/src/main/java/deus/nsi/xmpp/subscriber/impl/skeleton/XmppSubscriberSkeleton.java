package deus.nsi.xmpp.subscriber.impl.skeleton;

import deus.model.pub.SubscriberMetadata;
import deus.model.user.id.XmppUserId;
import deus.nsi.xmpp.common.DelegateToPacketListenerSkeleton;

public class XmppSubscriberSkeleton extends DelegateToPacketListenerSkeleton {

	public XmppSubscriberSkeleton(SubscriberMetadata<XmppUserId> subscriberMetadata) {
		super(subscriberMetadata);
	}

	
}
