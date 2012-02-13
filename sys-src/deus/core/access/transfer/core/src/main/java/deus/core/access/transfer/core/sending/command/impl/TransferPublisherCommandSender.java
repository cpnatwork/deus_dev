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
package deus.core.access.transfer.core.sending.command.impl;

import javax.inject.Inject;
import javax.inject.Named;

import deus.core.access.transfer.common.messages.TransferMessage;
import deus.core.access.transfer.common.messages.publication.UpdateMessage;
import deus.core.access.transfer.common.messages.publication.connection.establish.invite.OfferSubscriptionMessage;
import deus.core.access.transfer.common.messages.publication.connection.establish.subscribe.DenySubscriptionRequestNoticeMessage;
import deus.core.access.transfer.common.messages.publication.connection.establish.subscribe.GrantSubscriptionRequestNoticeMessage;
import deus.core.access.transfer.common.messages.publication.connection.terminate.CancelSubscriptionMessage;
import deus.core.access.transfer.core.sending.command.PublisherCommandSender;
import deus.model.common.dossier.DigitalCard;
import deus.model.common.user.UserMetadata;
import deus.model.common.user.frids.PublisherId;
import deus.model.common.user.frids.SubscriberId;

/**
 * The Class TransferPublisherCommandSender.
 */
@Named("publisherCommandSender")
public class TransferPublisherCommandSender implements PublisherCommandSender {
	
	/** The transfer message sender helper. */
	@Inject
	private TransferMessageSenderHelper transferMessageSenderHelper;


	/* (non-Javadoc)
	 * @see deus.core.access.transfer.core.sending.command.PublisherCommandSender#update(deus.model.common.user.frids.PublisherId, deus.model.common.user.frids.SubscriberId, deus.model.common.dossier.DigitalCard)
	 */
	@Override
	public void update(PublisherId publisherId, SubscriberId subscriberId, DigitalCard digitalCard) {
		TransferMessage transferMessage = new UpdateMessage(digitalCard);
		transferMessageSenderHelper.send(subscriberId.getUserId(), publisherId.getUserId(), transferMessage);
	}

	
	/* (non-Javadoc)
	 * @see deus.core.access.transfer.core.sending.command.PublisherCommandSender#offerSubscription(deus.model.common.user.frids.PublisherId, deus.model.common.user.frids.SubscriberId, deus.model.common.user.UserMetadata)
	 */
	@Override
	public void offerSubscription(PublisherId publisherId, SubscriberId subscriberId, UserMetadata publisherMetadata) {
		TransferMessage transferMessage = new OfferSubscriptionMessage(publisherMetadata);
		transferMessageSenderHelper.send(subscriberId.getUserId(), publisherId.getUserId(), transferMessage);
	}

	/* (non-Javadoc)
	 * @see deus.core.access.transfer.core.sending.command.PublisherCommandSender#cancelSubscription(deus.model.common.user.frids.PublisherId, deus.model.common.user.frids.SubscriberId)
	 */
	@Override
	public void cancelSubscription(PublisherId publisherId, SubscriberId subscriberId) {
		TransferMessage transferMessage = new CancelSubscriptionMessage();
		transferMessageSenderHelper.send(subscriberId.getUserId(), publisherId.getUserId(), transferMessage);
	}
	
	



	/* (non-Javadoc)
	 * @see deus.core.access.transfer.core.sending.command.PublisherCommandSender#grantSubscriptionRequest(deus.model.common.user.frids.PublisherId, deus.model.common.user.frids.SubscriberId)
	 */
	@Override
	public void grantSubscriptionRequest(PublisherId publisherId, SubscriberId subscriberId) {
		TransferMessage transferMessage = new GrantSubscriptionRequestNoticeMessage();
		transferMessageSenderHelper.send(subscriberId.getUserId(), publisherId.getUserId(), transferMessage);
	}

	
	/* (non-Javadoc)
	 * @see deus.core.access.transfer.core.sending.command.PublisherCommandSender#denySubscriptionRequest(deus.model.common.user.frids.PublisherId, deus.model.common.user.frids.SubscriberId)
	 */
	@Override
	public void denySubscriptionRequest(PublisherId publisherId, SubscriberId subscriberId) {
		TransferMessage transferMessage = new DenySubscriptionRequestNoticeMessage();
		transferMessageSenderHelper.send(subscriberId.getUserId(), publisherId.getUserId(), transferMessage);
	}



}
