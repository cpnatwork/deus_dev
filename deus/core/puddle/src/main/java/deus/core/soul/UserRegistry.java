package deus.core.soul;

import deus.model.user.id.UserId;

public interface UserRegistry {

	public User getUser(String localUsername);

	// CACHING
	public User getOrCreateTemporaryUser(UserId userId);


	public void registerUser(String localUsername, User user);


	public boolean hasUser(String localUsername);


	public void unregisterUser(String localUsername);

}