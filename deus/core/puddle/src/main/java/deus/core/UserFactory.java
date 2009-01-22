package deus.core;

import org.springframework.beans.factory.annotation.Autowired;

import deus.core.barker.Barker;
import deus.core.publisher.impl.PublisherImpl;
import deus.core.subscriber.impl.SubscriberImpl;
import deus.model.attention.AttentionList;
import deus.model.pub.ListOfSubscribers;
import deus.model.pub.SubscriberMetadata;
import deus.model.sub.PublisherMetadata;
import deus.model.user.id.UserId;
import deus.storage.attention.AttentionDao;
import deus.storage.pub.PubDao;
import deus.storage.sub.SubDao;
import deus.storage.user.UserMetadataDao;

public class UserFactory {

	@Autowired
	private AttentionDao attentionDao;
	
//	@Autowired
//	private PubDao pubDao;
//	
//	@Autowired
//	private SubDao subDao;
	
	@Autowired
	private UserMetadataDao userMetadataDao;
	
	
	public User createUser(UserId userId) {
		User user = new User();
		
		user.barker = new Barker();
		AttentionList attentionList = attentionDao.getAttentionList(userId);
		user.barker.setAttentionList(attentionList);
		
		
//		ListOfSubscribers los = pubDao.getListOfSubscribers(userId);
//		PublisherMetadata publisherMetadata = pubDao.getPublisherMetadata(userId);
//		user.publisher = new PublisherImpl(los, publisherMetadata);
//		
//		SubscriberMetadata subscriberMetadata = subDao.getSubscriberMetadata(userId);
//		user.subscriber = new SubscriberImpl(subscriberMetadata);
		
		user.userMetadata = userMetadataDao.getUserMetadata(userId);
		
		return user;
	}
	

}
