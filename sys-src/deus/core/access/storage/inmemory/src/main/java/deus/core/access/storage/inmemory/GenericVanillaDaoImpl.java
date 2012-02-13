/**************************************************************************
 * DACUS: Distributed Address Card Update System
 * ==============================================
 * Copyright (C) 2008-2012 by 
 *   - Christoph P. Neumann (http://www.chr15t0ph.de)
 *   - Florian Rampp
 **************************************************************************
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *     http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software 
 * distributed under the License is distributed on an "AS IS" BASIS, 
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and 
 * limitations under the License.
 **************************************************************************
 * $Id$
 *************************************************************************/
package deus.core.access.storage.inmemory;

import java.io.Serializable;
import java.util.HashMap;

/**
 * A generic implementation for DAO classes.
 * 
 * @param <EntityT>
 *            the generic type
 * @param <NaturalIdT>
 *            the generic type
 * @author cpn
 */
public class GenericVanillaDaoImpl<EntityT, NaturalIdT extends Serializable> implements
		GenericVanillaDao<EntityT, NaturalIdT> {

	/** The storage. */
	protected HashMap<NaturalIdT, EntityT> storage = new HashMap<NaturalIdT, EntityT>();


	/**
	 * Gets the storage.
	 * 
	 * @return the storage
	 */
	protected HashMap<NaturalIdT, EntityT> getStorage() {
		return storage;
	}


	/* (non-Javadoc)
	 * @see deus.core.access.storage.inmemory.GenericVanillaDao#addNewEntity(java.io.Serializable, java.lang.Object)
	 */
	@Override
	public void addNewEntity(NaturalIdT naturalId, EntityT entity) {
		getStorage().put(naturalId, entity);
	}


	/* (non-Javadoc)
	 * @see deus.core.access.storage.inmemory.GenericVanillaDao#getByNaturalId(java.io.Serializable)
	 */
	@Override
	public EntityT getByNaturalId(NaturalIdT naturalId) {
		return getStorage().get(naturalId);
	}


	/* (non-Javadoc)
	 * @see deus.core.access.storage.inmemory.GenericVanillaDao#updateEntity(java.io.Serializable, java.lang.Object)
	 */
	@Override
	public void updateEntity(NaturalIdT naturalId, EntityT entity) {
		getStorage().put(naturalId, entity);
	}


	/* (non-Javadoc)
	 * @see deus.core.access.storage.inmemory.GenericVanillaDao#deleteByNaturalId(java.io.Serializable)
	 */
	@Override
	public void deleteByNaturalId(NaturalIdT naturalId) {
		assert (getStorage().containsKey(naturalId));
		getStorage().remove(naturalId);
	}


	/* (non-Javadoc)
	 * @see deus.core.access.storage.inmemory.GenericVanillaDao#existsByNaturalId(java.io.Serializable)
	 */
	@Override
	public boolean existsByNaturalId(NaturalIdT naturalId) {
		return getStorage().containsKey(naturalId);
	}


}
