package deus.core.access.transport.core.sending.command.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import deus.core.access.transport.core.messages.RepelSubscriptionOfferNoticeMessage;
import deus.core.access.transport.core.messages.ConfirmSubscriptionOfferNoticeMessage;
import deus.core.access.transport.core.messages.DenySubscriptionRequestNoticeMessage;
import deus.core.access.transport.core.messages.GrantSubscriptionRequestNoticeMessage;
import deus.core.access.transport.core.messages.TransportMessage;
import deus.core.access.transport.core.sending.command.BarkerCommandSender;
import deus.model.user.id.UserId;

@Component("barkerCommandSender")
public class TransportBarkerCommandSender implements BarkerCommandSender {

	@Autowired
	private TransportMessageSenderHelper transportMessageSenderHelper;



}
