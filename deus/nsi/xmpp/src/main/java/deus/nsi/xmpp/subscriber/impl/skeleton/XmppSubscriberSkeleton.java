package deus.nsi.xmpp.subscriber.impl.skeleton;

import deus.nsi.xmpp.common.DelegateToPacketListenerSkeleton;
import deus.nsi.xmpp.common.XmppConversation;

public class XmppSubscriberSkeleton extends DelegateToPacketListenerSkeleton {

	public XmppSubscriberSkeleton(XmppConversation subscriberXmppConversation) {
		super(subscriberXmppConversation);
	}
	
}
