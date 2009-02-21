package deus.core.soul.subscriber.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import deus.core.access.storage.api.sub.api.SubDao;
import deus.core.access.storage.api.sub.model.ListOfPublishersImpl;
import deus.core.soul.subscriber.SubscriberExportedToClient;
import deus.gatekeeper.registrator.rolesetup.UserRoleSetupObserver;
import deus.model.depository.deus.impl.DistributedPatientFolderImpl;
import deus.model.sub.ListOfPublishers;
import deus.model.sub.LopEntry;
import deus.model.user.UserRole;
import deus.model.user.id.UserId;

//FIXME: add as observer to UserRoleSetup
@Component
public class SubscriberRoleSetupSubscriberObserver implements UserRoleSetupObserver {
	
	@Autowired
	private SubDao subDao;

	@Autowired
	@Qualifier("target")
	private SubscriberExportedToClient subscriber;


	@Override
	public void setUpRole(UserRole userRole, UserId userId) {
		assert (userRole.equals(UserRole.subscriber));

		subDao.addNewEntity(new ListOfPublishersImpl());
		// FIXME: which subtype of DIF to create here?
		subDao.createDistributedInformationFolder(new DistributedPatientFolderImpl());
	}


	@Override
	public void tearDownRole(UserRole userRole, UserId userId) {
		assert (userRole.equals(UserRole.subscriber));

		ListOfPublishers lop = subDao.getByNaturalId(userId);
		for (Map.Entry<UserId, LopEntry> entry : lop.entrySet()) {
			subscriber.unsubscribe(userId, entry.getKey());
		}

		subDao.deleteByNaturalId(userId);
		subDao.deleteDistributedInformationFolder(userId);
	}

}
