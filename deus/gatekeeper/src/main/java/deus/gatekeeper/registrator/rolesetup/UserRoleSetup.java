package deus.gatekeeper.registrator.rolesetup;

import deus.model.user.UserRole;
import deus.model.user.id.UserId;

public interface UserRoleSetup {

	public void setUpRole(UserId userId);
	
	public void tearDownRole(UserId userId);
	
	public UserRole getUserRole();
	
}
