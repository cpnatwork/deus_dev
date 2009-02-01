package deus.core.gatekeeper.impl;

import deus.model.user.UserMetadata;
import deus.model.user.id.UserId;
import deus.model.user.id.UserUrl;
import deus.storage.user.UserMetadataDao;

public class UserMetadataDaoStub implements UserMetadataDao {

	@Override
	public UserId getUserId(String username) {
		return new UserUrl(username, "deus.org");
	}


	@Override
	public UserMetadata getUserMetadata(String username) {
		// TODO Auto-generated method stub
		return null;
	}

}
