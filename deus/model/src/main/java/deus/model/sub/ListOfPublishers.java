package deus.model.sub;

import java.util.Map;

import deus.model.user.id.UserId;

public interface ListOfPublishers extends Map<UserId, LopEntry> {

	public UserId getOwnerId();
	
	public void changeState(UserId publisherId, RequestedSubscriptionState requestedSubscriptionState);

}
