package deus.core.access.storage.inmemory.publication;

import javax.inject.Named;

import deus.core.access.storage.api.publication.LosEntryDao;
import deus.core.access.storage.inmemory.GenericTwofoldIdDaoImpl;
import deus.model.common.user.frids.PublisherId;
import deus.model.common.user.frids.SubscriberId;
import deus.model.publication.LosEntry;

/**
 * @author cpn
 */
@Named("losEntryDao")
public class LosEntryDaoImpl extends GenericTwofoldIdDaoImpl<LosEntry, PublisherId, SubscriberId> implements LosEntryDao {

	@Override
	public void addNewEntity(PublisherId publisherId, LosEntry entry) {
		addNewEntity(publisherId, entry.getSubscriberId(), entry);
	}

	@Override
	public void updateEntity(PublisherId publisherId, LosEntry entry) {
		updateEntity(publisherId, entry.getSubscriberId(), entry);
	}

}
