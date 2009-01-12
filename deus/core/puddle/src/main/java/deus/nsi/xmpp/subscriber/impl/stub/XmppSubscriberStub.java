package deus.nsi.xmpp.subscriber.impl.stub;

import org.jivesoftware.smack.packet.IQ;

import deus.core.subscriber.impl.AbstractSubscriberStub;
import deus.model.pub.SubscriberMetadata;
import deus.model.sub.PublisherMetadata;
import deus.model.user.id.UserIdType;
import deus.model.user.id.XmppUserId;
import deus.nsi.xmpp.common.XmppAccount;
import deus.nsi.xmpp.subscriber.impl.FIFChange;

public class XmppSubscriberStub extends AbstractSubscriberStub<XmppUserId> {

	private final XmppAccount publisherXmppAccount;


	public XmppSubscriberStub(SubscriberMetadata<XmppUserId> subscriberMetadata, XmppAccount publisherXmppAccount) {
		super(subscriberMetadata);
		assert (subscriberMetadata.getUserId().getType().equals(UserIdType.xmpp));
		this.publisherXmppAccount = publisherXmppAccount;
	}


	@Override
	public void update(PublisherMetadata<XmppUserId> publisher, Object change) {
		IQ changeIq = new FIFChange(change);
		publisherXmppAccount.sendPacket(changeIq, getSubscriberMetadata().getUserId());
	}

}
