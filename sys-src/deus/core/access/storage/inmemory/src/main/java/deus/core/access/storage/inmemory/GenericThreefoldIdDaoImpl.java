package deus.core.access.storage.inmemory;

import java.io.Serializable;
import java.util.HashMap;

/**
 * A generic implementation for DAO classes
 * 
 * @author cpn
 */
public class GenericThreefoldIdDaoImpl<EntityT, NaturalIdFirstComponentT extends Serializable, NaturalIdSecondComponentT extends Serializable, NaturalIdThirdComponentT extends Serializable> implements GenericThreefoldIdDao<EntityT, NaturalIdFirstComponentT, NaturalIdSecondComponentT, NaturalIdThirdComponentT>{

	@SuppressWarnings("serial")
	private class ThreefoldNaturalId implements Serializable {
		public ThreefoldNaturalId(
				NaturalIdFirstComponentT naturalIdFirstComponent,
				NaturalIdSecondComponentT naturalIdSecondComponent,
				NaturalIdThirdComponentT naturalIdThirdComponent) {
			super();
			this.naturalIdFirstComponent = naturalIdFirstComponent;
			this.naturalIdSecondComponent = naturalIdSecondComponent;
			this.naturalIdThirdComponent = naturalIdThirdComponent;
		}
		NaturalIdFirstComponentT naturalIdFirstComponent = null;
		NaturalIdSecondComponentT naturalIdSecondComponent = null;
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
		@SuppressWarnings("unchecked")
		private GenericThreefoldIdDaoImpl getOuterType() {
			return GenericThreefoldIdDaoImpl.this;
		}
	}
	
	protected HashMap<ThreefoldNaturalId, EntityT> storage = new HashMap<ThreefoldNaturalId, EntityT>();
	
	protected HashMap<ThreefoldNaturalId, EntityT> getStorage() {
		return storage;
	}

	@Override
	public void addNewEntity(NaturalIdFirstComponentT naturalIdFirstComponent, NaturalIdSecondComponentT naturalIdSecondComponent, NaturalIdThirdComponentT naturalIdThirdComponent, EntityT entity) {
		ThreefoldNaturalId threefoldNaturalId = new ThreefoldNaturalId(naturalIdFirstComponent,naturalIdSecondComponent, naturalIdThirdComponent);
		getStorage().put(threefoldNaturalId, entity);
	}

	@Override
	public EntityT getByNaturalId(NaturalIdFirstComponentT naturalIdFirstComponent, NaturalIdSecondComponentT naturalIdSecondComponent, NaturalIdThirdComponentT naturalIdThirdComponent) {
		ThreefoldNaturalId threefoldNaturalId = new ThreefoldNaturalId(naturalIdFirstComponent,naturalIdSecondComponent, naturalIdThirdComponent);
		return getStorage().get(threefoldNaturalId);
	}

	@Override
	public void updateEntity(NaturalIdFirstComponentT naturalIdFirstComponent, NaturalIdSecondComponentT naturalIdSecondComponent, NaturalIdThirdComponentT naturalIdThirdComponent, EntityT entity) {
		ThreefoldNaturalId threefoldNaturalId = new ThreefoldNaturalId(naturalIdFirstComponent,naturalIdSecondComponent, naturalIdThirdComponent);
		getStorage().put(threefoldNaturalId, entity);
	}
	
	@Override
	public void deleteByNaturalId(NaturalIdFirstComponentT naturalIdFirstComponent, NaturalIdSecondComponentT naturalIdSecondComponent, NaturalIdThirdComponentT naturalIdThirdComponent) {
		ThreefoldNaturalId threefoldNaturalId = new ThreefoldNaturalId(naturalIdFirstComponent,naturalIdSecondComponent, naturalIdThirdComponent);
		assert(getStorage().containsKey(threefoldNaturalId));
		getStorage().remove(threefoldNaturalId);		
	}

	@Override
	public boolean existsByNaturalId(NaturalIdFirstComponentT naturalIdFirstComponent, NaturalIdSecondComponentT naturalIdSecondComponent, NaturalIdThirdComponentT naturalIdThirdComponent) {
		ThreefoldNaturalId threefoldNaturalId = new ThreefoldNaturalId(naturalIdFirstComponent,naturalIdSecondComponent, naturalIdThirdComponent);
		return getStorage().containsKey(threefoldNaturalId);
	}

}
