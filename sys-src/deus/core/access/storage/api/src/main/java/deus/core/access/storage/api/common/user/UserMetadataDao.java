package deus.core.access.storage.api.common.user;

import deus.model.common.user.UserMetadata;
import deus.model.common.user.id.UserId;

public interface UserMetadataDao {

	public void updateEntity(UserId userId, UserMetadata userMetadata);


	public void addNewEntity(UserId userId, UserMetadata userMetadata);


	public UserMetadata getByNaturalId(UserId userId);

}
