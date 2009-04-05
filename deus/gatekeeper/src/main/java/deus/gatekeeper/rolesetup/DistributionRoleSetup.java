package deus.gatekeeper.rolesetup;

import deus.model.user.DistributionRole;
import deus.model.user.id.UserId;

public interface DistributionRoleSetup {

	public void setUpRole(DistributionRole distributionRole, UserId userId);


	public void tearDownRole(DistributionRole distributionRole, UserId userId);

	
	public void addRoleSetupObserver(DistributionRole distributionRole, DistributionRoleSetupObserver observer);
	
	public void removeRoleSetupObserver(DistributionRole distributionRole, DistributionRoleSetupObserver observer);
}
