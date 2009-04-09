package deus.core.access.storage.api.difgoverning;

import deus.model.common.user.frids.PublisherId;
import deus.model.common.user.frids.SubscriberId;
import deus.model.difgoverning.ForeignInformationFile;

public interface FifDao {

	ForeignInformationFile getByNaturalId(SubscriberId subscriberId, PublisherId publisherId);

	void updateEntity(SubscriberId subscriberId, PublisherId publisherId, ForeignInformationFile foreignInformationFile);

}
