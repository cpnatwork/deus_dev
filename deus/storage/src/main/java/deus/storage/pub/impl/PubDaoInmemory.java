package deus.storage.pub.impl;

import org.springframework.stereotype.Component;

import deus.model.pub.ListOfSubscribers;
import deus.model.user.id.UserId;
import deus.storage.pub.PubDao;

@Component
public class PubDaoInmemory implements PubDao {

	@Override
	public ListOfSubscribers getListOfSubscribers(UserId losOwnerUserId) {
		// FIXME: legacy
		return new ListOfSubscribersImpl();
	}

	@Override
	public UserId create(ListOfSubscribers obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteById(UserId id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ListOfSubscribers getById(UserId id) {
		// TODO Auto-generated method stub
		return null;
	}

}
