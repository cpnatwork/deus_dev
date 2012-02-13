package deus.core.access.storage.inmemory;

import java.io.Serializable;

/**
 * A generic interface for DAO classes with a two-part natural ID
 * 
 * @author cpn
 */
public interface GenericTwofoldIdDao<EntityT, NaturalIdFirstComponentT extends Serializable, NaturalIdSecondComponentT extends Serializable> {

	/**
	 * CREATE of CRUD
	 * 
	 * @param naturalId
	 * @param entity
	 */
	void addNewEntity(NaturalIdFirstComponentT naturalIdFirstComponent, NaturalIdSecondComponentT naturalIdSecondComponent, EntityT entity);

	/**
	 * READ of CRUD
	 * 
	 * @param naturalId
	 * @return
	 */
	EntityT getByNaturalId(NaturalIdFirstComponentT naturalIdFirstComponent, NaturalIdSecondComponentT naturalIdSecondComponent);

	/**
	 * UPDATE of CRUD
	 * 
	 * @param entity
	 */
	void updateEntity(NaturalIdFirstComponentT naturalIdFirstComponent, NaturalIdSecondComponentT naturalIdSecondComponent, EntityT entity);

	/**
	 * DELETE of CRUD
	 * 
	 * @param naturalId
	 */
	void deleteByNaturalId(NaturalIdFirstComponentT naturalIdFirstComponent, NaturalIdSecondComponentT naturalIdSecondComponent);

	
	/**
	 * Existency Test
	 * 
	 * @param entity
	 */
	boolean existsByNaturalId(NaturalIdFirstComponentT naturalIdFirstComponent, NaturalIdSecondComponentT naturalIdSecondComponent);
}
