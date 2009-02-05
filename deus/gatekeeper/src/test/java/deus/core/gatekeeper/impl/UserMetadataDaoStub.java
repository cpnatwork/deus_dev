package deus.core.gatekeeper.impl;

import deus.core.access.storage.user.api.UserMetadataDao;
import deus.model.user.UserMetadata;
import deus.model.user.id.UserId;
import deus.model.user.id.UserUrl;

public class UserMetadataDaoStub implements UserMetadataDao {

	@Override
	public UserId getUserId(String username) {
		return new UserUrl(username, "deus.org");
	}


	@Override
	public UserMetadata getById(String username) {
		// TODO Auto-generated method stub
		return null;
	}

}
