package deus.storage.sub.impl;

import org.springframework.stereotype.Component;

import deus.model.sub.ListOfPublishers;
import deus.model.user.id.UserId;
import deus.storage.sub.SubDao;

@Component
public class SubDaoHibernate implements SubDao {

	@Override
	public ListOfPublishers getListOfPublishers(UserId lopOwnerUserId) {
		// FIXME: legacy
		return new ListOfPublishersImpl();
	}

	@Override
	public UserId create(ListOfPublishers obj) {
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
