package deus.core.soul;

import deus.model.user.id.UserId;


public interface UserFactory {

	public abstract User createUser(UserId userId);

}