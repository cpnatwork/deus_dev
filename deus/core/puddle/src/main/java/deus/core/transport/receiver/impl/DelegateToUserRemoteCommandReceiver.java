package deus.core.transport.receiver.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import deus.core.soul.User;
import deus.core.soul.UserRegistry;
import deus.core.transport.command.Command;
import deus.core.transport.id.TransportId;
import deus.core.transport.receiver.RemoteCommandReceiver;

@Component
public class DelegateToUserRemoteCommandReceiver implements RemoteCommandReceiver {

	@Autowired
	private UserRegistry userRegistry;

	@Override
	public void receive(Command command, TransportId senderTid, TransportId receiverTid) {
		User user = userRegistry.getOrCreateTemporaryUser(command.getReceiverId());
		
		// FIXME: implement
	}
	
}
