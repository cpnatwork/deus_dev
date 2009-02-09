package deus.core.access.storage.sub.inmemory;

import org.springframework.stereotype.Component;

import deus.core.access.storage.sub.api.SubDao;
import deus.model.sub.ListOfPublishers;
import deus.model.user.id.UserId;

@Component
public class SubDaoInmemory implements SubDao {

	@Override
	public ListOfPublishers getListOfPublishers(UserId lopOwnerUserId) {
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
