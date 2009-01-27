package deus.storage.user;

import deus.model.user.UserMetadata;
import deus.model.user.id.UserId;
import deus.storage.user.UserMetadataDao;

public class UserMetadataDaoStub implements UserMetadataDao {

	@Override
	public UserMetadata getUserMetadata(UserId userId) {
		UserMetadata userMetadata = new UserMetadata();
		userMetadata.setUserId(userId);
		
		userMetadata.setFullName("full name");
		
		
		
		return userMetadata;
	}

}
