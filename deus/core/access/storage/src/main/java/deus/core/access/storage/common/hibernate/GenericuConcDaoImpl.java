package deus.core.access.storage.common.hibernate;

import java.io.Serializable;

import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import deus.core.access.storage.common.Dao;

public class GenericuConcDaoImpl<EntityT, NaturalIdT extends Serializable> extends HibernateDaoSupport implements
		Dao<EntityT, NaturalIdT> {

	private Class<EntityT> entityType;


	protected GenericuConcDaoImpl(Class<EntityT> entityType) {
		this.entityType = entityType;
	}


	@Override
	public void addNewEntity(EntityT entity) {
		getHibernateTemplate().save(entity);
	}


	@Override
	public void deleteByNaturalId(NaturalIdT naturalId) {
		EntityT entity = getByNaturalId(naturalId);
		getHibernateTemplate().delete(entity);
	}


	@SuppressWarnings("unchecked")
	@Override
	public EntityT getByNaturalId(NaturalIdT naturalId) {
		Object entity = getSession().createCriteria(entityType).add(Restrictions.naturalId().set("id", naturalId))
				.setCacheable(true).uniqueResult();
		return (entity == null) ? null : (EntityT) entity;
	}


	@Override
	public void updateEntity(EntityT entity) {
		getHibernateTemplate().update(entity);
	}

}
