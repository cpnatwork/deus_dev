package deus.core.access.storage.sub.inmemory;

import org.springframework.stereotype.Component;

import deus.core.access.storage.sub.api.SubDao;
import deus.model.sub.ListOfPublishers;
import deus.model.user.id.UserId;

@Component
public class SubDaoInmemory implements SubDao {

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
