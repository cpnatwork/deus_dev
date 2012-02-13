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
public class GenericThreefoldIdDaoImpl<EntityT, NaturalIdFirstComponentT extends Serializable, NaturalIdSecondComponentT extends Serializable, NaturalIdThirdComponentT extends Serializable>
		implements
		GenericThreefoldIdDao<EntityT, NaturalIdFirstComponentT, NaturalIdSecondComponentT, NaturalIdThirdComponentT> {

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
				final NaturalIdFirstComponentT naturalIdFirstComponent,
				final NaturalIdSecondComponentT naturalIdSecondComponent,
				final NaturalIdThirdComponentT naturalIdThirdComponent) {
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

		/*
		 * (non-Javadoc)
		 * 
		 * @see java.lang.Object#hashCode()
		 */
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = (prime * result) + this.getOuterType().hashCode();
			result = (prime * result)
					+ ((this.naturalIdFirstComponent == null) ? 0
							: this.naturalIdFirstComponent.hashCode());
			result = (prime * result)
					+ ((this.naturalIdSecondComponent == null) ? 0
							: this.naturalIdSecondComponent.hashCode());
			result = (prime * result)
					+ ((this.naturalIdThirdComponent == null) ? 0
							: this.naturalIdThirdComponent.hashCode());
			return result;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see java.lang.Object#equals(java.lang.Object)
		 */
		@Override
		public boolean equals(final Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (this.getClass() != obj.getClass())
				return false;
			final ThreefoldNaturalId other = (ThreefoldNaturalId) obj;
			if (!this.getOuterType().equals(other.getOuterType()))
				return false;
			if (this.naturalIdFirstComponent == null) {
				if (other.naturalIdFirstComponent != null)
					return false;
			} else if (!this.naturalIdFirstComponent
					.equals(other.naturalIdFirstComponent))
				return false;
			if (this.naturalIdSecondComponent == null) {
				if (other.naturalIdSecondComponent != null)
					return false;
			} else if (!this.naturalIdSecondComponent
					.equals(other.naturalIdSecondComponent))
				return false;
			if (this.naturalIdThirdComponent == null) {
				if (other.naturalIdThirdComponent != null)
					return false;
			} else if (!this.naturalIdThirdComponent
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
		return this.storage;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * deus.core.access.storage.inmemory.GenericThreefoldIdDao#addNewEntity(
	 * java.io.Serializable, java.io.Serializable, java.io.Serializable,
	 * java.lang.Object)
	 */
	@Override
	public void addNewEntity(
			final NaturalIdFirstComponentT naturalIdFirstComponent,
			final NaturalIdSecondComponentT naturalIdSecondComponent,
			final NaturalIdThirdComponentT naturalIdThirdComponent,
			final EntityT entity) {
		final ThreefoldNaturalId threefoldNaturalId = new ThreefoldNaturalId(
				naturalIdFirstComponent, naturalIdSecondComponent,
				naturalIdThirdComponent);
		this.getStorage().put(threefoldNaturalId, entity);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * deus.core.access.storage.inmemory.GenericThreefoldIdDao#getByNaturalId
	 * (java.io.Serializable, java.io.Serializable, java.io.Serializable)
	 */
	@Override
	public EntityT getByNaturalId(
			final NaturalIdFirstComponentT naturalIdFirstComponent,
			final NaturalIdSecondComponentT naturalIdSecondComponent,
			final NaturalIdThirdComponentT naturalIdThirdComponent) {
		final ThreefoldNaturalId threefoldNaturalId = new ThreefoldNaturalId(
				naturalIdFirstComponent, naturalIdSecondComponent,
				naturalIdThirdComponent);
		return this.getStorage().get(threefoldNaturalId);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * deus.core.access.storage.inmemory.GenericThreefoldIdDao#updateEntity(
	 * java.io.Serializable, java.io.Serializable, java.io.Serializable,
	 * java.lang.Object)
	 */
	@Override
	public void updateEntity(
			final NaturalIdFirstComponentT naturalIdFirstComponent,
			final NaturalIdSecondComponentT naturalIdSecondComponent,
			final NaturalIdThirdComponentT naturalIdThirdComponent,
			final EntityT entity) {
		final ThreefoldNaturalId threefoldNaturalId = new ThreefoldNaturalId(
				naturalIdFirstComponent, naturalIdSecondComponent,
				naturalIdThirdComponent);
		this.getStorage().put(threefoldNaturalId, entity);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * deus.core.access.storage.inmemory.GenericThreefoldIdDao#deleteByNaturalId
	 * (java.io.Serializable, java.io.Serializable, java.io.Serializable)
	 */
	@Override
	public void deleteByNaturalId(
			final NaturalIdFirstComponentT naturalIdFirstComponent,
			final NaturalIdSecondComponentT naturalIdSecondComponent,
			final NaturalIdThirdComponentT naturalIdThirdComponent) {
		final ThreefoldNaturalId threefoldNaturalId = new ThreefoldNaturalId(
				naturalIdFirstComponent, naturalIdSecondComponent,
				naturalIdThirdComponent);
		assert (this.getStorage().containsKey(threefoldNaturalId));
		this.getStorage().remove(threefoldNaturalId);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * deus.core.access.storage.inmemory.GenericThreefoldIdDao#existsByNaturalId
	 * (java.io.Serializable, java.io.Serializable, java.io.Serializable)
	 */
	@Override
	public boolean existsByNaturalId(
			final NaturalIdFirstComponentT naturalIdFirstComponent,
			final NaturalIdSecondComponentT naturalIdSecondComponent,
			final NaturalIdThirdComponentT naturalIdThirdComponent) {
		final ThreefoldNaturalId threefoldNaturalId = new ThreefoldNaturalId(
				naturalIdFirstComponent, naturalIdSecondComponent,
				naturalIdThirdComponent);
		return this.getStorage().containsKey(threefoldNaturalId);
	}

}
