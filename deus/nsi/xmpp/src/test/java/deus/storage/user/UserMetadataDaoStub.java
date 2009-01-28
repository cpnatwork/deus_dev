package deus.storage.user;

import deus.model.user.UserMetadata;
import deus.model.user.id.UserId;
import deus.storage.user.UserMetadataDao;

public class UserMetadataDaoStub implements UserMetadataDao {

	@Override
	public UserMetadata getUserMetadata(String username) {
		UserMetadata userMetadata = new UserMetadata();
		userMetadata.setUserId(userId);
		
		userMetadata.setFullName("full name");
		
		
		
		return userMetadata;
	}

	@Override
	public UserId getUserId(String username) {
		// TODO Auto-generated method stub
		return null;
	}

}
