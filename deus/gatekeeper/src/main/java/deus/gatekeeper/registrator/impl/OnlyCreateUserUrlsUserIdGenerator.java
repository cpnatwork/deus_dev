package deus.gatekeeper.registrator.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import deus.gatekeeper.registrator.UserIdGenerator;
import deus.model.user.id.UserId;
import deus.model.user.id.UserIdType;
import deus.model.user.id.UserUrl;

@Component("userIdGenerator")
public class OnlyCreateUserUrlsUserIdGenerator implements UserIdGenerator {

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
