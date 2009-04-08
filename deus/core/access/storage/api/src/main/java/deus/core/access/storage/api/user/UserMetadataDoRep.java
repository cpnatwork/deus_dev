package deus.core.access.storage.api.user;

import deus.model.common.user.UserMetadata;
import deus.model.common.user.id.UserId;

/**
 * The DAO for Entity Type UserId. The primary key is the full-fledged String ID of a UserID
 * 
 * @author cpn
 * 
 */
public interface UserMetadataDoRep {

	public UserMetadata getByNaturalId(UserId userId);

	public void addNewEntity(UserId userId, UserMetadata userMetadata);

}
