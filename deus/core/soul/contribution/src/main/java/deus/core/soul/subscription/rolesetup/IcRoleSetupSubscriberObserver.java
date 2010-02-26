package deus.core.soul.subscription.rolesetup;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import deus.core.access.storage.api.subscription.LopDao;
import deus.core.soul.accountadmin.rolesetup.AbstractDistributionRoleSetupObserver;
import deus.core.soul.subscription.SubscriberExportedToClient;
import deus.model.common.account.DistributionRole;
import deus.model.common.user.frids.PublisherId;
import deus.model.common.user.frids.SubscriberId;
import deus.model.common.user.id.UserId;
import deus.model.subscription.ListOfPublishers;
import deus.model.subscription.LopEntry;

@Component
public class IcRoleSetupSubscriberObserver extends AbstractDistributionRoleSetupObserver {
	
	@Autowired
	private LopDao lopDao;

	@Autowired
	@Qualifier("target")
	private SubscriberExportedToClient subscriber;


	@Override
	public void setUpRole(UserId userId) {
		// FUTURE: init data objects in database for subsystem Subscriber here!
	}


	@Override
	public void tearDownRole(UserId userId) {
		ListOfPublishers lop = lopDao.getByNaturalId(new SubscriberId(userId));
		for (Map.Entry<UserId, LopEntry> entry : lop.entrySet()) {
			subscriber.unsubscribe(new SubscriberId(userId), new PublisherId(entry.getKey()));
		}
		
		// FUTURE: destroy data objects in database for subsystem Subscriber here!
	}


	@Override
	protected DistributionRole getDistributionRole() {
		return DistributionRole.informationConsumer;
	}

}
