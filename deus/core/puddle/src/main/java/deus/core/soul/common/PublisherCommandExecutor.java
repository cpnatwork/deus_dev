package deus.core.soul.common;

import deus.model.dossier.generic.ForeignInformationFile;
import deus.model.user.id.UserId;

public interface PublisherCommandExecutor {

	public void update(UserId subscriberId, UserId publisherId, ForeignInformationFile change);
}
