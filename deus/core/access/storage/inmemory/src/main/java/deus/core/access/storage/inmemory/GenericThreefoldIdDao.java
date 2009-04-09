package deus.core.access.storage.inmemory;

import java.io.Serializable;

/**
 * A generic interface for DAO classes with a three-part natural ID
 * 
 * @author cpn
 */
public interface GenericThreefoldIdDao<EntityT, NaturalIdFirstComponentT extends Serializable, NaturalIdSecondComponentT extends Serializable, NaturalIdThirdComponentT extends Serializable> {

	/**
	 * CREATE of CRUD
	 * 
	 * @param naturalId
	 * @param entity
	 */
	void addNewEntity(NaturalIdFirstComponentT naturalIdFirstComponent, NaturalIdSecondComponentT naturalIdSecondComponent, NaturalIdThirdComponentT naturalIdThirdComponent, EntityT entity);

	/**
	 * READ of CRUD
	 * 
	 * @param naturalId
	 * @return
	 */
	EntityT getByNaturalId(NaturalIdFirstComponentT naturalIdFirstComponent, NaturalIdSecondComponentT naturalIdSecondComponent, NaturalIdThirdComponentT naturalIdThirdComponent);

	/**
	 * UPDATE of CRUD
	 * 
	 * @param entity
	 */
	void updateEntity(NaturalIdFirstComponentT naturalIdFirstComponent, NaturalIdSecondComponentT naturalIdSecondComponent, NaturalIdThirdComponentT naturalIdThirdComponent, EntityT entity);

	/**
	 * DELETE of CRUD
	 * 
	 * @param naturalId
	 */
	void deleteByNaturalId(NaturalIdFirstComponentT naturalIdFirstComponent, NaturalIdSecondComponentT naturalIdSecondComponent, NaturalIdThirdComponentT naturalIdThirdComponent);

	
	/**
	 * Existency Test
	 * 
	 * @param entity
	 */
	boolean existsByNaturalId(NaturalIdFirstComponentT naturalIdFirstComponent, NaturalIdSecondComponentT naturalIdSecondComponent, NaturalIdThirdComponentT naturalIdThirdComponent);
}
