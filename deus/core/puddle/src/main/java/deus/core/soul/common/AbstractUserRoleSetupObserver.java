package deus.core.soul.common;


import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;

import deus.gatekeeper.rolesetup.UserRoleSetup;
import deus.gatekeeper.rolesetup.UserRoleSetupObserver;
import deus.model.user.UserRole;
import deus.model.user.id.UserId;

public abstract class AbstractUserRoleSetupObserver implements UserRoleSetupObserver {

	@Autowired
	private UserRoleSetup userRoleSetup;


	public AbstractUserRoleSetupObserver() {
		super();
	}


	@PostConstruct
	public void addObserver() {
		userRoleSetup.addRoleSetupObserver(getUserRole(), this);
	}


	@PreDestroy
	public void removeObserver() {
		userRoleSetup.removeRoleSetupObserver(getUserRole(), this);
	}


	@Override
	public void setUpRole(UserRole userRole, UserId userId) {
		if (!userRole.equals(getUserRole()))
			throw new RuntimeException("received notification for set up of user role " + userRole
					+ " while only listening for set up of role " + getUserRole());
		setUpRole(userId);
	}


	protected abstract void setUpRole(UserId userId);


	@Override
	public void tearDownRole(UserRole userRole, UserId userId) {
		if (!userRole.equals(getUserRole()))
			throw new RuntimeException("received notification for tear down of user role " + userRole
					+ " while only listening for tear down of role " + getUserRole());
		
		tearDownRole(userId);
	}


	protected abstract void tearDownRole(UserId userId);


	/**
	 * Returns the user role, this observer should listen to
	 * 
	 * @return
	 */
	protected abstract UserRole getUserRole();

}