package deus.gatekeeper.puddle;

import java.util.Set;

import deus.model.user.UserRole;
import deus.model.user.id.UserIdType;

public class RegistrationInformation {

	private final String localUsername;
	private final String password;

	private final UserIdType desiredUserIdType;

	private final Set<UserRole> userRoles;


	public RegistrationInformation(String localUsername, String password, UserIdType desiredUserIdType,
			Set<UserRole> userRoles) {
		super();
		this.localUsername = localUsername;
		this.password = password;
		this.desiredUserIdType = desiredUserIdType;
		this.userRoles = userRoles;
	}


	public String getLocalUsername() {
		return localUsername;
	}


	public String getPassword() {
		return password;
	}


	public UserIdType getDesiredUserIdType() {
		return desiredUserIdType;
	}


	public Set<UserRole> getUserRoles() {
		return userRoles;
	}

}
