/**************************************************************************
 * DACUS: Distributed Address Card Update System
 * ==============================================
 * Copyright (C) 2008-2012 by 
 *   - Christoph P. Neumann (http://www.chr15t0ph.de)
 *   - Florian Rampp
 **************************************************************************
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *     http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software 
 * distributed under the License is distributed on an "AS IS" BASIS, 
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and 
 * limitations under the License.
 **************************************************************************
 * $Id$
 *************************************************************************/
package deus.core.access.transfer.core.receiving;

import javax.inject.Inject;
import javax.inject.Named;

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

/**
 * The Class CallbackToSoulMessageReceiver.
 */
@Named("messageReceiver")
public class CallbackToSoulMessageReceiver implements MessageReceiver {

	/** The registry. */
	@Inject
	private SoulCallbackRegistry registry;

	// TODO: refactor (introduce more receive methods and dispatch in this one)
	/* (non-Javadoc)
	 * @see deus.core.access.transfer.common.protocol.messagereceiver.MessageReceiver#receive(deus.core.access.transfer.common.messages.TransferMessage)
	 */
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
