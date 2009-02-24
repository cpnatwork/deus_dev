package deus.gatekeeper.account;

import deus.model.user.UserRole;

public interface AccountManager {

	public void changePassword(String localUsername, String newPassword);


	public void addRole(String localUsername, UserRole userRole);

	public void removeRole(String localUsername, UserRole userRole);

}
