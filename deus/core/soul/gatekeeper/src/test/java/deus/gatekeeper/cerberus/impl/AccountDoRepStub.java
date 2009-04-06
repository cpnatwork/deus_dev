package deus.gatekeeper.cerberus.impl;

import deus.core.access.storage.api.account.AccountDoRep;
import deus.model.accountadmin.Account;
import deus.model.user.id.UserUrl;

public class AccountDoRepStub implements AccountDoRep {

	@Override
	public void addNewEntity(Account account) {
		// TODO Auto-generated method stub

	}


	@Override
	public void deleteByNaturalId(String localUsername) {
		// TODO Auto-generated method stub

	}


	@Override
	public boolean existsAccount(String localUserName) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public Account getByNaturalId(String localUsername) {
		return new Account(localUsername, "", new UserUrl(localUsername, "deus.org"), null);
	}


	@Override
	public void updateEntity(Account account) {
		// TODO Auto-generated method stub

	}


}
