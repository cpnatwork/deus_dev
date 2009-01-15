package deus.nsi.xmpp.subscriber.impl.skeleton;

import deus.nsi.xmpp.common.DelegateToPacketListenerSkeleton;
import deus.nsi.xmpp.common.XmppAccount;

public class XmppSubscriberSkeleton extends DelegateToPacketListenerSkeleton {

	public XmppSubscriberSkeleton(XmppAccount subscriberXmppAccount) {
		super(subscriberXmppAccount);
	}
	
}
