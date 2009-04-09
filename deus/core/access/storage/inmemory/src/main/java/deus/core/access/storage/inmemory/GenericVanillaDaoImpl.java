package deus.core.access.storage.inmemory;

import java.io.Serializable;
import java.util.HashMap;

/**
 * A generic implementation for DAO classes
 * 
 * @author cpn
 */
public class GenericVanillaDaoImpl<EntityT, NaturalIdT extends Serializable> implements GenericVanillaDao<EntityT, NaturalIdT>{

	protected HashMap<NaturalIdT, EntityT> storage = new HashMap<NaturalIdT, EntityT>();
	
	protected HashMap<NaturalIdT, EntityT> getStorage() {
		return storage;
	}

	@Override
	public void addNewEntity(NaturalIdT naturalId, EntityT entity) {
		getStorage().put(naturalId, entity);
	}

	@Override
	public EntityT getByNaturalId(NaturalIdT naturalId) {
		return getStorage().get(naturalId);
	}

	@Override
	public void updateEntity(NaturalIdT naturalId, EntityT entity) {
		getStorage().put(naturalId, entity);
	}
	
	@Override
	public void deleteByNaturalId(NaturalIdT naturalId) {
		assert(getStorage().containsKey(naturalId));
		getStorage().remove(naturalId);		
	}

	@Override
	public boolean existsByNaturalId(NaturalIdT naturalId) {
		return getStorage().containsKey(naturalId);
	}





}
