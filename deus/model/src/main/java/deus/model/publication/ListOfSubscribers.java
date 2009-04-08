package deus.model.publication;

import java.util.Map;

import deus.model.common.user.id.UserId;


public interface ListOfSubscribers extends Map<UserId, LosEntry> {

	public UserId getOwnerId();
	
}