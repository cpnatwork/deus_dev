package deus.core.transport.commandsender;

import deus.model.dossier.generic.ForeignInformationFile;
import deus.model.user.id.UserId;

public interface PublisherCommandSender {

	public void update(UserId subscriberId, UserId publisherId, ForeignInformationFile change);
}
