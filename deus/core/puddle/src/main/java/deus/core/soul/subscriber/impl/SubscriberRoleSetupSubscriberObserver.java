package deus.core.soul.subscriber.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import deus.core.access.storage.api.sub.api.LopEntryDao;
import deus.core.access.storage.api.sub.model.ListOfPublishersImpl;
import deus.core.soul.common.AbstractUserRoleSetupObserver;
import deus.core.soul.subscriber.SubscriberExportedToClient;
import deus.model.sub.ListOfPublishers;
import deus.model.sub.LopEntry;
import deus.model.sub.impl.DistributedInformationFolderImpl;
import deus.model.user.UserRole;
import deus.model.user.id.UserId;

@Component
public class SubscriberRoleSetupSubscriberObserver extends AbstractUserRoleSetupObserver {
	
	@Autowired
	private LopEntryDao lopEntryDao;

	@Autowired
	@Qualifier("target")
	private SubscriberExportedToClient subscriber;


	@Override
	public void setUpRole(UserId userId) {
		lopEntryDao.addNewEntity(new ListOfPublishersImpl());
		lopEntryDao.createDistributedInformationFolder(new DistributedInformationFolderImpl(userId));
	}


	@Override
	public void tearDownRole(UserId userId) {
		ListOfPublishers lop = lopEntryDao.getByNaturalId(userId);
		for (Map.Entry<UserId, LopEntry> entry : lop.entrySet()) {
			subscriber.unsubscribe(userId, entry.getKey());
		}

		lopEntryDao.deleteByNaturalId(userId);
		lopEntryDao.deleteDistributedInformationFolder(userId);
	}


	@Override
	protected UserRole getUserRole() {
		return UserRole.subscriber;
	}

}
