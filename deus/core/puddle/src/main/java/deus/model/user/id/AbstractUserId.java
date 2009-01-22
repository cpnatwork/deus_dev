package deus.model.user.id;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import deus.model.user.id.transportid.TransportId;
import deus.model.user.id.transportid.TransportIdType;

public abstract class AbstractUserId implements UserId {

	private Map<TransportIdType, TransportId> transportIds;


	public AbstractUserId() {
		transportIds = new HashMap<TransportIdType, TransportId>();
	}

	// TODO: think about setter
	public void setTransportIds(Map<TransportIdType, TransportId> transportIds) {
		this.transportIds = transportIds;
	}


	@Override
	public void addTransportId(TransportId transportId) {
		TransportId old = transportIds.put(transportId.getType(), transportId);
		if(old != null)
			throw new RuntimeException("a transportId of this type (" + transportId.getType() + ") has already been added!");
	}


	@Override
	public <T extends TransportId> T getTransportId(Class<T> transportIdClass) {
		TransportIdType type;
		try {
			TransportId transportId = transportIdClass.newInstance();
			Method getTypeMethod = transportIdClass.getMethod("getType", new Class[0]);
			type = (TransportIdType) getTypeMethod.invoke(transportId);
			if(type == null)
				throw new RuntimeException("cannot get type of class " + transportIdClass + " using method 'getType'");
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
		
		if(!transportIds.containsKey(type))
			// TODO: think about exception type
			throw new RuntimeException("no transport id for the type " + type + " available!");
		
		return (T) transportIds.get(type);
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((transportIds == null) ? 0 : transportIds.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AbstractUserId other = (AbstractUserId) obj;
		if (transportIds == null) {
			if (other.transportIds != null)
				return false;
		}
		else if (!transportIds.equals(other.transportIds))
			return false;
		return true;
	}

	public Map<TransportIdType, TransportId> getTransportIds() {
		return transportIds;
	}

}
