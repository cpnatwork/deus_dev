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
package deus.model.hci.attention.repatriation;

import deus.model.common.dossier.DigitalCard;
import deus.model.common.user.UserMetadata;
import deus.model.hci.attention.BinaryDecisionToMake;
import deus.model.hci.attention.DecisionType;

/**
 * The Class Repatriation.
 */
public class Repatriation extends BinaryDecisionToMake {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6883677745871606146L;

	/** The contributor metadata. */
	private final UserMetadata contributorMetadata;

	/** The contributed digital card. */
	private final DigitalCard contributedDigitalCard;

	/**
	 * Instantiates a new repatriation.
	 * 
	 * @param contributorMetadata
	 *            the contributor metadata
	 * @param contributedDigitalCard
	 *            the contributed digital card
	 */
	public Repatriation(final UserMetadata contributorMetadata,
			final DigitalCard contributedDigitalCard) {
		super();
		this.contributorMetadata = contributorMetadata;
		this.contributedDigitalCard = contributedDigitalCard;
	}

	/**
	 * Gets the contributor metadata.
	 * 
	 * @return the contributor metadata
	 */
	public UserMetadata getContributorMetadata() {
		return this.contributorMetadata;
	}

	/**
	 * Gets the contributed digital card.
	 * 
	 * @return the contributed digital card
	 */
	public DigitalCard getContributedDigitalCard() {
		return this.contributedDigitalCard;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see deus.model.hci.attention.BinaryDecisionToMake#getType()
	 */
	@Override
	public DecisionType getType() {
		return DecisionType.contribution;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see deus.model.hci.attention.AttentionElement#getCatchphare()
	 */
	@Override
	public String getCatchphare() {
		// TODO Auto-generated method stub
		return null;
	}

}
