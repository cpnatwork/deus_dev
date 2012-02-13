package deus.core.soul.accountadmin.rolesetup.impl;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.inject.Named;

import deus.core.soul.accountadmin.rolesetup.DistributionRoleSetup;
import deus.core.soul.accountadmin.rolesetup.DistributionRoleSetupObserver;
import deus.model.common.account.DistributionRole;
import deus.model.common.user.id.UserId;

@Named("distributionRoleSetup")
public class DistributionRoleSetupImpl implements DistributionRoleSetup {

	private final Map<DistributionRole, List<DistributionRoleSetupObserver>> observers;


	public DistributionRoleSetupImpl() {
		observers = new HashMap<DistributionRole, List<DistributionRoleSetupObserver>>();
		for (DistributionRole distributionRole : DistributionRole.values())
			observers.put(distributionRole, new LinkedList<DistributionRoleSetupObserver>());
	}


	@Override
	public void addRoleSetupObserver(DistributionRole distributionRole, DistributionRoleSetupObserver observer) {
		observers.get(distributionRole).add(observer);
	}


	@Override
	public void removeRoleSetupObserver(DistributionRole distributionRole, DistributionRoleSetupObserver observer) {
		List<DistributionRoleSetupObserver> list = observers.get(distributionRole);
		if (!list.contains(observer))
			throw new IllegalArgumentException("observer " + observer + " cannot be removed, it has not been added");

		observers.get(distributionRole).remove(observer);
	}


	@Override
	public void setUpRole(DistributionRole distributionRole, UserId userId) {
		List<DistributionRoleSetupObserver> list = observers.get(distributionRole);
		for (DistributionRoleSetupObserver observer : list)
			observer.setUpRole(distributionRole, userId);
	}


	@Override
	public void tearDownRole(DistributionRole distributionRole, UserId userId) {
		List<DistributionRoleSetupObserver> list = observers.get(distributionRole);
		for (DistributionRoleSetupObserver observer : list)
			observer.tearDownRole(distributionRole, userId);
	}

}
