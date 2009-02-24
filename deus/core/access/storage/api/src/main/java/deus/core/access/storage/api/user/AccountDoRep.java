package deus.core.access.storage.api.user;

import deus.model.account.Account;


public interface AccountDoRep {

	Account getByNaturalId(String localUsername);

	void updateEntity(Account account);

}
