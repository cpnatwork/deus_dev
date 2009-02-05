package deus.core.access.storage.user.impl;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Component;

import deus.core.access.storage.Dao;
import deus.core.access.storage.user.UserMetadataDao;
import deus.model.user.UserMetadata;

@Component
public class UserMetadataDaoHibernate extends HibernateDaoSupport implements
		Dao<UserMetadata,String>, UserMetadataDao {
	
	public String create(UserMetadata obj) {
		return (String) getHibernateTemplate().save(obj);
	}

	public void deleteById(String username) {
		UserMetadata bb = getById(username);
		getHibernateTemplate().delete(bb);
	}

	public UserMetadata getById(String username) {
		return (UserMetadata) getHibernateTemplate()
				.get(UserMetadata.class, username);
	}

}
