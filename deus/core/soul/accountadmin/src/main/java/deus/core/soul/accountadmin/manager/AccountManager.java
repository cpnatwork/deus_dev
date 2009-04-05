package deus.core.soul.accountadmin.manager;

import deus.model.user.DistributionRole;
import deus.model.user.UserMetadata;

public interface AccountManager {

	public void changePassword(String localUsername, String newPassword);

	public void changeUserMetadata(String localUsername, UserMetadata userMetadata);

	public void addRole(String localUsername, DistributionRole distributionRole);

	public void removeRole(String localUsername, DistributionRole distributionRole);

}
 