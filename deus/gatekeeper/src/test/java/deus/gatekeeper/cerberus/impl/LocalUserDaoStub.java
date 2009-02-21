package deus.gatekeeper.cerberus.impl;

import deus.core.access.storage.api.user.api.LocalUserDao;
import deus.model.user.Account;
import deus.model.user.id.UserId;
import deus.model.user.id.UserUrl;

public class LocalUserDaoStub implements LocalUserDao {

	@Override
	public void addNewEntity(UserId entity) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void deleteByNaturalId(String naturalId) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public UserId getByNaturalId(String username) {
		return new UserUrl(username, "deus.org");
	}


	@Override
	public void updateEntity(UserId entity) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void createAccount(Account account) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public boolean existsLocalUsername(String localUserName) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public void deleteAccount(UserId userId) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public Account getAccount(UserId userId) {
		// TODO Auto-generated method stub
		return null;
	}

}
