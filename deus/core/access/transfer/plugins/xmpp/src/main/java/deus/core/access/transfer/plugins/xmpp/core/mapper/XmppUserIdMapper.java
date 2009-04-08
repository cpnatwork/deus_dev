package deus.core.access.transfer.plugins.xmpp.core.mapper;

import org.springframework.beans.factory.annotation.Autowired;

import deus.core.access.transfer.common.protocol.TransferId;
import deus.core.access.transfer.common.protocol.mapper.UserIdMapper;
import deus.core.access.transfer.plugins.xmpp.common.XmppServerConnectionConfiguration;
import deus.core.access.transfer.plugins.xmpp.core.protocol.XmppTransferId;
import deus.model.common.user.id.UserId;

public class XmppUserIdMapper implements UserIdMapper {

	@Autowired
	private XmppServerConnectionConfiguration xmppServerConnectionConfiguration;
	
	@Override
	public TransferId resolveLocal(UserId userId) {
		return new XmppTransferId(userId.getUsername(), xmppServerConnectionConfiguration.getLocalXmppServerAddress());
	}


	@Override
	public TransferId resolveRemote(UserId userId) {
		// FIXME: Implement this by using discovery
		// it should stay here, but maybe use discovery helper classes from transfer-core

		return null;
	}

}
