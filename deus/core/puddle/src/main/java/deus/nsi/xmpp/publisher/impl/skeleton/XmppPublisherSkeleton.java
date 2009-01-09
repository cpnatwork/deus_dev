package deus.nsi.xmpp.publisher.impl.skeleton;

import deus.model.user.UserMetadata;
import deus.model.user.id.XmppUserId;
import deus.nsi.xmpp.common.DelegateToPacketListenerSkeleton;

/**
 * 
 * @author Florian Rampp (Florian.Rampp@informatik.stud.uni-erlangen.de)
 *
 */
public class XmppPublisherSkeleton extends DelegateToPacketListenerSkeleton {

	public XmppPublisherSkeleton(UserMetadata<XmppUserId> userMetadata) {
		super(userMetadata);
	}

		
}
