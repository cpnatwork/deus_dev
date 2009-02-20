package deus.core.access.storage.common.hibernate;

import java.io.Serializable;

import javax.annotation.PostConstruct;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import deus.core.access.storage.common.InternalDao;

public class GenericInternalDaoImpl<TechEntityT, TechIdT extends Serializable, NaturalIdT extends Serializable> extends
		HibernateDaoSupport implements InternalDao<TechEntityT, TechIdT, NaturalIdT> {

	private Class<TechEntityT> entityPoType;

	@Autowired
	private SessionFactory sessionFactory;

	protected GenericInternalDaoImpl(Class<TechEntityT> entityPoType) {
		this.entityPoType = entityPoType;
		
	}

	@PostConstruct
    public void init() {
        setSessionFactory(sessionFactory);
    }

	@Override
	public void addNewEntity(TechEntityT entityPO) {
		getHibernateTemplate().save(entityPO);
	}


	@Override
	public void deleteByTechId(TechIdT techId) {
		TechEntityT entity = getByTechId(techId);
		getHibernateTemplate().delete(entity);
	}


	@SuppressWarnings("unchecked")
	@Override
	public TechEntityT getByTechId(TechIdT techId) {
		return (TechEntityT) getHibernateTemplate().get(entityPoType, techId);
	}


	@Override
	public void updateEntity(TechEntityT entityPO) {
		getHibernateTemplate().update(entityPO);
	}


	@Override
	public void deleteByNaturalId(NaturalIdT naturalId) {
		TechEntityT entity = getByNaturalId(naturalId);
		getHibernateTemplate().delete(entity);
	}


	@SuppressWarnings("unchecked")
	@Override
	public TechEntityT getByNaturalId(NaturalIdT naturalId) {
		Object entity = getSession().createCriteria(entityPoType).add(Restrictions.naturalId().set("id", naturalId))
				.setCacheable(true).uniqueResult();
		return (entity == null) ? null : (TechEntityT) entity;
	}
}
