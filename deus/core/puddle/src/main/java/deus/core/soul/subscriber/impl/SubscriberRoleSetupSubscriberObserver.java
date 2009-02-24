package deus.core.soul.subscriber.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import deus.core.access.storage.api.sub.api.LopDoRep;
import deus.core.soul.common.AbstractUserRoleSetupObserver;
import deus.core.soul.subscriber.SubscriberExportedToClient;
import deus.model.sub.ListOfPublishers;
import deus.model.sub.LopEntry;
import deus.model.user.UserRole;
import deus.model.user.id.UserId;

@Component
public class SubscriberRoleSetupSubscriberObserver extends AbstractUserRoleSetupObserver {
	
	@Autowired
	private LopDoRep lopDoRep;

	@Autowired
	@Qualifier("target")
	private SubscriberExportedToClient subscriber;


	@Override
	public void setUpRole(UserId userId) {
	}


	@Override
	public void tearDownRole(UserId userId) {
		ListOfPublishers lop = lopDoRep.getByNaturalId(userId);
		for (Map.Entry<UserId, LopEntry> entry : lop.entrySet()) {
			subscriber.unsubscribe(userId, entry.getKey());
		}
	}


	@Override
	protected UserRole getUserRole() {
		return UserRole.subscriber;
	}

}
