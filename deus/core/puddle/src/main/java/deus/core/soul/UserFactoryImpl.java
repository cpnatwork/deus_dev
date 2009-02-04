package deus.core.soul;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import deus.core.soul.barker.decisionprocessors.impl.DelegateDecisionProcessor;
import deus.core.soul.barker.decisionprocessors.impl.SubscriberRequestDecisionProcessor;
import deus.core.soul.barker.impl.BarkerImpl;
import deus.core.soul.publisher.Publisher;
import deus.core.soul.publisher.RemoteCalledPublisher;
import deus.core.soul.publisher.impl.PublisherBarkerProxy;
import deus.core.soul.publisher.impl.PublisherImpl;
import deus.core.soul.publisher.impl.RemoteCalledPublisherToPublisherAdapter;
import deus.core.soul.subscriber.RemoteCalledSubscriber;
import deus.core.soul.subscriber.Subscriber;
import deus.core.soul.subscriber.impl.RemoteCalledSubscriberToSubscriberAdapter;
import deus.core.soul.subscriber.impl.SubscriberBarkerProxy;
import deus.core.soul.subscriber.impl.SubscriberImpl;
import deus.model.attention.decision.DecisionType;
import deus.model.pub.ListOfSubscribers;
import deus.model.sub.ListOfPublishers;
import deus.model.user.id.UserId;
import deus.storage.attention.AttentionDao;
import deus.storage.pub.PubDao;
import deus.storage.sub.SubDao;
import deus.storage.user.UserMetadataDao;

@Component(value="userFactory")
public class UserFactoryImpl implements UserFactory {

	private final Logger logger = LoggerFactory.getLogger(BarkerImpl.class);
	
	@Autowired
	private AttentionDao attentionDao;

	@Autowired
	private PubDao pubDao;

	@Autowired
	private SubDao subDao;

	@Autowired
	private UserMetadataDao userMetadataDao;


	@Override
	public User createUser(String localUsername) {
		logger.error("creating user for username " + localUsername);
		
		User user = new User();
		
		// METADATA AND ID
		user.userMetadata = userMetadataDao.getUserMetadata(localUsername);
		UserId userId = user.getUserId();

		// BARKER
		user.barkerImpl = new BarkerImpl();
		user.barkerImpl.setUnnoticedAttentionList(attentionDao.getUnnoticedAttentionList(userId));
		user.barkerImpl.setNoticedAttentionList(attentionDao.getUnnoticedAttentionList(userId));

		// PUBLISHER
		ListOfSubscribers los = pubDao.getListOfSubscribers(userId);
		PublisherImpl publisherImpl = new PublisherImpl(los, userId);
		RemoteCalledPublisher publisherBarkerProxy = new PublisherBarkerProxy(publisherImpl, user.barkerImpl, los);

		Publisher publisher = new RemoteCalledPublisherToPublisherAdapter(publisherBarkerProxy, publisherImpl);
		user.publisher = publisher;


		// DECISION PROCESSORS
		DelegateDecisionProcessor decisionProcessor = new DelegateDecisionProcessor();
		user.barkerImpl.setDecisionProcessor(decisionProcessor);

		// don't use user.publisher here, since this one is proxied!
		SubscriberRequestDecisionProcessor sr = new SubscriberRequestDecisionProcessor(publisherImpl);
		decisionProcessor.addDecisionProcessor(sr, DecisionType.subscriberRequest);
		

		// SUBSCRIBER
		ListOfPublishers lop = subDao.getListOfPublishers(userId);
		SubscriberImpl subscriberImpl = new SubscriberImpl(lop, userId, user.getUserMetadata());
		RemoteCalledSubscriber subscriberBarkerProxy = new SubscriberBarkerProxy(subscriberImpl, user.barkerImpl, lop);

		Subscriber subscriber = new RemoteCalledSubscriberToSubscriberAdapter(subscriberBarkerProxy, subscriberImpl);
		user.subscriber = subscriber;


		return user;
	}
}
