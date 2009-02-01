package deus.core.transport.commandsender.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import deus.core.transport.commandsender.PublisherCommandSender;
import deus.core.transport.message.TransportMessage;
import deus.core.transport.message.UpdateMessage;
import deus.model.dossier.generic.ForeignInformationFile;
import deus.model.user.id.UserId;

@Component
public class TransportPublisherCommandSender implements PublisherCommandSender {
	
	@Autowired
	private TransportMessageSenderHelper transportMessageSenderHelper;


	@Override
	public void update(UserId subscriberId, UserId publisherId, ForeignInformationFile change) {
		TransportMessage transportMessage = new UpdateMessage(change);
		transportMessageSenderHelper.send(subscriberId, publisherId, transportMessage);
	}

}
