package deus.core.soul.accountadmin.manager.impl;

import javax.inject.Inject;
import javax.inject.Named;

import deus.core.access.storage.api.common.account.AccountDao;
import deus.core.access.storage.api.common.user.UserMetadataDao;
import deus.core.soul.accountadmin.manager.AccountManager;
import deus.core.soul.accountadmin.rolesetup.DistributionRoleSetup;
import deus.model.common.account.Account;
import deus.model.common.account.DistributionRole;
import deus.model.common.user.UserMetadata;
import deus.model.common.user.id.UserId;

@Named("accountManager")
public class AccountManagerImpl implements AccountManager {

	
	@Inject
	private AccountDao accountDao;
	
	@Inject
	private UserMetadataDao userMetadataDao;
	
	@Inject
	private DistributionRoleSetup distributionRoleSetup;


	@Override
	public void changePassword(String localUsername, String newPassword) {
		Account account = accountDao.getByNaturalId(localUsername);
		
		account.setPassword(newPassword);

		accountDao.updateEntity(account);
	}

	
	@Override
	public void addRole(String localUsername, DistributionRole distributionRole) {
		Account account = accountDao.getByNaturalId(localUsername);

		if (account.getUserRoles().add(distributionRole) == false)
			throw new IllegalArgumentException("account " + account + " already contains role " + distributionRole);

		accountDao.updateEntity(account);
		
		distributionRoleSetup.setUpRole(distributionRole, account.getUserId());
	}


	@Override
	public void removeRole(String localUsername, DistributionRole distributionRole) {
		Account account = accountDao.getByNaturalId(localUsername);

		if (!account.getUserRoles().contains(distributionRole))
			throw new IllegalArgumentException("account " + account + " does not contain role " + distributionRole);

		account.getUserRoles().remove(distributionRole);

		accountDao.updateEntity(account);
		
		distributionRoleSetup.tearDownRole(distributionRole, account.getUserId());
	}


	@Override
	public void changeUserMetadata(String localUsername, UserMetadata userMetadata) {
		Account account = accountDao.getByNaturalId(localUsername);
		
		UserId userId = account.getUserId();
		
		userMetadataDao.updateEntity(userId, userMetadata);
	}


}
