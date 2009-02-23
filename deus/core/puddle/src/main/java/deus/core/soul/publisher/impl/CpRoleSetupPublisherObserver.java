package deus.core.soul.publisher.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import deus.core.access.storage.api.pub.api.PubDao;
import deus.core.access.storage.api.pub.model.ListOfSubscribersImpl;
import deus.core.soul.common.AbstractUserRoleSetupObserver;
import deus.core.soul.publisher.PublisherExportedToClient;
import deus.model.pub.ListOfSubscribers;
import deus.model.pub.LosEntry;
import deus.model.user.UserRole;
import deus.model.user.id.UserId;

@Component
public class CpRoleSetupPublisherObserver extends AbstractUserRoleSetupObserver {

	@Autowired
	private PubDao pubDao;

	@Autowired
	@Qualifier("target")
	private PublisherExportedToClient publisher;


	@Override
	public void setUpRole(UserId userId) {
		pubDao.addNewEntity(new ListOfSubscribersImpl());
	}


	@Override
	public void tearDownRole(UserId userId) {
		ListOfSubscribers los = pubDao.getByNaturalId(userId);
		for (Map.Entry<UserId, LosEntry> entry : los.entrySet()) {
			// FIXME: implement removing of all subscribers
			// publisher.
		}

		pubDao.deleteByNaturalId(userId);
	}


	@Override
	protected UserRole getUserRole() {
		return UserRole.cp;
	}

}
