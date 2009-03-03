package deus.core.access.transport.core.sending.command.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import deus.core.access.transport.core.messages.AbstainSubscriptionMessage;
import deus.core.access.transport.core.messages.ConfirmSubscriptionMessage;
import deus.core.access.transport.core.messages.DenySubscriptionRequestNoticeMessage;
import deus.core.access.transport.core.messages.GrantSubscriptionRequestNoticeMessage;
import deus.core.access.transport.core.messages.TransportMessage;
import deus.core.access.transport.core.sending.command.BarkerCommandSender;
import deus.model.user.id.UserId;

@Component("barkerCommandSender")
public class TransportBarkerCommandSender implements BarkerCommandSender {

	@Autowired
	private TransportMessageSenderHelper transportMessageSenderHelper;

	

	@Override
	public void confirmSubscription(UserId subscriberId, UserId publisherId) {
		TransportMessage transportMessage = new ConfirmSubscriptionMessage();
		transportMessageSenderHelper.send(publisherId, subscriberId, transportMessage);
	}
	
	
	@Override
	public void abstainSubscription(UserId subscriberId, UserId publisherId) {
		TransportMessage transportMessage = new AbstainSubscriptionMessage();
		transportMessageSenderHelper.send(publisherId, subscriberId, transportMessage);
	}

}
