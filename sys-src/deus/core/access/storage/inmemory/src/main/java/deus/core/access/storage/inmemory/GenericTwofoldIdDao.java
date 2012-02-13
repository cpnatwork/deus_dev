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

/**
 * A generic interface for DAO classes with a two-part natural ID.
 * 
 * @param <EntityT>
 *            the generic type
 * @param <NaturalIdFirstComponentT>
 *            the generic type
 * @param <NaturalIdSecondComponentT>
 *            the generic type
 * @author cpn
 */
public interface GenericTwofoldIdDao<EntityT, NaturalIdFirstComponentT extends Serializable, NaturalIdSecondComponentT extends Serializable> {

	/**
	 * CREATE of CRUD.
	 * 
	 * @param naturalIdFirstComponent
	 *            the natural id first component
	 * @param naturalIdSecondComponent
	 *            the natural id second component
	 * @param entity
	 *            the entity
	 */
	void addNewEntity(NaturalIdFirstComponentT naturalIdFirstComponent,
			NaturalIdSecondComponentT naturalIdSecondComponent, EntityT entity);

	/**
	 * READ of CRUD.
	 * 
	 * @param naturalIdFirstComponent
	 *            the natural id first component
	 * @param naturalIdSecondComponent
	 *            the natural id second component
	 * @return the by natural id
	 */
	EntityT getByNaturalId(NaturalIdFirstComponentT naturalIdFirstComponent,
			NaturalIdSecondComponentT naturalIdSecondComponent);

	/**
	 * UPDATE of CRUD.
	 * 
	 * @param naturalIdFirstComponent
	 *            the natural id first component
	 * @param naturalIdSecondComponent
	 *            the natural id second component
	 * @param entity
	 *            the entity
	 */
	void updateEntity(NaturalIdFirstComponentT naturalIdFirstComponent,
			NaturalIdSecondComponentT naturalIdSecondComponent, EntityT entity);

	/**
	 * DELETE of CRUD.
	 * 
	 * @param naturalIdFirstComponent
	 *            the natural id first component
	 * @param naturalIdSecondComponent
	 *            the natural id second component
	 */
	void deleteByNaturalId(NaturalIdFirstComponentT naturalIdFirstComponent,
			NaturalIdSecondComponentT naturalIdSecondComponent);

	/**
	 * Existency Test.
	 * 
	 * @param naturalIdFirstComponent
	 *            the natural id first component
	 * @param naturalIdSecondComponent
	 *            the natural id second component
	 * @return true, if successful
	 */
	boolean existsByNaturalId(NaturalIdFirstComponentT naturalIdFirstComponent,
			NaturalIdSecondComponentT naturalIdSecondComponent);
}
