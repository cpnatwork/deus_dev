package deus.core.soul;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import deus.gatekeeper.Gatekeeper;
import deus.gatekeeper.UserLoginStateObserver;
import deus.model.user.id.UserId;
import deus.model.user.id.UserUrl;

@Component(value = "userRegistry")
public class UserRegistryImpl implements UserRegistry {

	@Autowired
	UserFactory userFactory;

	@Autowired
	Gatekeeper gatekeeper;
	
	Map<String, User> registry;
	
	
	class UserRegistryUserLoginStateObserver implements UserLoginStateObserver {

		@Override
		public void loggedIn(String localUsername, UserId userId) {
			User user = userFactory.createUser(localUsername);
			registerUser(localUsername, user);
		}

		@Override
		public void loggedOut(String localUsername, UserId userId) {
			unregisterUser(localUsername);
		}
		
	}


	public UserRegistryImpl() {
		registry = new HashMap<String, User>();
		gatekeeper.addUserLoginStateObserver(new UserRegistryUserLoginStateObserver());
	}


	public User getUser(String localUsername) {
		return registry.get(localUsername);
	}


	// TODO: think about this method...
	public User getOrCreateTemporaryUser(UserId userId) {
		// TODO: really get local username from user url???
		String localUsername = ((UserUrl)userId).getUsername();
		
		if (hasUser(localUsername))
			return getUser(localUsername);
		else {
			User user = userFactory.createUser(localUsername);
			// DON't add the new user to the registry
			return user;
		}
	}


	public void registerUser(String localUsername, User user) {
		if (hasUser(localUsername))
			throw new IllegalStateException("cannot register User with local username '" + localUsername
					+ "', it is already registered");
		registry.put(localUsername, user);
	}


	public boolean hasUser(String localUsername) {
		return registry.containsKey(localUsername);
	}


	public void unregisterUser(String localUsername) {
		if (!hasUser(localUsername))
			throw new IllegalArgumentException("cannot remove user with username '" + localUsername
					+ "' that has not been registered");
		registry.remove(localUsername);
	}

}
