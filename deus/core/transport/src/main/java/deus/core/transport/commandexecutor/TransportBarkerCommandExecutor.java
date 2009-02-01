package deus.core.transport.commandexecutor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import deus.core.soul.common.BarkerCommandExecutor;
import deus.core.transport.message.DenySubscriptionMessage;
import deus.core.transport.message.GrantSubscriptionMessage;
import deus.core.transport.message.TransportMessage;
import deus.model.user.id.UserId;

// TODO: think about common superclass of command executors, with methods to retrieve MessageSender (see old TransportProtocolDiscoveryCommandExecutor)
@Component
public class TransportBarkerCommandExecutor implements BarkerCommandExecutor {

	@Autowired
	private TransportMessageSenderHelper transportMessageSenderHelper;

	@Override
	public void denySubscription(UserId subscriberId, UserId publisherId) {
		TransportMessage transportMessage = new DenySubscriptionMessage();
		transportMessageSenderHelper.send(subscriberId, publisherId, transportMessage);
	}


	@Override
	public void grantSubscription(UserId subscriberId, UserId publisherId) {
		TransportMessage transportMessage = new GrantSubscriptionMessage();
		transportMessageSenderHelper.send(subscriberId, publisherId, transportMessage);
	}

}
