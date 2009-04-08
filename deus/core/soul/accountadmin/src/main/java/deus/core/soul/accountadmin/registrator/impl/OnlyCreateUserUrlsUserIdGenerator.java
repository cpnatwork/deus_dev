package deus.core.soul.accountadmin.registrator.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import deus.core.soul.accountadmin.registrator.UserIdGenerator;
import deus.model.common.user.id.UserId;
import deus.model.common.user.id.UserIdType;
import deus.model.common.user.id.UserUrl;

@Component("userIdGenerator")
public class OnlyCreateUserUrlsUserIdGenerator implements UserIdGenerator {

	// FIXME: rename this to serverBaseUrl (as in UserUrl)
	@Resource(name="hostname")
	private String hostname;
	
	@Override
	public UserId generateUserId(UserIdType userIdType, String localUserName) {
		if(!userIdType.equals(UserIdType.url))
			throw new IllegalArgumentException("can only create URLs, not " + userIdType);
		
		UserId userId = new UserUrl(localUserName, hostname);

		return userId;
	}

}
