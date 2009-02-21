package deus.gatekeeper.rolesetup.impl;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import deus.gatekeeper.rolesetup.UserRoleSetup;
import deus.gatekeeper.rolesetup.UserRoleSetupObserver;
import deus.model.user.UserRole;
import deus.model.user.id.UserId;

@Component("userRoleSetup")
public class UserRoleSetupImpl implements UserRoleSetup {

	private final Map<UserRole, List<UserRoleSetupObserver>> observers;


	public UserRoleSetupImpl() {
		observers = new HashMap<UserRole, List<UserRoleSetupObserver>>();
		for (UserRole userRole : UserRole.values())
			observers.put(userRole, new LinkedList<UserRoleSetupObserver>());
	}


	@Override
	public void addRoleSetupObserver(UserRole userRole, UserRoleSetupObserver observer) {
		observers.get(userRole).add(observer);
	}


	@Override
	public void removeRoleSetupObserver(UserRole userRole, UserRoleSetupObserver observer) {
		List<UserRoleSetupObserver> list = observers.get(userRole);
		if (!list.contains(observer))
			throw new IllegalArgumentException("observer " + observer + " cannot be removed, it has not been added");

		observers.get(userRole).remove(observer);
	}


	@Override
	public void setUpRole(UserRole userRole, UserId userId) {
		List<UserRoleSetupObserver> list = observers.get(userRole);
		for (UserRoleSetupObserver observer : list)
			observer.setUpRole(userRole, userId);
	}


	@Override
	public void tearDownRole(UserRole userRole, UserId userId) {
		List<UserRoleSetupObserver> list = observers.get(userRole);
		for (UserRoleSetupObserver observer : list)
			observer.tearDownRole(userRole, userId);
	}

}
