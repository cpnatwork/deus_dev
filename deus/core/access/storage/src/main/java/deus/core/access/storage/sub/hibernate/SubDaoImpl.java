package deus.core.access.storage.sub.hibernate;

import org.springframework.stereotype.Component;

import deus.core.access.storage.sub.api.SubDao;
import deus.core.access.storage.sub.inmemory.ListOfPublishersImpl;
import deus.model.sub.ListOfPublishers;
import deus.model.user.id.UserId;


public class SubDaoImpl implements SubDao {

	@Override
	public ListOfPublishers getListOfPublishers(UserId lopOwnerUserId) {
		// FIXME: legacy
		return new ListOfPublishersImpl();
	}

	@Override
	public UserId addNew(ListOfPublishers obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteById(UserId id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ListOfPublishers getById(UserId id) {
		// TODO Auto-generated method stub
		return null;
	}

}
