package deus.core.soul.accountadmin.registrator;

import deus.model.common.user.id.UserId;
import deus.model.common.user.id.UserIdType;

public interface UserIdGenerator {

	public UserId generateUserId(UserIdType userIdType, String localUserName);
	
}
