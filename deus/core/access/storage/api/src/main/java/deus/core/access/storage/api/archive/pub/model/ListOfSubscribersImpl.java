package deus.core.access.storage.api.archive.pub.model;

import java.util.HashMap;

import deus.model.common.user.id.UserId;
import deus.model.publication.ListOfSubscribers;
import deus.model.publication.LosEntry;

//TODO: think about thread safety! (before, this was implemented using a Vector!)
public class ListOfSubscribersImpl extends HashMap<UserId, LosEntry> implements ListOfSubscribers {

	private static final long serialVersionUID = 8207701628832549782L;

	@Override
	public UserId getOwnerId() {
		// TODO Auto-generated method stub
		return null;
	}

}
