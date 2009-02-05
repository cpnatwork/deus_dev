package deus.core.access.storage.pub.hibernate;

import java.util.HashMap;

import deus.model.pub.ListOfSubscribers;
import deus.model.pub.LosEntry;
import deus.model.user.id.UserId;

//TODO: think about thread safety! (before, this was implemented using a Vector!)
public class ListOfSubscribersImpl extends HashMap<UserId, LosEntry> implements ListOfSubscribers {

	private static final long serialVersionUID = 8207701628832549782L;

}
