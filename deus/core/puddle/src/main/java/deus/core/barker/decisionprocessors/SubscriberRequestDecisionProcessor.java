package deus.core.barker.decisionprocessors;

import deus.core.barker.DecisionProcessor;
import deus.core.publisher.Publisher;
import deus.core.subscriber.SubscriberStub;
import deus.model.attention.decision.SubscriberRequest;
import deus.remoting.command.RemoteCommand;
import deus.remoting.command.impl.AbstractPublisherRemoteCommand;
import deus.remoting.commandexecutor.RemoteCommandExecutor;
import deus.remoting.state.RemotingStateRegistry;


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

			}, null);
			// FIXME: replace null with a real userId (above)
		}
		else {
			remoteCommandExecutor.execute(new AbstractPublisherRemoteCommand(subscriberRequest.getSubscriberMetadata()) {

				@Override
				protected void execute(SubscriberStub subscriberStub) {
					subscriberStub.denySubscription(publisher.getPublisherMetadata());
				}

			}, null);
			// FIXME: replace null with a real userId (above)
		}
	}

}
