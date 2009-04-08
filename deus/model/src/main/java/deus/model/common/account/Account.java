package deus.model.common.account;

import java.util.Set;

import deus.model.common.user.id.UserId;


public class Account {

	private String localUsername;
	private String password;
	private UserId userId;

	// FIXME: think about whether we really want to store logged in state in Account object
	private boolean loggedIn;

	private final Set<DistributionRole> distributionRoles;


	public Account(String localUsername, String password, UserId userId, Set<DistributionRole> distributionRoles) {
		super();
		this.localUsername = localUsername;
		this.password = password;
		this.userId = userId;
		this.distributionRoles = distributionRoles;
	}


	public String getLocalUsername() {
		return localUsername;
	}


	public void setLocalUsername(String localUsername) {
		this.localUsername = localUsername;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public UserId getUserId() {
		return userId;
	}


	public void setUserId(UserId userId) {
		this.userId = userId;
	}


	public Set<DistributionRole> getUserRoles() {
		return distributionRoles;
	}


	public boolean isLoggedIn() {
		return loggedIn;
	}


	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
	}

}
