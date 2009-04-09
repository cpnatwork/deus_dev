package deus.core.access.storage.api.common.account;

import deus.model.common.account.Account;

public interface AccountDao {

	public Account getByNaturalId(String localUsername);

	public void updateEntity(Account account);

}
