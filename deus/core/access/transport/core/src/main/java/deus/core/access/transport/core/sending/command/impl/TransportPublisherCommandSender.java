package deus.core.access.transport.core.sending.command.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import deus.core.access.transport.core.messages.TransportMessage;
import deus.core.access.transport.core.messages.UpdateMessage;
import deus.core.access.transport.core.sending.command.PublisherCommandSender;
import deus.model.dossier.DigitalCard;
import deus.model.user.id.UserId;

@Component("publisherCommandSender")
public class TransportPublisherCommandSender implements PublisherCommandSender {
	
	@Autowired
	private TransportMessageSenderHelper transportMessageSenderHelper;


	@Override
	public void update(UserId subscriberId, UserId publisherId, DigitalCard digitalCard) {
		TransportMessage transportMessage = new UpdateMessage(digitalCard);
		transportMessageSenderHelper.send(subscriberId, publisherId, transportMessage);
	}

}
