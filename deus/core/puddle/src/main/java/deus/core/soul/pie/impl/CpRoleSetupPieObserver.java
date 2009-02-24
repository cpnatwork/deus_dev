package deus.core.soul.pie.impl;

import org.springframework.stereotype.Component;

import deus.core.soul.common.AbstractUserRoleSetupObserver;
import deus.model.user.UserRole;
import deus.model.user.id.UserId;

@Component
public class CpRoleSetupPieObserver extends AbstractUserRoleSetupObserver {

	@Override
	protected UserRole getUserRole() {
		return UserRole.cp;
	}


	@Override
	protected void setUpRole(UserId userId) {
		// FUTURE: init data objects in database for subsystem Subscriber here!
	}


	@Override
	protected void tearDownRole(UserId userId) {
		// FUTURE: destroy data objects in database for subsystem Subscriber here!
	}

}
