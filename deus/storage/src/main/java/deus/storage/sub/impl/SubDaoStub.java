package deus.storage.sub.impl;

import org.springframework.stereotype.Component;

import deus.model.sub.ListOfPublishers;
import deus.model.sub.impl.ListOfPublishersImpl;
import deus.model.user.id.UserId;
import deus.storage.sub.SubDao;

@Component
public class SubDaoStub implements SubDao {

	@Override
	public ListOfPublishers getListOfPublishers(UserId userId) {
		return new ListOfPublishersImpl();
	}

}
