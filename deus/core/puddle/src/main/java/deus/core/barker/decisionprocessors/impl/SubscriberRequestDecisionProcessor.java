package deus.core.barker.decisionprocessors.impl;

import deus.core.barker.decisionprocessors.DecisionProcessor;
import deus.core.publisher.Publisher;
import deus.core.subscriber.stub.SubscriberStub;
import deus.model.attention.decision.SubscriberRequest;
import deus.remoting.command.impl.AbstractPublisherRemoteCommand;
import deus.remoting.commandexecutor.RemoteCommandExecutor;


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

		if (subscriberRequest.isDecisionPositive()) {
			publisher.addObserver(subscriberRequest.getSubscriberMetadata());

			remoteCommandExecutor.execute(new AbstractPublisherRemoteCommand(subscriberRequest.getSubscriberMetadata()) {

				@Override
				protected void execute(SubscriberStub subscriberStub) {
					subscriberStub.acknowledgeSubscription(publisher.getPublisherMetadata());
				}

			});
		}
		else {
			remoteCommandExecutor.execute(new AbstractPublisherRemoteCommand(subscriberRequest.getSubscriberMetadata()) {

				@Override
				protected void execute(SubscriberStub subscriberStub) {
					subscriberStub.denySubscription(publisher.getPublisherMetadata());
				}

			});
		}
	}

}
