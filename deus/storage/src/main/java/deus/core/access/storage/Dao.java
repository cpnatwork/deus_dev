/**
 * 
 */
package deus.core.access.storage;

/**
 * @author cpn
 */
public interface Dao<DomT,KeyT> {
    KeyT create(DomT obj);
    void deleteById(KeyT id);
    DomT getById(KeyT id);
}
