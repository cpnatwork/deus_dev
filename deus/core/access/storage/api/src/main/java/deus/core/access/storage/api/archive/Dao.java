package deus.core.access.storage.api.archive;

import java.io.Serializable;

/**
 * A generic interface for DAO classes
 * 
 * The interface is parameterized by the DAO-managed entity type as well as the conceptual primary key type of the
 * entity.
 * 
 * @author cpn
 */
public interface Dao<EntityT, NaturalIdT extends Serializable> {

	/**
	 * CREATE of CRUD
	 * 
	 * 
	 * 
	 * @param entity
	 * @return
	 */
	void addNewEntity(EntityT entity);


	/**
	 * READ of CRUD
	 * 
	 * @param naturalId
	 * @return
	 */
	EntityT getByNaturalId(NaturalIdT naturalId);


	/**
	 * UPDATE of CRUD
	 * 
	 * @param entity
	 */
	void updateEntity(EntityT entity);


	/**
	 * DELETE of CRUD
	 * 
	 * @param naturalId
	 */
	void deleteByNaturalId(NaturalIdT naturalId);

}
