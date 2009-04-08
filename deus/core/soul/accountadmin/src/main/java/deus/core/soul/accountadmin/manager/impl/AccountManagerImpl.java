package deus.core.soul.accountadmin.manager.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import deus.core.access.storage.api.account.AccountDoRep;
import deus.core.soul.accountadmin.manager.AccountManager;
import deus.core.soul.accountadmin.rolesetup.DistributionRoleSetup;
import deus.model.common.user.Account;
import deus.model.common.user.DistributionRole;
import deus.model.common.user.UserMetadata;

@Component("accountManager")
public class AccountManagerImpl implements AccountManager {

	@Autowired
	private AccountDoRep accountDoRep;
	
	@Autowired
	private DistributionRoleSetup distributionRoleSetup;


	@Override
	public void changePassword(String localUsername, String newPassword) {
		Account account = accountDoRep.getByNaturalId(localUsername);

		account.setPassword(newPassword);

		accountDoRep.updateEntity(account);
	}

	
	@Override
	public void addRole(String localUsername, DistributionRole distributionRole) {
		Account account = accountDoRep.getByNaturalId(localUsername);

		if (account.getUserRoles().add(distributionRole) == false)
			throw new IllegalArgumentException("account " + account + " already contains role " + distributionRole);

		accountDoRep.updateEntity(account);
		
		distributionRoleSetup.setUpRole(distributionRole, account.getUserId());
	}


	@Override
	public void removeRole(String localUsername, DistributionRole distributionRole) {
		Account account = accountDoRep.getByNaturalId(localUsername);

		if (!account.getUserRoles().contains(distributionRole))
			throw new IllegalArgumentException("account " + account + " does not contain role " + distributionRole);

		account.getUserRoles().remove(distributionRole);

		accountDoRep.updateEntity(account);
		
		distributionRoleSetup.tearDownRole(distributionRole, account.getUserId());
	}


	// FIXME: implement
	@Override
	public void changeUserMetadata(String localUsername, UserMetadata userMetadata) {
		// TODO Auto-generated method stub
		
	}


}
