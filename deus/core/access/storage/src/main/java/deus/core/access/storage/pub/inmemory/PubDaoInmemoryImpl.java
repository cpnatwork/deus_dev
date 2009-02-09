package deus.core.access.storage.pub.inmemory;

import org.springframework.stereotype.Component;

import deus.core.access.storage.pub.api.PubDao;
import deus.model.pub.ListOfSubscribers;
import deus.model.user.id.UserId;

@Component
public class PubDaoInmemoryImpl implements PubDao {

	@Override
	public ListOfSubscribers getListOfSubscribers(UserId losOwnerUserId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addNewEntity(ListOfSubscribers entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteByNaturalId(UserId naturalId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ListOfSubscribers getByNaturalId(UserId naturalId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateEntity(ListOfSubscribers entity) {
		// TODO Auto-generated method stub
		
	}


}
