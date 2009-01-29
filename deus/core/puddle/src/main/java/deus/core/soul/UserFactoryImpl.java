package deus.core.soul;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import deus.core.soul.barker.Barker;
import deus.core.soul.barker.decisionprocessors.impl.DelegateDecisionProcessor;
import deus.core.soul.barker.decisionprocessors.impl.SubscriberRequestDecisionProcessor;
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
import deus.core.transport.commandexecutor.RemoteCommandExecutor;
import deus.core.transport.commandexecutor.impl.TransportProtocolChoosingRemoteCommandExecutor;
import deus.core.transport.setup.MultiRemoteSendingSetup;
import deus.core.transport.state.impl.RemotingStateRegistryImpl;
import deus.core.transport.tpchoosing.TransportProtocolChoosingStrategy;
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

	@Autowired
	private TransportProtocolChoosingStrategy transportProtocolChoosingStrategy;
	
	@Autowired
	MultiRemoteSendingSetup multiRemoteSendingSetup;
	
	@Autowired
	private AttentionDao attentionDao;

	@Autowired
	private PubDao pubDao;

	@Autowired
	private SubDao subDao;

	@Autowired
	private UserMetadataDao userMetadataDao;


	@Override
	public UserId createUserId(String localUsername) {
		return userMetadataDao.getUserId(localUsername);
	}
	

	@Override
	public User createUser(String localUsername) {
		User user = new User();
		
		// METADATA AND ID
		user.userMetadata = userMetadataDao.getUserMetadata(localUsername);
		UserId userId = user.getUserId();

		
		// REMOTING STATE REGISTRY
		user.remotingStateRegistry = new RemotingStateRegistryImpl();

		// REMOTE COMMAND EXECUTOR
		///MultiRemoteSendingSetupImpl remoteSendingSetup = new MultiRemoteSendingSetupImpl();
		///remoteSendingSetup.registerRemoteSendingSetup(new LocalRemoteSendingSetup());
		
		RemoteCommandExecutor commandExecutor = new TransportProtocolChoosingRemoteCommandExecutor(
				userId, user.remotingStateRegistry, transportProtocolChoosingStrategy, multiRemoteSendingSetup);
		user.remoteCommandExecutor = commandExecutor;


		// BARKER
		user.barker = new Barker();
		user.barker.setUnnoticedAttentionList(attentionDao.getUnnoticedAttentionList(userId));
		user.barker.setNoticedAttentionList(attentionDao.getUnnoticedAttentionList(userId));

		// PUBLISHER
		ListOfSubscribers los = pubDao.getListOfSubscribers(userId);
		PublisherImpl publisherImpl = new PublisherImpl(los, user.userMetadata, commandExecutor);
		RemoteCalledPublisher publisherBarkerProxy = new PublisherBarkerProxy(publisherImpl, user.barker);

		Publisher publisher = new RemoteCalledPublisherToPublisherAdapter(publisherBarkerProxy, publisherImpl);
		user.publisher = publisher;


		// DECISION PROCESSORS
		DelegateDecisionProcessor decisionProcessor = new DelegateDecisionProcessor();
		user.barker.setDecisionProcessor(decisionProcessor);

		// don't use user.publisher here, since this one is proxied!
		SubscriberRequestDecisionProcessor sr = new SubscriberRequestDecisionProcessor(publisherImpl, commandExecutor);
		decisionProcessor.addDecisionProcessor(sr, DecisionType.subscriberRequest);
		

		// SUBSCRIBER
		ListOfPublishers lop = subDao.getListOfPublishers(userId);
		SubscriberImpl subscriberImpl = new SubscriberImpl(lop, user.userMetadata, commandExecutor);
		RemoteCalledSubscriber subscriberBarkerProxy = new SubscriberBarkerProxy(subscriberImpl, user.barker);

		Subscriber subscriber = new RemoteCalledSubscriberToSubscriberAdapter(subscriberBarkerProxy, subscriberImpl);
		user.subscriber = subscriber;


		return user;
	}
}
