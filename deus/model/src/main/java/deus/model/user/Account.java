package deus.model.user;

import java.util.Set;

import deus.model.user.id.UserId;


public class Account {

	private final String localUsername;
	private final String password;
	private final UserId userId;

	private final Set<UserRole> userRoles;


	public Account(String localUsername, String password, UserId userId, Set<UserRole> userRoles) {
		super();
		this.localUsername = localUsername;
		this.password = password;
		this.userId = userId;
		this.userRoles = userRoles;
	}


	public String getLocalUsername() {
		return localUsername;
	}


	public String getPassword() {
		return password;
	}


	public UserId getUserId() {
		return userId;
	}


	public Set<UserRole> getUserRoles() {
		return userRoles;
	}

}
