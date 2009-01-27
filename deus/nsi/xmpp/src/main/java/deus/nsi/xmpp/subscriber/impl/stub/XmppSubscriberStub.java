package deus.nsi.xmpp.subscriber.impl.stub;

import org.jivesoftware.smack.packet.IQ;

import deus.core.subscriber.stub.impl.AbstractSubscriberStub;
import deus.model.dossier.generic.ForeignInformationFile;
import deus.model.sub.PublisherMetadata;
import deus.model.user.id.UserId;
import deus.model.user.transportid.TransportIdType;
import deus.model.user.transportid.XmppTransportId;
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


	public XmppSubscriberStub(UserId subscriberId, XmppConversation publisherXmppConversation) {
		super(subscriberId);
		// TODO: think about this assert
		assert (subscriberId.hasTransportId(TransportIdType.xmpp));

		this.publisherXmppConversation = publisherXmppConversation;
	}


	@Override
	public void update(PublisherMetadata publisher, ForeignInformationFile change) {
		IQ changeIq = new FIFChange(change);
		publisherXmppConversation.sendPacket(changeIq, getSubscriberId().getTransportId(
				XmppTransportId.class));
	}


	@Override
	public void acknowledgeSubscription(PublisherMetadata publisherMetadata) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void denySubscription(PublisherMetadata publisherMetadata) {
		// TODO Auto-generated method stub
		
	}

}
