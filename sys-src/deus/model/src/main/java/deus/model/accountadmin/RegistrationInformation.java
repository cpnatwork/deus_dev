package deus.model.accountadmin;

import java.util.Set;

import deus.model.common.account.DistributionRole;
import deus.model.common.user.UserMetadata;
import deus.model.common.user.id.UserIdType;

public class RegistrationInformation {

	private final String localUsername;
	private final String password;

	private final UserMetadata userMetadata;

	private final UserIdType desiredUserIdType;

	private final Set<DistributionRole> distributionRoles;


	public RegistrationInformation(String localUsername, String password, UserMetadata userMetadata,
			UserIdType desiredUserIdType, Set<DistributionRole> distributionRoles) {
		super();
		this.localUsername = localUsername;
		this.password = password;
		this.userMetadata = userMetadata;
		this.desiredUserIdType = desiredUserIdType;
		this.distributionRoles = distributionRoles;
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


	public Set<DistributionRole> getUserRoles() {
		return distributionRoles;
	}

}
