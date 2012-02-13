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
import deus.core.access.transfer.common.messages.publication.connection.establish.invite.ConfirmSubscriptionOfferNoticeMessage;
import deus.core.access.transfer.common.messages.publication.connection.establish.invite.RepelSubscriptionOfferNoticeMessage;
import deus.core.access.transfer.common.messages.publication.connection.establish.subscribe.RequestSubscriptionMessage;
import deus.core.access.transfer.common.messages.publication.connection.terminate.UnsubscribeMessage;
import deus.core.access.transfer.core.sending.command.SubscriberCommandSender;
import deus.model.common.user.UserMetadata;
import deus.model.common.user.frids.PublisherId;
import deus.model.common.user.frids.SubscriberId;

/**
 * The Class TransferSubscriberCommandSender.
 */
@Named("subscriberCommandSender")
public class TransferSubscriberCommandSender implements SubscriberCommandSender {

	/** The transfer message sender helper. */
	@Inject
	private TransferMessageSenderHelper transferMessageSenderHelper;

	
	/* (non-Javadoc)
	 * @see deus.core.access.transfer.core.sending.command.SubscriberCommandSender#subscribe(deus.model.common.user.frids.SubscriberId, deus.model.common.user.frids.PublisherId, deus.model.common.user.UserMetadata)
	 */
	@Override
	public void subscribe(SubscriberId subscriberId, PublisherId publisherId, UserMetadata subscriberMetadata) {
		TransferMessage transferMessage = new RequestSubscriptionMessage(subscriberMetadata);
		transferMessageSenderHelper.send(publisherId.getUserId(), subscriberId.getUserId(), transferMessage);
	}


	/* (non-Javadoc)
	 * @see deus.core.access.transfer.core.sending.command.SubscriberCommandSender#unsubscribe(deus.model.common.user.frids.SubscriberId, deus.model.common.user.frids.PublisherId)
	 */
	@Override
	public void unsubscribe(SubscriberId subscriberId, PublisherId publisherId) {
		TransferMessage transferMessage = new UnsubscribeMessage();
		transferMessageSenderHelper.send(publisherId.getUserId(), subscriberId.getUserId(), transferMessage);
	}

	

	/* (non-Javadoc)
	 * @see deus.core.access.transfer.core.sending.command.SubscriberCommandSender#confirmSubscriptionOffer(deus.model.common.user.frids.SubscriberId, deus.model.common.user.frids.PublisherId)
	 */
	@Override
	public void confirmSubscriptionOffer(SubscriberId subscriberId, PublisherId publisherId) {
		TransferMessage transferMessage = new ConfirmSubscriptionOfferNoticeMessage();
		transferMessageSenderHelper.send(publisherId.getUserId(), subscriberId.getUserId(), transferMessage);
	}
	
	
	/* (non-Javadoc)
	 * @see deus.core.access.transfer.core.sending.command.SubscriberCommandSender#repelSubscriptionOffer(deus.model.common.user.frids.SubscriberId, deus.model.common.user.frids.PublisherId)
	 */
	@Override
	public void repelSubscriptionOffer(SubscriberId subscriberId, PublisherId publisherId) {
		TransferMessage transferMessage = new RepelSubscriptionOfferNoticeMessage();
		transferMessageSenderHelper.send(publisherId.getUserId(), subscriberId.getUserId(), transferMessage);
	}
	
}
