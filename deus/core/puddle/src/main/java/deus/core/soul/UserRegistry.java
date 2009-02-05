package deus.core.soul;

import deus.model.user.id.UserId;

public interface UserRegistry {

	public User getUser(UserId userId);

	// CACHING
	public User getOrCreateTemporaryUser(UserId userId);


	public void registerUser(UserId userId);


	public boolean hasUser(UserId userId);


	public void unregisterUser(UserId userId);

}