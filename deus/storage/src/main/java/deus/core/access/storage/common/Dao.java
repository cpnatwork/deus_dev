/**
 * 
 */
package deus.core.access.storage.common;

/**
 * @author cpn
 */
public interface Dao<DomT,KeyT> {
    KeyT create(DomT obj);
    void deleteById(KeyT id);
    DomT getById(KeyT id);
}
