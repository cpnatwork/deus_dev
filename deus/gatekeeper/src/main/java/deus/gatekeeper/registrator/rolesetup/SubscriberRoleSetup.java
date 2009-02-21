package deus.gatekeeper.registrator.rolesetup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import deus.core.access.storage.api.sub.api.SubDao;
import deus.core.access.storage.api.sub.model.ListOfPublishersImpl;
import deus.model.depository.deus.impl.DistributedPatientFolderImpl;
import deus.model.user.UserRole;
import deus.model.user.id.UserId;

@Component
public class SubscriberRoleSetup implements UserRoleSetup {
	
	@Autowired
	private SubDao subDao;

	
	@Override
	public UserRole getUserRole() {
		return UserRole.subscriber;
	}


	@Override
	public void setUpRole(UserId userId) {
		subDao.addNewEntity(new ListOfPublishersImpl());
		// FIXME: which subtype of DIF to create here?
		subDao.createDistributedInformationFolder(new DistributedPatientFolderImpl());
	}


	@Override
	public void tearDownRole(UserId userId) {
		subDao.deleteByNaturalId(userId);
		subDao.deleteDistributedInformationFolder(userId);
	}

}
