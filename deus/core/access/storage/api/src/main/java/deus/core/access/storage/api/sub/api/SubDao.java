package deus.core.access.storage.api.sub.api;

import deus.core.access.storage.api.common.Dao;
import deus.model.depository.generic.DistributedInformationFolder;
import deus.model.sub.ListOfPublishers;
import deus.model.user.id.UserId;

public interface SubDao extends Dao<ListOfPublishers, UserId> {

	public ListOfPublishers getListOfPublishers(UserId lopOwnerUserId);


	public DistributedInformationFolder getDistributedInformationFolder(UserId userId);

}
