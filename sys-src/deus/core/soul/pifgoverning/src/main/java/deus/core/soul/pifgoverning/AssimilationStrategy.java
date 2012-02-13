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
package deus.core.soul.pifgoverning;

import deus.model.common.dossier.DigitalCard;
import deus.model.common.dossier.InformationFile;
import deus.model.common.dossier.Patch;

/**
 * Implementations of this strategy realize different update semantics, when a
 * digital card for a given FIF is received.
 * 
 * Two different scenarios can be distinguised: 1. The received DC is new, so no
 * DC with the same primary key is contained in the FIF 2. There is already a DC
 * with the primary key of the received DC. A kind of merge must be implemented
 * (e.g. either a simple replace, or an append, or a merge, or more complex
 * versioning)
 * 
 * @author Florian Rampp (Florian.Rampp@informatik.stud.uni-erlangen.de)
 * 
 */
public interface AssimilationStrategy {

	/**
	 * Update.
	 * 
	 * @param fif
	 *            the fif
	 * @param digitalCard
	 *            the digital card
	 * @return the patch
	 */
	public Patch update(InformationFile fif, DigitalCard digitalCard);

}
