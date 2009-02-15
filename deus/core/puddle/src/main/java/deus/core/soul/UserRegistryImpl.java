package deus.core.soul;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import deus.gatekeeper.Cerberus;
import deus.gatekeeper.UserLoginStateObserver;
import deus.model.user.id.UserId;

@Component(value = "userRegistry")
public class UserRegistryImpl implements UserRegistry {

	@Autowired
	UserFactory userFactory;

	@Autowired
	Cerberus cerberus;
	
	Map<UserId, User> registry;
	
	
	class UserRegistryUserLoginStateObserver implements UserLoginStateObserver {

		@Override
		public void loggedIn(UserId userId) {
			registerUser(userId);
		}

		@Override
		public void loggedOut(UserId userId) {
			unregisterUser(userId);
		}
		
	}


	public UserRegistryImpl() {
		registry = new HashMap<UserId, User>();
		cerberus.addUserLoginStateObserver(new UserRegistryUserLoginStateObserver());
	}


	public User getUser(UserId userId) {
		return registry.get(userId);
	}


	// TODO: think about this method...
	public User getOrCreateTemporaryUser(UserId userId) {
		if (hasUser(userId))
			return getUser(userId);
		else {
			User user = userFactory.createUser(userId);
			// DON't add the new user to the registry
			return user;
		}
	}


	public void registerUser(UserId userId) {
		if (hasUser(userId))
			throw new IllegalStateException("cannot register User with local username '" + userId
					+ "', it is already registered");
		
		User user = userFactory.createUser(userId);
		
		registry.put(userId, user);
	}


	public boolean hasUser(UserId userId) {
		return registry.containsKey(userId);
	}


	public void unregisterUser(UserId userId) {
		if (!hasUser(userId))
			throw new IllegalArgumentException("cannot remove user with username '" + userId
					+ "' that has not been registered");
		registry.remove(userId);
	}

}
