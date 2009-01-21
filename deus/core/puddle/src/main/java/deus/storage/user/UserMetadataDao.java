package deus.storage.user;

import deus.model.user.UserMetadata;
import deus.model.user.id.UserId;

public interface UserMetadataDao {

	public UserMetadata getUserMetadata(UserId userId);

}
