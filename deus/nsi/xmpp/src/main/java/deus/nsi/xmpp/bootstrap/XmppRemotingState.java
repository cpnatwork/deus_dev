package deus.nsi.xmpp.bootstrap;

import deus.nsi.xmpp.common.XmppConversation;
import deus.nsi.xmpp.publisher.impl.skeleton.XmppPublisherSkeleton;
import deus.nsi.xmpp.subscriber.impl.skeleton.XmppSubscriberSkeleton;
import deus.remoting.initializerdestroyer.impl.AbstractRemotingState;

public class XmppRemotingState extends AbstractRemotingState {

	private final XmppConversation xmppConversation;

	private XmppSubscriberSkeleton xmppSubscriberSkeleton;
	private XmppPublisherSkeleton xmppPublisherSkeleton;


	public XmppRemotingState(XmppConversation xmppConversation) {
		this.xmppConversation = xmppConversation;
	}


	@Override
	public boolean isRemotingAvailable() {
		return xmppConversation.isStarted();
	}


	public XmppConversation getXmppConversation() {
		return xmppConversation;
	}


	public XmppSubscriberSkeleton getXmppSubscriberSkeleton() {
		return xmppSubscriberSkeleton;
	}


	public void setXmppSubscriberSkeleton(XmppSubscriberSkeleton xmppSubscriberSkeleton) {
		this.xmppSubscriberSkeleton = xmppSubscriberSkeleton;
	}


	public XmppPublisherSkeleton getXmppPublisherSkeleton() {
		return xmppPublisherSkeleton;
	}


	public void setXmppPublisherSkeleton(XmppPublisherSkeleton xmppPublisherSkeleton) {
		this.xmppPublisherSkeleton = xmppPublisherSkeleton;
	}


	public void removeXmppSubscriberSkeleton() {
		xmppSubscriberSkeleton = null;
	}


	public void removeXmppPublisherSkeleton() {
		xmppPublisherSkeleton = null;
	}

}
