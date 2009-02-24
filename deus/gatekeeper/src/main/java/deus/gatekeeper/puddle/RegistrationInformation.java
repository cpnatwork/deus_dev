package deus.gatekeeper.puddle;

import java.util.Set;

import deus.model.user.UserMetadata;
import deus.model.user.UserRole;
import deus.model.user.id.UserIdType;

public class RegistrationInformation {

	private final String localUsername;
	private final String password;

	private final UserMetadata userMetadata;

	private final UserIdType desiredUserIdType;

	private final Set<UserRole> userRoles;


	public RegistrationInformation(String localUsername, String password, UserMetadata userMetadata,
			UserIdType desiredUserIdType, Set<UserRole> userRoles) {
		super();
		this.localUsername = localUsername;
		this.password = password;
		this.userMetadata = userMetadata;
		this.desiredUserIdType = desiredUserIdType;
		this.userRoles = userRoles;
	}


	public String getLocalUsername() {
		return localUsername;
	}


	public String getPassword() {
		return password;
	}


	public UserMetadata getUserMetadata() {
		return userMetadata;
	}


	public UserIdType getDesiredUserIdType() {
		return desiredUserIdType;
	}


	public Set<UserRole> getUserRoles() {
		return userRoles;
	}

}
