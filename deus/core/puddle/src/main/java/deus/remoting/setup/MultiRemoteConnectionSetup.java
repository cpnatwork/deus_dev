package deus.remoting.setup;

import deus.core.User;
import deus.model.user.transportid.TransportIdType;

public interface MultiRemoteConnectionSetup {

	public abstract void setUpConnection(User user, TransportIdType type);


	public abstract void tearDownConnection(User user, TransportIdType type);

	
}
