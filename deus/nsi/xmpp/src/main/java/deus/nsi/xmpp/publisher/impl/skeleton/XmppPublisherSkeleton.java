package deus.nsi.xmpp.publisher.impl.skeleton;

import deus.nsi.xmpp.common.DelegateToPacketListenerSkeleton;
import deus.nsi.xmpp.common.XmppConversation;

/**
 * 
 * @author Florian Rampp (Florian.Rampp@informatik.stud.uni-erlangen.de)
 *
 */
public class XmppPublisherSkeleton extends DelegateToPacketListenerSkeleton {

	public XmppPublisherSkeleton(XmppConversation publisherXmppConversation) {
		super(publisherXmppConversation);
	}

		
}
