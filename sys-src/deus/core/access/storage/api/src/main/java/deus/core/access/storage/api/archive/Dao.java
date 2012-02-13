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
package deus.core.access.storage.api.archive;

import java.io.Serializable;

/**
 * A generic interface for DAO classes
 * 
 * The interface is parameterized by the DAO-managed entity type as well as the
 * conceptual primary key type of the entity.
 * 
 * @param <EntityT>
 *            the generic type
 * @param <NaturalIdT>
 *            the generic type
 * @author cpn
 */
public interface Dao<EntityT, NaturalIdT extends Serializable> {

	/**
	 * CREATE of CRUD.
	 * 
	 * @param entity
	 *            the entity
	 */
	void addNewEntity(EntityT entity);

	/**
	 * READ of CRUD.
	 * 
	 * @param naturalId
	 *            the natural id
	 * @return the by natural id
	 */
	EntityT getByNaturalId(NaturalIdT naturalId);

	/**
	 * UPDATE of CRUD.
	 * 
	 * @param entity
	 *            the entity
	 */
	void updateEntity(EntityT entity);

	/**
	 * DELETE of CRUD.
	 * 
	 * @param naturalId
	 *            the natural id
	 */
	void deleteByNaturalId(NaturalIdT naturalId);

}
