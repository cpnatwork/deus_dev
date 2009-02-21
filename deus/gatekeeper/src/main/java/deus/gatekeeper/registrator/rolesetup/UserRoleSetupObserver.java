package deus.gatekeeper.registrator.rolesetup;

import deus.model.user.UserRole;
import deus.model.user.id.UserId;

public interface UserRoleSetupObserver {

	public void setUpRole(UserRole userRole, UserId userId);


	public void tearDownRole(UserRole userRole, UserId userId);
	
}
