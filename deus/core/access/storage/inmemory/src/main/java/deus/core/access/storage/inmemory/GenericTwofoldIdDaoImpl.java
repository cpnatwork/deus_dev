package deus.core.access.storage.inmemory;

import java.io.Serializable;
import java.util.HashMap;

/**
 * A generic implementation for DAO classes
 * 
 * @author cpn
 */
public class GenericTwofoldIdDaoImpl<EntityT, NaturalIdFirstComponentT extends Serializable, NaturalIdSecondComponentT extends Serializable> implements GenericTwofoldIdDao<EntityT, NaturalIdFirstComponentT, NaturalIdSecondComponentT>{

	@SuppressWarnings("serial")
	private class TwofoldNaturalId implements Serializable {
		public TwofoldNaturalId(
				NaturalIdFirstComponentT naturalIdFirstComponent,
				NaturalIdSecondComponentT naturalIdSecondComponent) {
			super();
			this.naturalIdFirstComponent = naturalIdFirstComponent;
			this.naturalIdSecondComponent = naturalIdSecondComponent;
		}
		NaturalIdFirstComponentT naturalIdFirstComponent = null;
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
		private GenericTwofoldIdDaoImpl getOuterType() {
			return GenericTwofoldIdDaoImpl.this;
		}
	}
	
	protected HashMap<TwofoldNaturalId, EntityT> storage = new HashMap<TwofoldNaturalId, EntityT>();
	
	protected HashMap<TwofoldNaturalId, EntityT> getStorage() {
		return storage;
	}

	@Override
	public void addNewEntity(NaturalIdFirstComponentT naturalIdFirstComponent, NaturalIdSecondComponentT naturalIdSecondComponent, EntityT entity) {
		TwofoldNaturalId twofoldNaturalId = new TwofoldNaturalId(naturalIdFirstComponent,naturalIdSecondComponent);
		getStorage().put(twofoldNaturalId, entity);
	}

	@Override
	public EntityT getByNaturalId(NaturalIdFirstComponentT naturalIdFirstComponent, NaturalIdSecondComponentT naturalIdSecondComponent) {
		TwofoldNaturalId twofoldNaturalId = new TwofoldNaturalId(naturalIdFirstComponent,naturalIdSecondComponent);
		return getStorage().get(twofoldNaturalId);
	}

	@Override
	public void updateEntity(NaturalIdFirstComponentT naturalIdFirstComponent, NaturalIdSecondComponentT naturalIdSecondComponent, EntityT entity) {
		TwofoldNaturalId twofoldNaturalId = new TwofoldNaturalId(naturalIdFirstComponent,naturalIdSecondComponent);
		getStorage().put(twofoldNaturalId, entity);
	}
	
	@Override
	public void deleteByNaturalId(NaturalIdFirstComponentT naturalIdFirstComponent, NaturalIdSecondComponentT naturalIdSecondComponent) {
		TwofoldNaturalId twofoldNaturalId = new TwofoldNaturalId(naturalIdFirstComponent,naturalIdSecondComponent);
		assert(getStorage().containsKey(twofoldNaturalId));
		getStorage().remove(twofoldNaturalId);		
	}

	@Override
	public boolean existsByNaturalId(NaturalIdFirstComponentT naturalIdFirstComponent, NaturalIdSecondComponentT naturalIdSecondComponent) {
		TwofoldNaturalId twofoldNaturalId = new TwofoldNaturalId(naturalIdFirstComponent,naturalIdSecondComponent);
		return getStorage().containsKey(twofoldNaturalId);
	}

}
