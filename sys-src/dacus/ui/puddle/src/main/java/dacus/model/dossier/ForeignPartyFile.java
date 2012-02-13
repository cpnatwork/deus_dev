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
package dacus.model.dossier;

import java.util.Set;

import deus.model.common.dossier.DigitalCard;
import deus.model.common.user.UserMetadata;
import deus.model.common.user.id.UserId;
import deus.model.difgoverning.ForeignInformationFile;

/**
 * The Class ForeignPartyFile.
 */
public class ForeignPartyFile extends ForeignInformationFile {

	/**
	 * Instantiates a new foreign party file.
	 * 
	 * @param publisherId
	 *            the publisher id
	 * @param publisherMetadata
	 *            the publisher metadata
	 * @param digitalCards
	 *            the digital cards
	 */
	public ForeignPartyFile(UserId publisherId, UserMetadata publisherMetadata, Set<DigitalCard> digitalCards) {
		super(publisherId, publisherMetadata, digitalCards);
	}

}
