package deus.core.access.storage.user.hibernate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Component;

import deus.core.access.storage.api.user.api.LocalUserDao;
import deus.core.access.storage.api.user.api.UserDao;
import deus.core.access.storage.api.user.model.LocalUserPO;
import deus.core.access.storage.api.user.model.UserPO;
import deus.model.account.Account;
import deus.model.user.id.UserId;

@Component
public class LocalUserDaoHibernateImpl extends HibernateDaoSupport implements LocalUserDao {

	@Autowired
	UserDao userDao = null;

	@Autowired
	InternalUserPoDaoHibernateImpl userPoDao = null;

	@Autowired
	InternalLocalUserPoDaoHibernateImpl localUserPoDao = null;


	@Override
	public void addNewEntity(UserId userId) {
		// Create mandatory user (UserPO) tuples
		userDao.addNewEntity(userId);
		// connect UserPO with a new LocalUserPO
		UserPO userPO = userPoDao.getByNaturalId(userId.getId());
		LocalUserPO localUserPO = new LocalUserPO();
		localUserPO.setUserPO(userPO);
		getHibernateTemplate().save(localUserPO);
	}


	@Override
	public void deleteByNaturalId(String naturalId) {
		userPoDao.deleteByNaturalId(naturalId);
		localUserPoDao.deleteByNaturalId(naturalId);
	}


	@Override
	public UserId getByNaturalId(String naturalId) {
		return localUserPoDao.getByNaturalId(naturalId).getUserPO().getUserId();
	}


	@Override
	public void updateEntity(UserId userId) {
		// redirect update to UserPO
		UserPO entity = userPoDao.getByNaturalId(userId.getId());
		entity.setUserId(userId);
		userPoDao.updateEntity(entity);
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
