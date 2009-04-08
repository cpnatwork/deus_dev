package deus.core.soul.accountadmin.rolesetup;


import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;

import deus.model.common.account.DistributionRole;
import deus.model.common.user.id.UserId;

public abstract class AbstractDistributionRoleSetupObserver implements DistributionRoleSetupObserver {

	@Autowired
	private DistributionRoleSetup distributionRoleSetup;


	@PostConstruct
	@SuppressWarnings("unused")
	private void addObserver() {
		distributionRoleSetup.addRoleSetupObserver(getDistributionRole(), this);
	}


	@PreDestroy
	@SuppressWarnings("unused")
	private void removeObserver() {
		distributionRoleSetup.removeRoleSetupObserver(getDistributionRole(), this);
	}


	@Override
	public void setUpRole(DistributionRole distributionRole, UserId userId) {
		if (!distributionRole.equals(getDistributionRole()))
			throw new RuntimeException("received notification for set up of user role " + distributionRole
					+ " while only listening for set up of role " + getDistributionRole());
		setUpRole(userId);
	}


	protected abstract void setUpRole(UserId userId);


	@Override
	public void tearDownRole(DistributionRole distributionRole, UserId userId) {
		if (!distributionRole.equals(getDistributionRole()))
			throw new RuntimeException("received notification for tear down of user role " + distributionRole
					+ " while only listening for tear down of role " + getDistributionRole());

		tearDownRole(userId);
	}


	protected abstract void tearDownRole(UserId userId);


	/**
	 * Returns the distribution role, this observer should setup
	 * 
	 * @return
	 */
	protected abstract DistributionRole getDistributionRole();

}