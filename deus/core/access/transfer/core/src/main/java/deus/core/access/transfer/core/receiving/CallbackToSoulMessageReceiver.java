package deus.core.access.transfer.core.receiving;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import deus.core.access.transfer.common.messages.TransferMessage;
import deus.core.access.transfer.common.messages.publication.connection.establish.invite.ConfirmSubscriptionOfferNoticeMessage;
import deus.core.access.transfer.common.messages.publication.connection.establish.invite.InviteSubscriberMessage;
import deus.core.access.transfer.common.messages.publication.connection.establish.invite.OfferSubscriptionMessage;
import deus.core.access.transfer.common.messages.publication.connection.establish.invite.RepelSubscriptionOfferNoticeMessage;
import deus.core.access.transfer.common.messages.publication.connection.establish.subscribe.DenySubscriptionRequestNoticeMessage;
import deus.core.access.transfer.common.messages.publication.connection.establish.subscribe.GrantSubscriptionRequestNoticeMessage;
import deus.core.access.transfer.common.messages.publication.connection.establish.subscribe.RequestSubscriptionMessage;
import deus.core.access.transfer.common.messages.publication.connection.establish.subscribe.SubscribeToPublisherMessage;
import deus.core.access.transfer.common.messages.publication.connection.terminate.CancelSubscriptionMessage;
import deus.core.access.transfer.common.messages.publication.connection.terminate.UnsubscribeMessage;
import deus.core.access.transfer.common.messages.repatriation.ContributeMessage;
import deus.core.access.transfer.common.protocol.messagereceiver.MessageReceiver;
import deus.core.access.transfer.core.receiving.soulcallback.SoulCallbackRegistry;
import deus.core.access.transfer.core.receiving.soulcallback.publication.PublisherExportedToPeers;
import deus.core.access.transfer.core.receiving.soulcallback.repatriationhub.RepatriationHubExportedToPeers;
import deus.core.access.transfer.core.receiving.soulcallback.subscription.SubscriberExportedToPeers;
import deus.model.common.user.UserMetadata;
import deus.model.common.user.frids.ContributorId;
import deus.model.common.user.frids.PublisherId;
import deus.model.common.user.frids.RepatriationAuthorityId;
import deus.model.common.user.frids.SubscriberId;
import deus.model.common.user.id.UserId;

@Component("messageReceiver")
public class CallbackToSoulMessageReceiver implements MessageReceiver {

	@Autowired
	private SoulCallbackRegistry registry;

	// TODO: refactor (introduce more receive methods and dispatch in this one)
	@Override
	public void receive(TransferMessage message) {
		UserId senderId = message.getSenderId();
		UserId receiverId = message.getReceiverId();

		PublisherExportedToPeers publisher = registry.getPublisher();
		SubscriberExportedToPeers subscriber = registry.getSubscriber();
		
		RepatriationHubExportedToPeers repatriationHub = registry.getRepatriationHub();

		// +++ PUBLICATION COMM. +++
		
		// USE CASE: SUBSCRIBE
		if (message instanceof SubscribeToPublisherMessage) {
			// here: role publisher
			if (message instanceof RequestSubscriptionMessage) {
				UserMetadata senderMetadata = ((RequestSubscriptionMessage) message).getSubscriberMetadata();
				// USE CASE: accept subscription
				publisher.addSubscriber(new PublisherId(receiverId), new SubscriberId(senderId), senderMetadata);
			}
			// here: role informationConsumer
			else if (message instanceof GrantSubscriptionRequestNoticeMessage)
				subscriber.noticeSubscriptionRequestGranted(new SubscriberId(receiverId), new PublisherId(senderId));
			else if (message instanceof DenySubscriptionRequestNoticeMessage)
				subscriber.noticeSubscriptionRequestDenied(new SubscriberId(receiverId), new PublisherId(senderId));
			else
				throw new IllegalArgumentException("cannot handle command " + message);
		}
		// USE CASE: INVITE SUBSCRIBER
		else if(message instanceof InviteSubscriberMessage) {
			// here: role informationConsumer
			if (message instanceof OfferSubscriptionMessage) {
				UserMetadata senderMetadata = ((OfferSubscriptionMessage) message).getPublisherMetadata();
				// USE CASE: confirm subscription
				subscriber.addPublisher(new SubscriberId(receiverId), new PublisherId(senderId), senderMetadata);
			}
			// here: role publisher
			else if (message instanceof ConfirmSubscriptionOfferNoticeMessage)
				publisher.subscriptionConfirmed(new PublisherId(receiverId), new SubscriberId(senderId));
			else if (message instanceof RepelSubscriptionOfferNoticeMessage)
				publisher.subscriptionAbstained(new PublisherId(receiverId), new SubscriberId(senderId));
			else
				throw new IllegalArgumentException("cannot handle command " + message);
		}
		// USE CASE: UNSUBSCRIBE
		// here: role publisher
		else if (message instanceof UnsubscribeMessage)
			publisher.deleteSubscriber(new PublisherId(receiverId), new SubscriberId(senderId));
		// USE CASE: CANCEL SUBSCRIPTION
		else if (message instanceof CancelSubscriptionMessage)
			// FIXME: implement
			;
		
		// +++ REPATRIATION COMM. +++
		
		// USE CASE: CONTRIBUTE
		else if (message instanceof ContributeMessage) {
			repatriationHub.accept(
					new RepatriationAuthorityId(receiverId), new ContributorId(senderId),
					((ContributeMessage) message).getDcToContribute());
		}
		else
			throw new IllegalArgumentException("cannot handle command " + message);
	}
}
