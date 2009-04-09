package deus.core.soul.gatekeeper.cerberus.impl;

import deus.core.access.storage.api.common.user.UserMetadataDao;
import deus.model.common.user.UserMetadata;
import deus.model.common.user.id.UserId;

public class UserMetadataDaoStub implements UserMetadataDao {

	@Override
	public void addNewEntity(UserId userId, UserMetadata userMetadata) {
		// TODO Auto-generated method stub

	}


	@Override
	public UserMetadata getByNaturalId(UserId userId) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void updateEntity(UserId userId, UserMetadata userMetadata) {
		// TODO Auto-generated method stub
		
	}

}
