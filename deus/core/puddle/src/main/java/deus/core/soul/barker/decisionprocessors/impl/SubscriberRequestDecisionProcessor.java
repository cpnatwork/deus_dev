package deus.core.soul.barker.decisionprocessors.impl;

import deus.core.soul.barker.decisionprocessors.DecisionProcessor;
import deus.core.soul.publisher.Publisher;
import deus.core.soul.subscriber.stub.SubscriberStub;
import deus.core.transport.command.impl.AbstractPublisherRemoteCommand;
import deus.core.transport.commandexecutor.RemoteCommandExecutor;
import deus.model.attention.decision.SubscriberRequest;
import deus.model.user.UserMetadata;


public class SubscriberRequestDecisionProcessor implements DecisionProcessor<SubscriberRequest> {

	private final Publisher publisher;
	private final RemoteCommandExecutor remoteCommandExecutor;


	public SubscriberRequestDecisionProcessor(Publisher publisher, RemoteCommandExecutor remoteCommandExecutor) {
		super();
		this.publisher = publisher;
		this.remoteCommandExecutor = remoteCommandExecutor;
	}


	@Override
	public void process(SubscriberRequest subscriberRequest) {
		if (!subscriberRequest.isDecisionMade())
			throw new IllegalStateException("decision (" + subscriberRequest + ") is not made yet");

		UserMetadata subscriberMetadata = subscriberRequest.getSubscriberMetadata();
		
		if (subscriberRequest.isDecisionPositive()) {
			publisher.addObserver(subscriberMetadata);
						
			remoteCommandExecutor.execute(new AbstractPublisherRemoteCommand(subscriberMetadata.getUserId()) {

				@Override
				protected void execute(SubscriberStub subscriberStub) {
					subscriberStub.acknowledgeSubscription(publisher.getPublisherMetadata());
				}

			});
		}
		else {
			remoteCommandExecutor.execute(new AbstractPublisherRemoteCommand(subscriberMetadata.getUserId()) {

				@Override
				protected void execute(SubscriberStub subscriberStub) {
					subscriberStub.denySubscription(publisher.getPublisherMetadata());
				}

			});
		}
	}

}
