package deus.core.soul.pifgoverning.rolesetup;

import javax.inject.Named;

import deus.core.soul.accountadmin.rolesetup.AbstractDistributionRoleSetupObserver;
import deus.model.common.account.DistributionRole;
import deus.model.common.user.id.UserId;

@Named
public class CpRoleSetupPifGovernorObserver extends AbstractDistributionRoleSetupObserver {
	
	@Override
	protected DistributionRole getDistributionRole() {
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
