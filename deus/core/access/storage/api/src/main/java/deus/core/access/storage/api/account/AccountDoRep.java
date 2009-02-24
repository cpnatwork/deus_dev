package deus.core.access.storage.api.account;

import deus.model.account.Account;

public interface AccountDoRep {


	public void addNewEntity(Account account);


	public Account getByNaturalId(String localUsername);


	public void updateEntity(Account account);


	public void deleteByNaturalId(String localUsername);

	
	public boolean existsAccount(String localUserName);


}
