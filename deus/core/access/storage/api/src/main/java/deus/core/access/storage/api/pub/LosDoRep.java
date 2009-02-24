package deus.core.access.storage.api.pub;

import deus.model.pub.ListOfSubscribers;
import deus.model.user.id.UserId;

public interface LosDoRep {

	public ListOfSubscribers getByNaturalId(UserId publisherId);

	public ListOfSubscribers deleteAllEntities(UserId publisherId);

	public int getSubscriberCount(UserId publisherId);

}
