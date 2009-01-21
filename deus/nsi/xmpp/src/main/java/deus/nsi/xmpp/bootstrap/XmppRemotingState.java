package deus.nsi.xmpp.bootstrap;

import java.util.List;

import deus.core.publisher.PublisherStub;
import deus.core.subscriber.SubscriberStub;
import deus.model.user.id.UserIdType;
import deus.nsi.xmpp.common.XmppConversation;
import deus.nsi.xmpp.common.XmppSkeleton;
import deus.remoting.initializerdestroyer.RemotingState;

public class XmppRemotingState implements RemotingState {

	private final XmppConversation xmppConversation;

	private List<XmppSkeleton> connectedXmppSkeletons;

	public XmppRemotingState(XmppConversation xmppConversation) {
		this.xmppConversation = xmppConversation;
	}


	@Override
	public boolean isRemotingAvailable() {
		return xmppConversation.isStarted();
	}


	@Override
	public UserIdType getUserIdType() {
		return UserIdType.xmpp;
	}
	
	
	public XmppConversation getXmppConversation() {
		return xmppConversation;
	}


	public void addConnectedXmppSkeleton(XmppSkeleton xmppSkeleton) {
		connectedXmppSkeletons.add(xmppSkeleton);
	}
	
	public List<XmppSkeleton> getAllConnectedXmppSkeletons() {
		return connectedXmppSkeletons;
	}


	public void clearSkeletonList() {
		connectedXmppSkeletons.clear();
	}


	
}
