package deus.core.access.storage.user.api;

import deus.core.access.storage.common.Dao;
import deus.model.user.id.UserId;

/**
 * The DAO that allows access from simple local usernames to its UserId
 * 
 * @author cpn
 */
public interface LocalUserDao extends Dao<UserId,String>{

}
