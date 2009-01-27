package deus.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import deus.core.barker.Barker;
import deus.core.barker.decisionprocessors.impl.DelegateDecisionProcessor;
import deus.core.barker.decisionprocessors.impl.SubscriberRequestDecisionProcessor;
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
import deus.model.attention.decision.DecisionType;
import deus.model.pub.ListOfSubscribers;
import deus.model.sub.ListOfPublishers;
import deus.model.user.id.UserId;
import deus.remoting.commandexecutor.RemoteCommandExecutor;
import deus.remoting.commandexecutor.impl.TransportProtocolChoosingRemoteCommandExecutor;
import deus.remoting.setup.MultiRemoteSendingSetup;
import deus.remoting.state.impl.RemotingStateRegistryImpl;
import deus.remoting.tpchoosing.TransportProtocolChoosingStrategy;
import deus.storage.attention.AttentionDao;
import deus.storage.pub.PubDao;
import deus.storage.sub.SubDao;
import deus.storage.user.UserMetadataDao;

@Component
public class UserFactory {

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


	public User createUser(UserId userId) {
		User user = new User();

		user.userMetadata = userMetadataDao.getUserMetadata(userId);


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
