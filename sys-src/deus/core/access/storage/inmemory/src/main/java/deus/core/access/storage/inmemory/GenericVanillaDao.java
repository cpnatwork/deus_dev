package deus.core.access.storage.inmemory;

import java.io.Serializable;

/**
 * A generic interface for DAO classes
 * 
 * The interface is parameterized by the DAO-managed entity type as well as the conceptual primary key type of the
 * entity.
 * 
 * @author cpn
 */
public interface GenericVanillaDao<EntityT, NaturalIdT extends Serializable> {

	/**
	 * CREATE of CRUD
	 * 
	 * @param naturalId
	 * @param entity
	 */
	void addNewEntity(NaturalIdT naturalId, EntityT entity);

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
	void updateEntity(NaturalIdT naturalId, EntityT entity);

	/**
	 * DELETE of CRUD
	 * 
	 * @param naturalId
	 */
	void deleteByNaturalId(NaturalIdT naturalId);

	
	/**
	 * Existency Test
	 * 
	 * @param entity
	 */
	boolean existsByNaturalId(NaturalIdT naturalId);
}
