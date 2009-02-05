package deus.core.access.storage.user.inmemory;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Component;

import deus.core.access.storage.common.Dao;
import deus.core.access.storage.user.api.UserMetadataDao;
import deus.model.user.UserMetadata;

@Component
public class UserMetadataDaoImpl extends HibernateDaoSupport implements
		Dao<UserMetadata,String>, UserMetadataDao {

	@Override
	public String create(UserMetadata obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteById(String id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public UserMetadata getById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
