package deus.core.soul.pifgoverning.rolesetup;

import org.springframework.stereotype.Component;

import deus.core.soul.common.AbstractDistributionRoleSetupObserver;
import deus.model.user.DistributionRole;
import deus.model.user.id.UserId;

@Component
public class CpRoleSetupPifGovernorObserver extends AbstractDistributionRoleSetupObserver {

	@Override
	protected DistributionRole getUserRole() {
		return DistributionRole.concernedPerson;
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
