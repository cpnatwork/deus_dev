package deus.core.soul.gatekeeper.cerberus.impl;

import deus.core.access.storage.api.common.account.AccountDao;
import deus.model.common.account.Account;
import deus.model.common.user.id.UserUrl;

public class AccountDaoStub implements AccountDao {

	@Override
	public void addNewEntity(Account account) {
		// TODO Auto-generated method stub

	}


	@Override
	public void deleteByNaturalId(String localUsername) {
		// TODO Auto-generated method stub

	}


	@Override
	public Account getByNaturalId(String localUsername) {
		return new Account(localUsername, "", new UserUrl(localUsername, "deus.org"), null);
	}


	@Override
	public void updateEntity(Account account) {
		// TODO Auto-generated method stub

	}


	@Override
	public boolean existsEntity(String localUserName) {
		// TODO Auto-generated method stub
		return false;
	}


}
