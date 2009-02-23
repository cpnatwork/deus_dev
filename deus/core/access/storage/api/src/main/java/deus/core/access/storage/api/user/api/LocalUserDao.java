package deus.core.access.storage.api.user.api;

import deus.core.access.storage.api.common.Dao;
import deus.model.account.Account;
import deus.model.user.id.UserId;

/**
 * The DAO that allows access from simple local usernames to its UserId
 * 
 * @author cpn
 */
public interface LocalUserDao extends Dao<UserId,String>{

	void createAccount(Account account);

	boolean existsLocalUsername(String localUserName);

	void deleteAccount(UserId userId);

	Account getAccount(UserId userId);

}
