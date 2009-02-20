package deus.core.access.storage.sub.api;

import deus.core.access.storage.common.Dao;
import deus.model.depository.generic.DistributedInformationFolder;
import deus.model.sub.ListOfPublishers;
import deus.model.user.id.UserId;

public interface SubDao extends Dao<ListOfPublishers, UserId> {

	public ListOfPublishers getListOfPublishers(UserId lopOwnerUserId);


	public DistributedInformationFolder getDistributedInformationFolder(UserId userId);

}
