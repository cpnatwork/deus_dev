package deus.core.access.storage.inmemory.sub;

import org.springframework.stereotype.Component;

import deus.core.access.storage.api.sub.api.LopEntryDao;
import deus.model.sub.DistributedInformationFolder;
import deus.model.sub.ListOfPublishers;
import deus.model.user.id.UserId;

@Component("subDao")
public class SubDaoInmemoryImpl implements LopEntryDao {

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
	public void createDistributedInformationFolder(DistributedInformationFolder distributedInformationFolder) {
		// TODO Auto-generated method stub

	}


	@Override
	public void deleteDistributedInformationFolder(UserId userId) {
		// TODO Auto-generated method stub

	}


}
