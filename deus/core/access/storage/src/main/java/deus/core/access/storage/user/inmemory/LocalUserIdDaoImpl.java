package deus.core.access.storage.user.inmemory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import deus.core.access.storage.user.api.LocalUserDao;
import deus.core.access.storage.user.model.UserMetadataPO;
import deus.core.access.storage.user.model.UserPO;
import deus.model.user.id.UserId;


public class LocalUserIdDaoImpl implements LocalUserDao {

	@Override
	public void addNewEntity(UserId entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteByNaturalId(String naturalId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public UserId getByNaturalId(String naturalId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateEntity(UserId entity) {
		// TODO Auto-generated method stub
		
	}

}
