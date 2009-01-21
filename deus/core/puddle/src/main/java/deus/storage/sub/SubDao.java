package deus.storage.sub;

import deus.model.pub.SubscriberMetadata;
import deus.model.user.id.UserId;

public interface SubDao {

	public SubscriberMetadata getSubscriberMetadata(UserId userId);

}
