package deus.nsi.xmpp.publisher.impl.skeleton;

import org.springframework.beans.factory.annotation.Configurable;

import deus.nsi.xmpp.common.DelegateToPacketListenerSkeleton;
import deus.nsi.xmpp.common.XmppConversation;
import deus.nsi.xmpp.publisher.impl.stub.XmppPublisherStub;

/**
 * This skeleton listens for messages to the user in the role of a publisher, which are sent by the corresponding XMPP
 * publisher stub. There is only one <code>XmppPublisherSkeleton</code> per user, since it listens to messages
 * from all sources.
 * 
 * It is only used for listening to messages, no messages can be sent. A stub is needed for sending messages.
 * 
 * It expects a started XMPP conversation with the XMPP account of the publisher as constructor parameter, which is
 * used by the skeleton to add packet listeners to the XMPP connection.
 * 
 * This skeleton resides on the publisher system side. 
 * 
 * 
 * @see XmppPublisherStub
 * @see XmppConversation
 * 
 * @author Florian Rampp (Florian.Rampp@informatik.stud.uni-erlangen.de)
 * 
 */
@Configurable
public class XmppPublisherSkeleton extends DelegateToPacketListenerSkeleton {

	public XmppPublisherSkeleton(XmppConversation publisherXmppConversation) {
		super(publisherXmppConversation);
	}


}
