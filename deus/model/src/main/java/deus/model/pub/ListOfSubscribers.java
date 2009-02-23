package deus.model.pub;

import java.util.Map;

import deus.model.user.id.UserId;


public interface ListOfSubscribers extends Map<UserId, LosEntry> {

	public UserId getOwnerId();
	
}