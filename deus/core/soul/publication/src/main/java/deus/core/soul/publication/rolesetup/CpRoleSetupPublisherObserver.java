package deus.core.soul.publication.rolesetup;

import java.util.Map;

import javax.inject.Inject;
import javax.inject.Named;

import deus.core.access.storage.api.publication.LosDao;
import deus.core.soul.accountadmin.rolesetup.AbstractDistributionRoleSetupObserver;
import deus.core.soul.publication.PublisherExportedToClient;
import deus.model.common.account.DistributionRole;
import deus.model.common.user.frids.PublisherId;
import deus.model.common.user.id.UserId;
import deus.model.publication.ListOfSubscribers;
import deus.model.publication.LosEntry;

@Named
public class CpRoleSetupPublisherObserver extends AbstractDistributionRoleSetupObserver {

	@Inject
	private LosDao losDao;

	@Inject
	@Named("targetedPublisher")
	private PublisherExportedToClient publisher;


	@Override
	public void setUpRole(UserId userId) {
		// FUTURE: init data objects in database for subsystem Subscriber here!
	}


	@Override
	public void tearDownRole(UserId userId) {
		PublisherId publisherId = new PublisherId(userId);		
		
		ListOfSubscribers los = losDao.getByNaturalId(publisherId);
		for (Map.Entry<UserId, LosEntry> entry : los.entrySet()) {
			// FIXME: implement removing of all subscribers
			// publisher.
		}

		// FUTURE: destroy data objects in database for subsystem Subscriber here!
	}


	@Override
	protected DistributionRole getDistributionRole() {
		return DistributionRole.concernedPerson;
	}

}
