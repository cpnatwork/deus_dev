package deus.core.soul.publication.rolesetup;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import deus.core.access.storage.api.pub.LosDoRep;
import deus.core.soul.accountadmin.rolesetup.AbstractDistributionRoleSetupObserver;
import deus.core.soul.publication.PublisherExportedToClient;
import deus.model.publication.ListOfSubscribers;
import deus.model.publication.LosEntry;
import deus.model.user.DistributionRole;
import deus.model.user.id.UserId;

@Component
public class CpRoleSetupPublisherObserver extends AbstractDistributionRoleSetupObserver {

	@Autowired
	private LosDoRep losDoRep;

	@Autowired
	@Qualifier("target")
	private PublisherExportedToClient publisher;


	@Override
	public void setUpRole(UserId userId) {
		// FUTURE: init data objects in database for subsystem Subscriber here!
	}


	@Override
	public void tearDownRole(UserId userId) {
		ListOfSubscribers los = losDoRep.getByNaturalId(userId);
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
