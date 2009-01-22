package deus.nsi.xmpp.subscriber.impl.stub;

import org.jivesoftware.smack.packet.IQ;

import deus.core.subscriber.impl.AbstractSubscriberStub;
import deus.model.pub.SubscriberMetadata;
import deus.model.sub.PublisherMetadata;
import deus.model.user.id.transportid.TransportIdType;
import deus.model.user.id.transportid.XmppTransportId;
import deus.nsi.xmpp.common.XmppConversation;
import deus.nsi.xmpp.subscriber.impl.FIFChange;
/**
 * TODO
 * 
 * This stub resides on the publisher system side and is called by the publisher subsystem.
 * 
 * 
 * @author Florian Rampp (Florian.Rampp@informatik.stud.uni-erlangen.de)
 *
 */
public class XmppSubscriberStub extends AbstractSubscriberStub {

	private final XmppConversation publisherXmppConversation;


	public XmppSubscriberStub(SubscriberMetadata subscriberMetadata, XmppConversation publisherXmppConversation) {
		super(subscriberMetadata);
		// TODO: think about this assert
		assert (subscriberMetadata.getUserId().hasTransportId(TransportIdType.xmpp));
		
		this.publisherXmppConversation = publisherXmppConversation;
	}


	@Override
	public void update(PublisherMetadata publisher, Object change) {
		IQ changeIq = new FIFChange(change);
		publisherXmppConversation.sendPacket(changeIq, getSubscriberMetadata().getUserId().getTransportId(XmppTransportId.class));
	}

}
