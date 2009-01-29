package deus.core.transportOLD.setup;

import deus.core.soul.User;
import deus.model.user.transportid.TransportIdType;

public interface MultiRemoteConnectionSetup {

	public abstract void setUpConnection(User user, TransportIdType type);


	public abstract void tearDownConnection(User user, TransportIdType type);

	
}
