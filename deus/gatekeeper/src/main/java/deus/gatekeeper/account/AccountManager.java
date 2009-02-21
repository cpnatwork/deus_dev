package deus.gatekeeper.account;

import deus.model.user.UserRole;
import deus.model.user.id.UserId;

public interface AccountManager {

	public void changePassword(UserId userId, String newPassword);


	public void addRole(UserId userId, UserRole userRole);

	public void removeRole(UserId userId, UserRole userRole);

}
