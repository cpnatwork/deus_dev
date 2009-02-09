package deus.core.access.storage.user.hibernate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Component;

import deus.core.access.storage.user.api.UserDao;
import deus.core.access.storage.user.model.UserMetadataPO;
import deus.core.access.storage.user.model.UserPO;
import deus.model.user.UserMetadata;
import deus.model.user.id.UserId;

/**
 * User DAO allows access to UserID and UserMetadata as a facade to the UserPO entities.
 * 
 * @author cpn
 * 
 */
@Component
public class UserDaoHibernateImpl extends HibernateDaoSupport implements UserDao {

	@Autowired
	InternalUserPoDaoHibernateImpl userPoDao = null;


	@Override
	public void addNewEntity(UserId userId) {
		UserPO userPO = new UserPO();
		userPO.setUserId(userId);
		// create default UserMetadata
		userPO.setUserMetadataPO(new UserMetadataPO());
		// save
		userPoDao.addNewEntity(userPO);
	}


	@Override
	public void deleteByNaturalId(String concPrimKey) {
		// TODO: how to delete the associated UserMetadata (CASCADE or programmatically)
		userPoDao.deleteByNaturalId(concPrimKey);
	}


	@Override
	public UserId getByNaturalId(String concPrimKey) {
		return userPoDao.getByNaturalId(concPrimKey).getUserId();
	}


	@Override
	public void updateEntity(UserId userId) {
		// redirect update to UserPO
		UserPO entity = userPoDao.getByNaturalId(userId.getId());
		entity.setUserId(userId);
		userPoDao.updateEntity(entity);
	}


	@Override
	public UserMetadata getUserMetadata(UserId userId) {
		return userPoDao.getByNaturalId(userId.getId()).getUserMetadataPO();
	}


	@Override
	public void updateUserMetadata(UserId userId, UserMetadata userMetadata) {
		// redirect update to UserPO
		UserPO entity = userPoDao.getByNaturalId(userId.getId());
		// change object attributes
		entity.getUserMetadataPO().update(userMetadata);
		userPoDao.updateEntity(entity);
	}

}
