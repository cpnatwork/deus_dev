package deus.nsi.xmpp.subscriber.impl.skeleton;

import deus.model.user.UserMetadata;
import deus.model.user.id.XmppUserId;
import deus.nsi.xmpp.common.DelegateToPacketListenerSkeleton;

public class XmppSubscriberSkeleton extends DelegateToPacketListenerSkeleton {

	public XmppSubscriberSkeleton(UserMetadata<XmppUserId> userMetadata) {
		super(userMetadata);
	}

	
}
