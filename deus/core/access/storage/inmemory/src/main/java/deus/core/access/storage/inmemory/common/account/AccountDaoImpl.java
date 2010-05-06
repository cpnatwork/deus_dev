/**
 * 
 */
package deus.core.access.storage.inmemory.common.account;

import javax.inject.Named;

import deus.core.access.storage.api.common.account.AccountDao;
import deus.core.access.storage.inmemory.GenericVanillaDaoImpl;
import deus.model.common.account.Account;

/**
 * @author cpn
 */
@Named("accountDao")
public class AccountDaoImpl extends GenericVanillaDaoImpl<Account, String> implements AccountDao {

	@Override
	public void addNewEntity(Account account) {
		addNewEntity(account.getLocalUsername(), account);
	}

	@Override
	public void updateEntity(Account account) {
		updateEntity(account.getLocalUsername(), account);
	}

}
