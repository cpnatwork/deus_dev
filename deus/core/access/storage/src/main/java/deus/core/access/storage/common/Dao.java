package deus.core.access.storage.common;

/**
 * A generic interface for DAO classes
 * 
 * The interface is parameterized by the DAO-managed entity type (= value object type) as well as 
 * the conceptual primary key type of the entity (= value object).
 * 
 * @author cpn
 */
public interface Dao<EntityT,ConcPrimKeyT> {
	/**
	 * CREATE of CRUD
	 * 
	 * 
	 * 
	 * @param valueObj
	 * @return
	 */
    ConcPrimKeyT addNew(EntityT valueObj);
    
    /**
     * READ of CRUD
     * 
     * @param valueObjKey
     * @return
     */
    EntityT getById(ConcPrimKeyT valueObjKey);
    
    // TODO: UPDATE of CRUD
    
    /**
     * DELETE of CRUD
     * 
     * @param valueObjKey
     */
    void deleteById(ConcPrimKeyT valueObjKey);

}
