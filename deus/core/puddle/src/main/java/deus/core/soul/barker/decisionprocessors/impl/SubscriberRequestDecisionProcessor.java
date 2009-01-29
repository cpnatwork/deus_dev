package deus.core.soul.barker.decisionprocessors.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;

import deus.core.soul.barker.decisionprocessors.DecisionProcessor;
import deus.core.soul.publisher.Publisher;
import deus.core.transport.command.Command;
import deus.core.transport.command.DenySubscriptionCommand;
import deus.core.transport.command.GrantSubscriptionCommand;
import deus.core.transport.commandexecutor.CommandExecutor;
import deus.model.attention.decision.SubscriberRequest;
import deus.model.user.UserMetadata;

@Configurable
public class SubscriberRequestDecisionProcessor implements DecisionProcessor<SubscriberRequest> {

	private final Publisher publisher;
	
	@Autowired
	private CommandExecutor commandExecutor;


	public SubscriberRequestDecisionProcessor(Publisher publisher) {
		super();
		this.publisher = publisher;
	}


	@Override
	public void process(SubscriberRequest subscriberRequest) {
		if (!subscriberRequest.isDecisionMade())
			throw new IllegalStateException("decision (" + subscriberRequest + ") is not made yet");

		UserMetadata subscriberMetadata = subscriberRequest.getSubscriberMetadata();
		
		Command command;
		if (subscriberRequest.isDecisionPositive()) {
			publisher.addObserver(subscriberMetadata);
	
			command = new GrantSubscriptionCommand();
		}
		else {
			// do not add observer
			
			command = new DenySubscriptionCommand();
		}
		
		command.setReceiverId(subscriberMetadata.getUserId());
		command.setSenderMetadata(publisher.getPublisherMetadata());
		
		commandExecutor.execute(command);
	}

}
