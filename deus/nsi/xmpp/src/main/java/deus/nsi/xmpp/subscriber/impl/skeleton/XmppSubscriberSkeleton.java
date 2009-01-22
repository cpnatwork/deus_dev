package deus.nsi.xmpp.subscriber.impl.skeleton;

import deus.nsi.xmpp.common.DelegateToPacketListenerSkeleton;
import deus.nsi.xmpp.common.XmppConversation;
import deus.nsi.xmpp.subscriber.impl.stub.XmppSubscriberStub;

/**
 * This skeleton listens for messages to the user in the role of a subscriber, which are sent by the corresponding XMPP
 * subscriber stub. There is only one <code>XmppSubscriberSkeleton</code> per user, since it listens to messages
 * from all sources.
 * 
 * It is only used for listening to messages, no messages can be sent. A stub is needed for sending messages.
 * 
 * It expects a started XMPP conversation with the XMPP account of the subscriber as constructor parameter, which is
 * used by the skeleton to add packet listeners to the XMPP connection.
 * 
 * This skeleton resides on the subscriber system side.
 * 
 * 
 * @see XmppSubscriberStub
 * @see XmppConversation
 * 
 * @author Florian Rampp (Florian.Rampp@informatik.stud.uni-erlangen.de)
 * 
 */
public class XmppSubscriberSkeleton extends DelegateToPacketListenerSkeleton {

	public XmppSubscriberSkeleton(XmppConversation subscriberXmppConversation) {
		super(subscriberXmppConversation);
	}

}
