package deus.core.access.storage.inmemory.user;

import org.springframework.stereotype.Component;

import deus.core.access.storage.api.user.api.AccountDao;
import deus.model.account.Account;
import deus.model.user.id.UserId;

@Component("accountDao")
public class AccountDaoInmemoryImpl implements AccountDao {

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
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void updateEntity(Account entity) {
		// TODO Auto-generated method stub

	}

}
