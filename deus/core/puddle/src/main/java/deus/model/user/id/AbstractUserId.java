package deus.model.user.id;

import java.util.List;

import deus.model.user.id.transportid.TransportId;

public abstract class AbstractUserId implements UserId {

	private List<TransportId> transportIds;


	// TODO: think about setter

	public List<TransportId> getTransportIds() {
		return transportIds;
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


}
