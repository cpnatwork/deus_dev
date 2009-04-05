package deus.core.soul.accountadmin.rolesetup;

import deus.model.user.DistributionRole;
import deus.model.user.id.UserId;

// FIXME: rename it, it actually is no observer
public interface DistributionRoleSetupObserver {

	public void setUpRole(DistributionRole distributionRole, UserId userId);


	public void tearDownRole(DistributionRole distributionRole, UserId userId);
	
}
