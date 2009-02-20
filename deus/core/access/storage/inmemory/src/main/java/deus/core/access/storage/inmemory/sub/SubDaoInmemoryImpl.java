package deus.core.access.storage.inmemory.sub;

import org.springframework.stereotype.Component;

import deus.core.access.storage.api.sub.api.SubDao;
import deus.model.depository.deus.impl.DistributedPatientFolderImpl;
import deus.model.depository.generic.DistributedInformationFolder;
import deus.model.sub.ListOfPublishers;
import deus.model.user.id.UserId;

@Component("subDao")
public class SubDaoInmemoryImpl implements SubDao {

	@Override
	public ListOfPublishers getListOfPublishers(UserId lopOwnerUserId) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public DistributedInformationFolder getDistributedInformationFolder(UserId userId) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void addNewEntity(ListOfPublishers entity) {
		// TODO Auto-generated method stub

	}


	@Override
	public void deleteByNaturalId(UserId naturalId) {
		// TODO Auto-generated method stub

	}


	@Override
	public ListOfPublishers getByNaturalId(UserId naturalId) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void updateEntity(ListOfPublishers entity) {
		// TODO Auto-generated method stub

	}


	@Override
	public void createDistributedInformationFolder(DistributedPatientFolderImpl distributedPatientFolderImpl) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void deleteDistributedInformationFolder(UserId userId) {
		// TODO Auto-generated method stub
		
	}

}
