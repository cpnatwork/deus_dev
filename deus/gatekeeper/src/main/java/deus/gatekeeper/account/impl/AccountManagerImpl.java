package deus.gatekeeper.account.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import deus.core.access.storage.api.account.AccountDoRep;
import deus.gatekeeper.account.AccountManager;
import deus.gatekeeper.rolesetup.UserRoleSetup;
import deus.model.account.Account;
import deus.model.user.UserRole;

@Component("accountManager")
public class AccountManagerImpl implements AccountManager {

	@Autowired
	private AccountDoRep accountDoRep;
	
	@Autowired
	private UserRoleSetup userRoleSetup;


	@Override
	public void changePassword(String localUsername, String newPassword) {
		Account account = accountDoRep.getByNaturalId(localUsername);

		account.setPassword(newPassword);

		accountDoRep.updateEntity(account);
	}


	@Override
	public void addRole(String localUsername, UserRole userRole) {
		Account account = accountDoRep.getByNaturalId(localUsername);

		if (account.getUserRoles().add(userRole) == false)
			throw new IllegalArgumentException("account " + account + " already contains role " + userRole);

		accountDoRep.updateEntity(account);
		
		userRoleSetup.setUpRole(userRole, account.getUserId());
	}


	@Override
	public void removeRole(String localUsername, UserRole userRole) {
		Account account = accountDoRep.getByNaturalId(localUsername);

		if (!account.getUserRoles().contains(userRole))
			throw new IllegalArgumentException("account " + account + " does not contain role " + userRole);

		account.getUserRoles().remove(userRole);

		accountDoRep.updateEntity(account);
		
		userRoleSetup.tearDownRole(userRole, account.getUserId());
	}

}
