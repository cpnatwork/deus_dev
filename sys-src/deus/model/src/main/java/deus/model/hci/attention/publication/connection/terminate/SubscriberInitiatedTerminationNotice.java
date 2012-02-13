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
package deus.model.hci.attention.publication.connection.terminate;

import deus.model.common.user.UserMetadata;

/**
 * Displayed to publisher, when a informationConsumer unsubscribes from his PIF.
 * 
 * @author Florian Rampp (Florian.Rampp@informatik.stud.uni-erlangen.de)
 * 
 */
public class SubscriberInitiatedTerminationNotice extends TerminationNotice {

	/** The subscriber metadata. */
	private final UserMetadata subscriberMetadata;


	/**
	 * Instantiates a new subscriber initiated termination notice.
	 * 
	 * @param subscriberMetadata
	 *            the subscriber metadata
	 */
	public SubscriberInitiatedTerminationNotice(UserMetadata subscriberMetadata) {
		this.subscriberMetadata = subscriberMetadata;
	}


	/**
	 * Gets the subscriber metadata.
	 * 
	 * @return the subscriber metadata
	 */
	public UserMetadata getSubscriberMetadata() {
		return subscriberMetadata;
	}


	/* (non-Javadoc)
	 * @see deus.model.hci.attention.AttentionElement#getCatchphare()
	 */
	@Override
	public String getCatchphare() {
		return "Your informationConsumer "+getSubscriberMetadata().getFullName()+" shits on you (has deleted your file from ITS folder)";

	}

}
