package deus.core.soul.accountadmin.rolesetup;

import deus.model.common.account.DistributionRole;
import deus.model.common.user.id.UserId;

public interface DistributionRoleSetup {

	public void setUpRole(DistributionRole distributionRole, UserId userId);


	public void tearDownRole(DistributionRole distributionRole, UserId userId);

	
	public void addRoleSetupObserver(DistributionRole distributionRole, DistributionRoleSetupObserver observer);
	
	public void removeRoleSetupObserver(DistributionRole distributionRole, DistributionRoleSetupObserver observer);
}
