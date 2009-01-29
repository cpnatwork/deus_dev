package deus.storage.user.impl;

import org.springframework.stereotype.Component;

import deus.model.user.UserMetadata;
import deus.model.user.id.UserId;
import deus.model.user.id.UserUrl;
import deus.storage.user.UserMetadataDao;

@Component
public class UserMetadataDaoStub implements UserMetadataDao {

	@Override
	public UserMetadata getUserMetadata(String username) {
		UserId userId = getUserId(username);
		
		UserMetadata userMetadata = new UserMetadata();
		userMetadata.setUserId(userId);
		
		userMetadata.setFullName("full name");
		
		
		
		return userMetadata;
	}

	@Override
	public UserId getUserId(String username) {
		// TODO: load it from DB!
		UserId userId = new UserUrl(username, "deus.org");
		
		return userId;
	}

}
