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
 * @param <NaturalIdThirdComponentT>
 *            the generic type
 * @author cpn
 */
public class GenericThreefoldIdDaoImpl<EntityT, NaturalIdFirstComponentT extends Serializable, NaturalIdSecondComponentT extends Serializable, NaturalIdThirdComponentT extends Serializable> implements GenericThreefoldIdDao<EntityT, NaturalIdFirstComponentT, NaturalIdSecondComponentT, NaturalIdThirdComponentT>{

	/**
	 * The Class ThreefoldNaturalId.
	 */
	@SuppressWarnings("serial")
	private class ThreefoldNaturalId implements Serializable {
		
		/**
		 * Instantiates a new threefold natural id.
		 * 
		 * @param naturalIdFirstComponent
		 *            the natural id first component
		 * @param naturalIdSecondComponent
		 *            the natural id second component
		 * @param naturalIdThirdComponent
		 *            the natural id third component
		 */
		public ThreefoldNaturalId(
				NaturalIdFirstComponentT naturalIdFirstComponent,
				NaturalIdSecondComponentT naturalIdSecondComponent,
				NaturalIdThirdComponentT naturalIdThirdComponent) {
			super();
			this.naturalIdFirstComponent = naturalIdFirstComponent;
			this.naturalIdSecondComponent = naturalIdSecondComponent;
			this.naturalIdThirdComponent = naturalIdThirdComponent;
		}
		
		/** The natural id first component. */
		NaturalIdFirstComponentT naturalIdFirstComponent = null;
		
		/** The natural id second component. */
		NaturalIdSecondComponentT naturalIdSecondComponent = null;
		
		/** The natural id third component. */
		NaturalIdThirdComponentT naturalIdThirdComponent = null;
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
			result = prime
					* result
					+ ((naturalIdThirdComponent == null) ? 0
							: naturalIdThirdComponent.hashCode());
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
			ThreefoldNaturalId other = (ThreefoldNaturalId) obj;
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
			if (naturalIdThirdComponent == null) {
				if (other.naturalIdThirdComponent != null)
					return false;
			} else if (!naturalIdThirdComponent
					.equals(other.naturalIdThirdComponent))
				return false;
			return true;
		}
		
		/**
		 * Gets the outer type.
		 * 
		 * @return the outer type
		 */
		@SuppressWarnings("unchecked")
		private GenericThreefoldIdDaoImpl getOuterType() {
			return GenericThreefoldIdDaoImpl.this;
		}
	}
	
	/** The storage. */
	protected HashMap<ThreefoldNaturalId, EntityT> storage = new HashMap<ThreefoldNaturalId, EntityT>();
	
	/**
	 * Gets the storage.
	 * 
	 * @return the storage
	 */
	protected HashMap<ThreefoldNaturalId, EntityT> getStorage() {
		return storage;
	}

	/* (non-Javadoc)
	 * @see deus.core.access.storage.inmemory.GenericThreefoldIdDao#addNewEntity(java.io.Serializable, java.io.Serializable, java.io.Serializable, java.lang.Object)
	 */
	@Override
	public void addNewEntity(NaturalIdFirstComponentT naturalIdFirstComponent, NaturalIdSecondComponentT naturalIdSecondComponent, NaturalIdThirdComponentT naturalIdThirdComponent, EntityT entity) {
		ThreefoldNaturalId threefoldNaturalId = new ThreefoldNaturalId(naturalIdFirstComponent,naturalIdSecondComponent, naturalIdThirdComponent);
		getStorage().put(threefoldNaturalId, entity);
	}

	/* (non-Javadoc)
	 * @see deus.core.access.storage.inmemory.GenericThreefoldIdDao#getByNaturalId(java.io.Serializable, java.io.Serializable, java.io.Serializable)
	 */
	@Override
	public EntityT getByNaturalId(NaturalIdFirstComponentT naturalIdFirstComponent, NaturalIdSecondComponentT naturalIdSecondComponent, NaturalIdThirdComponentT naturalIdThirdComponent) {
		ThreefoldNaturalId threefoldNaturalId = new ThreefoldNaturalId(naturalIdFirstComponent,naturalIdSecondComponent, naturalIdThirdComponent);
		return getStorage().get(threefoldNaturalId);
	}

	/* (non-Javadoc)
	 * @see deus.core.access.storage.inmemory.GenericThreefoldIdDao#updateEntity(java.io.Serializable, java.io.Serializable, java.io.Serializable, java.lang.Object)
	 */
	@Override
	public void updateEntity(NaturalIdFirstComponentT naturalIdFirstComponent, NaturalIdSecondComponentT naturalIdSecondComponent, NaturalIdThirdComponentT naturalIdThirdComponent, EntityT entity) {
		ThreefoldNaturalId threefoldNaturalId = new ThreefoldNaturalId(naturalIdFirstComponent,naturalIdSecondComponent, naturalIdThirdComponent);
		getStorage().put(threefoldNaturalId, entity);
	}
	
	/* (non-Javadoc)
	 * @see deus.core.access.storage.inmemory.GenericThreefoldIdDao#deleteByNaturalId(java.io.Serializable, java.io.Serializable, java.io.Serializable)
	 */
	@Override
	public void deleteByNaturalId(NaturalIdFirstComponentT naturalIdFirstComponent, NaturalIdSecondComponentT naturalIdSecondComponent, NaturalIdThirdComponentT naturalIdThirdComponent) {
		ThreefoldNaturalId threefoldNaturalId = new ThreefoldNaturalId(naturalIdFirstComponent,naturalIdSecondComponent, naturalIdThirdComponent);
		assert(getStorage().containsKey(threefoldNaturalId));
		getStorage().remove(threefoldNaturalId);		
	}

	/* (non-Javadoc)
	 * @see deus.core.access.storage.inmemory.GenericThreefoldIdDao#existsByNaturalId(java.io.Serializable, java.io.Serializable, java.io.Serializable)
	 */
	@Override
	public boolean existsByNaturalId(NaturalIdFirstComponentT naturalIdFirstComponent, NaturalIdSecondComponentT naturalIdSecondComponent, NaturalIdThirdComponentT naturalIdThirdComponent) {
		ThreefoldNaturalId threefoldNaturalId = new ThreefoldNaturalId(naturalIdFirstComponent,naturalIdSecondComponent, naturalIdThirdComponent);
		return getStorage().containsKey(threefoldNaturalId);
	}

}
