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
package deus.model.difgoverning;

import java.util.Set;

import deus.model.common.dossier.DigitalCard;
import deus.model.common.dossier.InformationFile;
import deus.model.common.user.UserMetadata;
import deus.model.common.user.id.UserId;
import deus.model.pifgoverning.PersonalInformationFile;

/**
 * The view of a personal information file (PIF), that resides on the informationConsumer side. This file is sent by the
 * publisher to its subscribers.
 * 
 * Abbreviation: FIF
 * 
 * @see PersonalInformationFile
 * 
 * @author Florian Rampp (Florian.Rampp@informatik.stud.uni-erlangen.de)
 */
public class ForeignInformationFile extends InformationFile {

	/** The publisher id. */
	private final UserId publisherId;

	/** The publisher metadata. */
	private final UserMetadata publisherMetadata;


	/**
	 * Instantiates a new foreign information file.
	 * 
	 * @param publisherId
	 *            the publisher id
	 * @param publisherMetadata
	 *            the publisher metadata
	 * @param digitalCards
	 *            the digital cards
	 */
	public ForeignInformationFile(UserId publisherId, UserMetadata publisherMetadata, Set<DigitalCard> digitalCards) {
		super(digitalCards);
		this.publisherId = publisherId;
		this.publisherMetadata = publisherMetadata;
	}


	/**
	 * Gets the publisher id.
	 * 
	 * @return the publisher id
	 */
	public UserId getPublisherId() {
		return publisherId;
	}


	/**
	 * Gets the publisher metadata.
	 * 
	 * @return the publisher metadata
	 */
	public UserMetadata getPublisherMetadata() {
		return publisherMetadata;
	}

}
