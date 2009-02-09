package deus.core.access.storage.common;

import java.io.Serializable;

/**
 * A generic interface for DAO classes
 * 
 * The interface is parameterized by the DAO-managed entity type as well as the technical primary key type of the
 * entity.
 * 
 * @author cpn
 */
public interface TechDao<TechEntityT, TechIdT extends Serializable>{

	/**
	 * CREATE of CRUD
	 * 
	 * 
	 * 
	 * @param entityPO
	 * @return
	 */
	void addNewEntity(TechEntityT entityPO);


	/**
	 * READ of CRUD
	 * 
	 * @param techId
	 * @return
	 */
	TechEntityT getByTechId(TechIdT techId);


	/**
	 * UPDATE of CRUD
	 * 
	 * @param entityPO
	 */
	void updateEntity(TechEntityT entityPO);


	/**
	 * DELETE of CRUD
	 * 
	 * @param techId
	 */
	void deleteByTechId(TechIdT techId);

}
