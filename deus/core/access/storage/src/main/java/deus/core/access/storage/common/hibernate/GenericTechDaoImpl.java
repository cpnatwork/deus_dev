package deus.core.access.storage.common.hibernate;

import java.io.Serializable;

import javax.annotation.PostConstruct;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import deus.core.access.storage.common.TechDao;

public class GenericTechDaoImpl<TechEntityT, TechIdT extends Serializable> extends HibernateDaoSupport implements
		TechDao<TechEntityT, TechIdT> {

	private Class<TechEntityT> entityPoType;

	@Autowired
	private SessionFactory sessionFactory;


	protected GenericTechDaoImpl(Class<TechEntityT> entityPoType) {
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

}
