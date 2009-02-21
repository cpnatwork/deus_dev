package deus.core.soul.publisher.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import deus.core.access.storage.api.pub.api.PubDao;
import deus.core.access.storage.api.pub.model.ListOfSubscribersImpl;
import deus.core.soul.publisher.PublisherExportedToClient;
import deus.gatekeeper.registrator.rolesetup.UserRoleSetupObserver;
import deus.model.pub.ListOfSubscribers;
import deus.model.pub.LosEntry;
import deus.model.user.UserRole;
import deus.model.user.id.UserId;

// FIXME: add as observer to UserRoleSetup
@Component
public class CpRoleSetupPublisherObserver implements UserRoleSetupObserver {

	@Autowired
	private PubDao pubDao;

	@Autowired
	private PublisherExportedToClient publisher;


	@Override
	public void setUpRole(UserRole userRole, UserId userId) {
		assert (userRole.equals(UserRole.cp));

		pubDao.addNewEntity(new ListOfSubscribersImpl());
	}


	@Override
	public void tearDownRole(UserRole userRole, UserId userId) {
		assert (userRole.equals(UserRole.cp));

		ListOfSubscribers los = pubDao.getByNaturalId(userId);
		for (Map.Entry<UserId, LosEntry> entry : los.entrySet()) {
			// FIXME: implement removing of all subscribers
			// publisher.
		}

		pubDao.deleteByNaturalId(userId);
	}

}
