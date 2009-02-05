/**
 * 
 */
package deus.core.access.storage.common;

/**
 * @author cpn
 */
public interface Dao<DomT,KeyT> {
	/**
	 * CREATE of CRUD
	 * 
	 * @param domObj
	 * @return
	 */
    KeyT addNew(DomT domObj);
    
    /**
     * READ of CRUD
     * 
     * @param domObjKey
     * @return
     */
    DomT getById(KeyT domObjKey);
    
    // TODO: UPDATE of CRUD
    
    /**
     * DELETE of CRUD
     * 
     * @param domObjKey
     */
    void deleteById(KeyT domObjKey);

}
