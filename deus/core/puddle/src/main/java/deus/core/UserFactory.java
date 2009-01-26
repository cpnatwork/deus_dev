package deus.core;

import org.springframework.beans.factory.annotation.Autowired;

import deus.core.barker.Barker;
import deus.core.barker.decisionprocessors.SubscriberRequestDecisionProcessor;
import deus.core.barker.impl.DelegateDecisionProcessor;
import deus.core.publisher.Publisher;
import deus.core.publisher.RemoteCalledPublisher;
import deus.core.publisher.impl.PublisherBarkerProxy;
import deus.core.publisher.impl.PublisherImpl;
import deus.core.publisher.impl.RemoteCalledPublisherToPublisherAdapter;
import deus.core.subscriber.RemoteCalledSubscriber;
import deus.core.subscriber.Subscriber;
import deus.core.subscriber.impl.RemoteCalledSubscriberToSubscriberAdapter;
import deus.core.subscriber.impl.SubscriberBarkerProxy;
import deus.core.subscriber.impl.SubscriberImpl;
import deus.model.attention.AttentionList;
import deus.model.attention.decision.DecisionType;
import deus.model.pub.ListOfSubscribers;
import deus.model.sub.ListOfPublishers;
import deus.model.sub.PublisherMetadata;
import deus.model.user.id.UserId;
import deus.remoting.command.executor.impl.RemoteCommandExecutorImpl;
import deus.remoting.command.impl.SetupRemoteSendingRemoteCommandDecorator;
import deus.remoting.state.RemotingStateRegistry;
import deus.remoting.state.impl.RemotingStateRegistryImpl;
import deus.storage.attention.AttentionDao;
import deus.storage.pub.PubDao;
import deus.storage.sub.SubDao;
import deus.storage.user.UserMetadataDao;

public class UserFactory {

	@Autowired
	private AttentionDao attentionDao;
	
	@Autowired
	private PubDao pubDao;

	@Autowired
	private SubDao subDao;
	
	@Autowired
	private UserMetadataDao userMetadataDao;
	
	
	public User createUser(UserId userId) {
		User user = new User();
		
		user.userMetadata = userMetadataDao.getUserMetadata(userId);

		
		// REMOTING STATE REGISTRY
		user.remotingStateRegistry = new RemotingStateRegistryImpl();
		
		// REMOTE COMMAND EXECUTOR
		user.remoteCommandExecutor = new RemoteCommandExecutorImpl(user.remotingStateRegistry);
			// TODO: think about this cyclic dependency
		user.remoteCommandExecutor.setRemoteCommandDecorator(new SetupRemoteSendingRemoteCommandDecorator(user));
		
		
		// BARKER
		user.barker = new Barker();
		user.barker.setUnnoticedAttentionList(attentionDao.getUnnoticedAttentionList(userId));		
		user.barker.setNoticedAttentionList(attentionDao.getUnnoticedAttentionList(userId));
		
		// DECISSION PROCESSORS
		DelegateDecisionProcessor decisionProcessor = new DelegateDecisionProcessor();
		user.barker.setDecisionProcessor(decisionProcessor);
		
		SubscriberRequestDecisionProcessor sr = new SubscriberRequestDecisionProcessor(user.publisher, user.remoteCommandExecutor);
		decisionProcessor.addDecisionProcessor(sr, DecisionType.subscriberRequest);

		// PUBLISHER
		ListOfSubscribers los = pubDao.getListOfSubscribers(userId);
		PublisherImpl publisherImpl = new PublisherImpl(los, pubDao.getPublisherMetadata(userId), user.remoteCommandExecutor);
		RemoteCalledPublisher publisherBarkerProxy = new PublisherBarkerProxy(publisherImpl, user.barker);
		
		Publisher publisher = new RemoteCalledPublisherToPublisherAdapter(publisherBarkerProxy, publisherImpl);
		user.publisher = publisher;
		
		
		// SUBSCRIBER
		ListOfPublishers lop = pubDao.getListOfPublishers(userId);
		SubscriberImpl subscriberImpl = new SubscriberImpl(lop, subDao.getSubscriberMetadata(userId));
		RemoteCalledSubscriber subscriberBarkerProxy = new SubscriberBarkerProxy(subscriberImpl, user.barker);
		
		Subscriber subscriber = new RemoteCalledSubscriberToSubscriberAdapter(subscriberBarkerProxy, subscriberImpl);
		user.subscriber = subscriber;
				


		return user;
	}

}
