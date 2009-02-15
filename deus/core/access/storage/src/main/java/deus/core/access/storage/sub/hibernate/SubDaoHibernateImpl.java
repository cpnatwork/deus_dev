package deus.core.access.storage.sub.hibernate;

import deus.core.access.storage.sub.api.SubDao;
import deus.model.depository.generic.DistributedInformationFolder;
import deus.model.sub.ListOfPublishers;
import deus.model.user.id.UserId;


public class SubDaoHibernateImpl implements SubDao {

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

}
