package deus.model.common.account;

import java.util.Set;

import deus.model.common.user.id.UserId;

/**
 * A DEUS account of a user. An account is uniquely identified by a <code>localUsername</code>. While the
 * <code>userId</code> also uniquely identifies an account, <code>localUsername</code> is used for loading and storing
 * accounts using DAOs.
 * 
 * The logged in state of the user is stored using <code>loggedIn</code>.
 * 
 * Furthermore, a set of distribution roles, assumed by the account is stored.
 * 
 * @author Florian Rampp (Florian.Rampp@informatik.stud.uni-erlangen.de)
 * 
 */
public class Account {

	// Primary Key: localUsername
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
