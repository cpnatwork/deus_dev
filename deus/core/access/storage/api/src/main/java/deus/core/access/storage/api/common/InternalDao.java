package deus.core.access.storage.api.common;

import java.io.Serializable;

/**
 * A generic interface for DAO classes
 * 
 * The interface is parameterized by the DAO-managed entity type as well as the technical primary key type of the
 * entity.
 * 
 * @author cpn
 */
public interface InternalDao<TechEntityT, TechIdT extends Serializable, NaturalIdT extends Serializable> extends Dao<TechEntityT, NaturalIdT>, TechDao<TechEntityT, TechIdT> { 

}
