package deus.model.user;

import deus.model.user.id.UserId;


public class Account {

	private final String localUsername;
	private final String password;
	private final UserId userId;


	public Account(String localUsername, String password, UserId userId) {
		super();
		this.localUsername = localUsername;
		this.password = password;
		this.userId = userId;
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

}
