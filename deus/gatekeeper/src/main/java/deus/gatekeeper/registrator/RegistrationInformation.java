package deus.gatekeeper.registrator;

import deus.model.user.id.UserIdType;

public class RegistrationInformation {

	private final String localUsername;
	private final String password;

	private final UserIdType desiredUserIdType;


	public RegistrationInformation(String localUsername, String password, UserIdType desiredUserIdType) {
		super();
		this.localUsername = localUsername;
		this.password = password;
		this.desiredUserIdType = desiredUserIdType;
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

}
