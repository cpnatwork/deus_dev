package deus.core;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import deus.model.user.id.UserId;

@Component
public class UserRegistry {

	@Autowired
	private UserFactory userFactory;

	private Map<UserId, User> registry;


	public UserRegistry() {
		registry = new HashMap<UserId, User>();
	}


	public User getOrCreateTemporaryUser(UserId userId) {
		if (registry.containsKey(userId))
			return registry.get(userId);
		else {
			User user = userFactory.createUser(userId);
			// DON't add the new user to the registry
			return user;
		}
	}


	public User createAndRegisterUser(UserId userId) {
		if (hasUser(userId))
			throw new IllegalStateException("cannot register User (" + userId + "), it is already registered");
		User user = userFactory.createUser(userId);
		registry.put(userId, user);
		return user;
	}


	public boolean hasUser(UserId userId) {
		return registry.containsKey(userId);
	}


	public void unregisterUser(UserId userId) {
		if (!hasUser(userId))
			throw new IllegalArgumentException("cannot remove User (" + userId + "), that has not been registered");
		registry.remove(userId);
	}

}
