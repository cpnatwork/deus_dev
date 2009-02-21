package deus.gatekeeper.cerberus.impl;

import deus.core.access.storage.api.user.api.AccountDao;
import deus.model.user.Account;
import deus.model.user.id.UserId;

public class AccountDaoStub implements AccountDao {

	@Override
	public void addNewEntity(Account entity) {
		// TODO Auto-generated method stub

	}


	@Override
	public void deleteByNaturalId(UserId naturalId) {
		// TODO Auto-generated method stub

	}


	@Override
	public Account getByNaturalId(UserId naturalId) {
		return new Account("", "", naturalId, null);
	}


	@Override
	public void updateEntity(Account entity) {
		// TODO Auto-generated method stub

	}

}
