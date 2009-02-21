package deus.gatekeeper.rolesetup;

import deus.model.user.UserRole;
import deus.model.user.id.UserId;

public interface UserRoleSetup {

	public void setUpRole(UserRole userRole, UserId userId);


	public void tearDownRole(UserRole userRole, UserId userId);

	
	public void addRoleSetupObserver(UserRole userRole, UserRoleSetupObserver observer);
	
	public void removeRoleSetupObserver(UserRole userRole, UserRoleSetupObserver observer);
}
