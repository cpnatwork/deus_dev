package deus.core.soul.subscription.rolesetup;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import deus.core.access.storage.api.sub.LopDoRep;
import deus.core.soul.accountadmin.rolesetup.AbstractDistributionRoleSetupObserver;
import deus.core.soul.subscription.SubscriberExportedToClient;
import deus.model.common.user.DistributionRole;
import deus.model.common.user.id.UserId;
import deus.model.subscription.ListOfPublishers;
import deus.model.subscription.LopEntry;

@Component
public class IcRoleSetupSubscriberObserver extends AbstractDistributionRoleSetupObserver {
	
	@Autowired
	private LopDoRep lopDoRep;

	@Autowired
	@Qualifier("target")
	private SubscriberExportedToClient subscriber;


	@Override
	public void setUpRole(UserId userId) {
		// FUTURE: init data objects in database for subsystem Subscriber here!
	}


	@Override
	public void tearDownRole(UserId userId) {
		ListOfPublishers lop = lopDoRep.getByNaturalId(userId);
		for (Map.Entry<UserId, LopEntry> entry : lop.entrySet()) {
			subscriber.unsubscribe(userId, entry.getKey());
		}
		
		// FUTURE: destroy data objects in database for subsystem Subscriber here!
	}


	@Override
	protected DistributionRole getDistributionRole() {
		return DistributionRole.informationConsumer;
	}

}
