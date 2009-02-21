package deus.gatekeeper.account.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import deus.core.access.storage.api.user.api.AccountDao;
import deus.gatekeeper.account.AccountManager;
import deus.gatekeeper.registrator.rolesetup.UserRoleSetup;
import deus.model.user.Account;
import deus.model.user.UserRole;
import deus.model.user.id.UserId;

@Component("accountManager")
public class AccountManagerImpl implements AccountManager {

	@Autowired
	private AccountDao accountDao;
	
	@Autowired
	private UserRoleSetup userRoleSetup;


	@Override
	public void changePassword(UserId userId, String newPassword) {
		Account account = accountDao.getByNaturalId(userId);

		account.setPassword(newPassword);

		accountDao.updateEntity(account);
	}


	@Override
	public void addRole(UserId userId, UserRole userRole) {
		Account account = accountDao.getByNaturalId(userId);

		if (account.getUserRoles().add(userRole) == false)
			throw new IllegalArgumentException("account " + account + " already contains role " + userRole);

		accountDao.updateEntity(account);
		
		userRoleSetup.setUpRole(userRole, userId);
	}


	@Override
	public void removeRole(UserId userId, UserRole userRole) {
		Account account = accountDao.getByNaturalId(userId);

		if (!account.getUserRoles().contains(userRole))
			throw new IllegalArgumentException("account " + account + " does not contain role " + userRole);

		account.getUserRoles().remove(userRole);

		accountDao.updateEntity(account);
		
		userRoleSetup.tearDownRole(userRole, userId);
	}

}
