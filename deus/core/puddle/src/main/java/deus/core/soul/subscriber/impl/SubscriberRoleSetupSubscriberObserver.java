package deus.core.soul.subscriber.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import deus.core.access.storage.api.sub.api.SubDao;
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
	private SubDao subDao;

	@Autowired
	@Qualifier("target")
	private SubscriberExportedToClient subscriber;


	@Override
	public void setUpRole(UserId userId) {
		subDao.addNewEntity(new ListOfPublishersImpl());
		subDao.createDistributedInformationFolder(new DistributedInformationFolderImpl(userId));
	}


	@Override
	public void tearDownRole(UserId userId) {
		ListOfPublishers lop = subDao.getByNaturalId(userId);
		for (Map.Entry<UserId, LopEntry> entry : lop.entrySet()) {
			subscriber.unsubscribe(userId, entry.getKey());
		}

		subDao.deleteByNaturalId(userId);
		subDao.deleteDistributedInformationFolder(userId);
	}


	@Override
	protected UserRole getUserRole() {
		return UserRole.subscriber;
	}

}
