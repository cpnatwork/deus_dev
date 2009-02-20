package deus.core.access.storage.api.user.api;

import deus.core.access.storage.api.common.Dao;
import deus.model.user.UserMetadata;
import deus.model.user.id.UserId;

/**
 * The DAO for Entity Type UserId. The primary key is the full-fledged String ID of a UserID
 * 
 * @author cpn
 * 
 */
public interface UserDao extends Dao<UserId, String> {

	UserMetadata getUserMetadata(UserId userId);

	void updateUserMetadata(UserId userId, UserMetadata userMetadata);

}
