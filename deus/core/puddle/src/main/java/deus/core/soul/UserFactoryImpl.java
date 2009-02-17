package deus.core.soul;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import deus.core.access.storage.attention.api.AttentionDao;
import deus.core.access.storage.pub.api.PubDao;
import deus.core.access.storage.sub.api.SubDao;
import deus.core.access.storage.user.api.UserDao;
import deus.core.soul.barker.decisionprocessors.ContributionDecisionProcessor;
import deus.core.soul.barker.decisionprocessors.DelegateDecisionProcessor;
import deus.core.soul.barker.decisionprocessors.SubscriberRequestDecisionProcessor;
import deus.core.soul.barker.impl.BarkerImpl;
import deus.core.soul.contribution.counter.impl.ContributionCounterImpl;
import deus.core.soul.contribution.update.Updater;
import deus.core.soul.contribution.update.impl.UpdaterImpl;
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
import deus.model.depository.generic.DistributedInformationFolder;
import deus.model.dossier.generic.PersonalInformationFile;
import deus.model.pub.ListOfSubscribers;
import deus.model.sub.ListOfPublishers;
import deus.model.user.id.UserId;

@Component(value="userFactory")
public class UserFactoryImpl implements UserFactory {

	private final Logger logger = LoggerFactory.getLogger(UserFactoryImpl.class);
	
	@Autowired
	private AttentionDao attentionDao;

	@Autowired
	private PubDao pubDao;

	@Autowired
	private SubDao subDao;

	@Autowired
	private UserDao userDao;


	@Override
	public User createUser(UserId userId) {
		User user = new User();
		user.userId = userId;
		
		
		// METADATA AND ID
		user.userMetadata = userDao.getUserMetadata(userId);

		// BARKER
		user.barker = new BarkerImpl();
		user.barker.setUnnoticedAttentionList(attentionDao.getUnnoticedAttentionList(userId));
		user.barker.setNoticedAttentionList(attentionDao.getUnnoticedAttentionList(userId));

		// PUBLISHER
		ListOfSubscribers los = pubDao.getListOfSubscribers(userId);
		Publisher publisherTarget = new PublisherImpl(los, userId);
		RemoteCalledPublisher publisherBarkerProxy = new PublisherBarkerProxy(publisherTarget, user.barker, los);

		Publisher publisher = new RemoteCalledPublisherToPublisherAdapter(publisherBarkerProxy, publisherTarget);
		user.publisher = publisher;
		
		// CONTRIBUTION COUNTER
		// FIXME: load PIF from dao
		PersonalInformationFile pif = null;
		Updater updater = new UpdaterImpl(pif);		
		user.contributionCounter = new ContributionCounterImpl(user.userId, user.barker, updater);

		
		// DECISION PROCESSORS
		DelegateDecisionProcessor decisionProcessor = new DelegateDecisionProcessor();
		user.barker.setDecisionProcessor(decisionProcessor);

		// DP for subscriber request
		// don't use user.publisher here, since this one is proxied!
		SubscriberRequestDecisionProcessor sr = new SubscriberRequestDecisionProcessor(publisherTarget);
		decisionProcessor.addDecisionProcessor(sr, DecisionType.subscriberRequest);
		
		// DP for contribution
		ContributionDecisionProcessor cdr = new ContributionDecisionProcessor(updater);
		decisionProcessor.addDecisionProcessor(cdr, DecisionType.contribution);
		

		// SUBSCRIBER
		ListOfPublishers lop = subDao.getListOfPublishers(userId);
		DistributedInformationFolder distributedInformationFolder = subDao.getDistributedInformationFolder(userId);
		SubscriberImpl subscriberImpl = new SubscriberImpl(lop, userId, user.getUserMetadata(), distributedInformationFolder);
		RemoteCalledSubscriber subscriberBarkerProxy = new SubscriberBarkerProxy(subscriberImpl, user.barker, lop);

		Subscriber subscriber = new RemoteCalledSubscriberToSubscriberAdapter(subscriberBarkerProxy, subscriberImpl);
		user.subscriber = subscriber;


		return user;
	}
}
