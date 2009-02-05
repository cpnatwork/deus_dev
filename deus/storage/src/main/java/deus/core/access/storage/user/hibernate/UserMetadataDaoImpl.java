package deus.core.access.storage.user.hibernate;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Component;

import deus.core.access.storage.user.api.UserMetadataDao;
import deus.model.user.UserMetadata;
import deus.model.user.id.UserId;

@Component
public class UserMetadataDaoImpl extends HibernateDaoSupport implements UserMetadataDao {
	
//	public String addNew(UserMetadata obj) {
//		return (String) getHibernateTemplate().save(obj);
//	}
//
//	public void deleteById(String username) {
//		UserMetadata bb = getById(username);
//		getHibernateTemplate().delete(bb);
//	}
//
//	public UserMetadata getById(String username) {
//		return (UserMetadata) getHibernateTemplate()
//				.get(UserMetadata.class, username);
//	}

	@Override
	public void deleteById(UserId id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public UserMetadata getById(UserId id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserId addNew(UserMetadata obj) {
		// TODO Auto-generated method stub
		return null;
	}

}
