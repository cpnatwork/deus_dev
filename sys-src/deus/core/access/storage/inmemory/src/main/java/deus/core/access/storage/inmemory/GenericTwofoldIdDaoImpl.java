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
 * @param <NaturalIdFirstComponentT>
 *            the generic type
 * @param <NaturalIdSecondComponentT>
 *            the generic type
 * @author cpn
 */
public class GenericTwofoldIdDaoImpl<EntityT, NaturalIdFirstComponentT extends Serializable, NaturalIdSecondComponentT extends Serializable> implements GenericTwofoldIdDao<EntityT, NaturalIdFirstComponentT, NaturalIdSecondComponentT>{

	/**
	 * The Class TwofoldNaturalId.
	 */
	@SuppressWarnings("serial")
	private class TwofoldNaturalId implements Serializable {
		
		/**
		 * Instantiates a new twofold natural id.
		 * 
		 * @param naturalIdFirstComponent
		 *            the natural id first component
		 * @param naturalIdSecondComponent
		 *            the natural id second component
		 */
		public TwofoldNaturalId(
				NaturalIdFirstComponentT naturalIdFirstComponent,
				NaturalIdSecondComponentT naturalIdSecondComponent) {
			super();
			this.naturalIdFirstComponent = naturalIdFirstComponent;
			this.naturalIdSecondComponent = naturalIdSecondComponent;
		}
		
		/** The natural id first component. */
		NaturalIdFirstComponentT naturalIdFirstComponent = null;
		
		/** The natural id second component. */
		NaturalIdSecondComponentT naturalIdSecondComponent = null;
		/* (non-Javadoc)
		 * @see java.lang.Object#hashCode()
		 */
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getOuterType().hashCode();
			result = prime
					* result
					+ ((naturalIdFirstComponent == null) ? 0
							: naturalIdFirstComponent.hashCode());
			result = prime
					* result
					+ ((naturalIdSecondComponent == null) ? 0
							: naturalIdSecondComponent.hashCode());
			return result;
		}
		/* (non-Javadoc)
		 * @see java.lang.Object#equals(java.lang.Object)
		 */
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			TwofoldNaturalId other = (TwofoldNaturalId) obj;
			if (!getOuterType().equals(other.getOuterType()))
				return false;
			if (naturalIdFirstComponent == null) {
				if (other.naturalIdFirstComponent != null)
					return false;
			} else if (!naturalIdFirstComponent
					.equals(other.naturalIdFirstComponent))
				return false;
			if (naturalIdSecondComponent == null) {
				if (other.naturalIdSecondComponent != null)
					return false;
			} else if (!naturalIdSecondComponent
					.equals(other.naturalIdSecondComponent))
				return false;
			return true;
		}
		
		/**
		 * Gets the outer type.
		 * 
		 * @return the outer type
		 */
		private GenericTwofoldIdDaoImpl getOuterType() {
			return GenericTwofoldIdDaoImpl.this;
		}
	}
	
	/** The storage. */
	protected HashMap<TwofoldNaturalId, EntityT> storage = new HashMap<TwofoldNaturalId, EntityT>();
	
	/**
	 * Gets the storage.
	 * 
	 * @return the storage
	 */
	protected HashMap<TwofoldNaturalId, EntityT> getStorage() {
		return storage;
	}

	/* (non-Javadoc)
	 * @see deus.core.access.storage.inmemory.GenericTwofoldIdDao#addNewEntity(java.io.Serializable, java.io.Serializable, java.lang.Object)
	 */
	@Override
	public void addNewEntity(NaturalIdFirstComponentT naturalIdFirstComponent, NaturalIdSecondComponentT naturalIdSecondComponent, EntityT entity) {
		TwofoldNaturalId twofoldNaturalId = new TwofoldNaturalId(naturalIdFirstComponent,naturalIdSecondComponent);
		getStorage().put(twofoldNaturalId, entity);
	}

	/* (non-Javadoc)
	 * @see deus.core.access.storage.inmemory.GenericTwofoldIdDao#getByNaturalId(java.io.Serializable, java.io.Serializable)
	 */
	@Override
	public EntityT getByNaturalId(NaturalIdFirstComponentT naturalIdFirstComponent, NaturalIdSecondComponentT naturalIdSecondComponent) {
		TwofoldNaturalId twofoldNaturalId = new TwofoldNaturalId(naturalIdFirstComponent,naturalIdSecondComponent);
		return getStorage().get(twofoldNaturalId);
	}

	/* (non-Javadoc)
	 * @see deus.core.access.storage.inmemory.GenericTwofoldIdDao#updateEntity(java.io.Serializable, java.io.Serializable, java.lang.Object)
	 */
	@Override
	public void updateEntity(NaturalIdFirstComponentT naturalIdFirstComponent, NaturalIdSecondComponentT naturalIdSecondComponent, EntityT entity) {
		TwofoldNaturalId twofoldNaturalId = new TwofoldNaturalId(naturalIdFirstComponent,naturalIdSecondComponent);
		getStorage().put(twofoldNaturalId, entity);
	}
	
	/* (non-Javadoc)
	 * @see deus.core.access.storage.inmemory.GenericTwofoldIdDao#deleteByNaturalId(java.io.Serializable, java.io.Serializable)
	 */
	@Override
	public void deleteByNaturalId(NaturalIdFirstComponentT naturalIdFirstComponent, NaturalIdSecondComponentT naturalIdSecondComponent) {
		TwofoldNaturalId twofoldNaturalId = new TwofoldNaturalId(naturalIdFirstComponent,naturalIdSecondComponent);
		assert(getStorage().containsKey(twofoldNaturalId));
		getStorage().remove(twofoldNaturalId);		
	}

	/* (non-Javadoc)
	 * @see deus.core.access.storage.inmemory.GenericTwofoldIdDao#existsByNaturalId(java.io.Serializable, java.io.Serializable)
	 */
	@Override
	public boolean existsByNaturalId(NaturalIdFirstComponentT naturalIdFirstComponent, NaturalIdSecondComponentT naturalIdSecondComponent) {
		TwofoldNaturalId twofoldNaturalId = new TwofoldNaturalId(naturalIdFirstComponent,naturalIdSecondComponent);
		return getStorage().containsKey(twofoldNaturalId);
	}

}
