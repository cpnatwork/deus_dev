package deus.core.gatekeeper.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import deus.core.User;
import deus.core.gatekeeper.Gatekeeper;
import deus.model.user.id.UserId;
import deus.model.user.id.UserIdType;
import deus.remoting.initializerdestroyer.InitializerDestroyer;

public class InitDestroyGatekeeperDecorator<InitializerDestroyerType extends InitializerDestroyer> extends AbstractGatekeeperDecorator<InitializerDestroyerType> {

	@Autowired
	@Qualifier("gatekeeper")
	private Map<UserIdType, InitializerDestroyerType> initializerDestroyers;


	public InitDestroyGatekeeperDecorator(Gatekeeper decoratedGatekeeper) {
		super(decoratedGatekeeper);
	}


	@Override
	protected void doAfterLogin(User user) {
		// INITIALIZE
		UserId userId = user.getUserMetadata().getUserId();
		UserIdType userIdType = userId.getType();
		InitializerDestroyerType initializer = getInitializerDestroyer(userIdType);
		if (initializer == null)
			// TODO: think about the type of this exception
			throw new RuntimeException("cannot initialize remoting for user with id " + userId
					+ " because there is no RemotingInitializerDestroyer registered for handling this id type");

		initializer.setUp(user);
	}


	@Override
	protected void doBeforeLogout(User user) {
		// DESTROY
		UserId userId = user.getUserMetadata().getUserId();
		UserIdType userIdType = userId.getType();
		InitializerDestroyerType destroyer = getInitializerDestroyer(userIdType);
		if (destroyer == null)
			// TODO: think about the type of this exception
			throw new RuntimeException("cannot destroy remoting for user with id " + userId
					+ " because there is no RemotingInitializerDestroyer registered for handling this id type");

		destroyer.tearDown(user);
	}


	protected final InitializerDestroyerType getInitializerDestroyer(UserIdType userIdType) {
		return initializerDestroyers.get(userIdType);
	}

}
