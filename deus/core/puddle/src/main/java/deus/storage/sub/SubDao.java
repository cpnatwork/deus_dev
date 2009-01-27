package deus.storage.sub;

import deus.model.sub.ListOfPublishers;
import deus.model.user.id.UserId;

public interface SubDao {

	public ListOfPublishers getListOfPublishers(UserId userId);
	
}
