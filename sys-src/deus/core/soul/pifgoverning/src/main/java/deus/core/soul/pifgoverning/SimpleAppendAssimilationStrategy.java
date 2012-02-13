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

import java.util.Set;

import deus.model.common.dossier.AppendDigitalCardPatch;
import deus.model.common.dossier.DigitalCard;
import deus.model.common.dossier.InformationFile;
import deus.model.common.dossier.Patch;

/**
 * The Class SimpleAppendAssimilationStrategy.
 */
public class SimpleAppendAssimilationStrategy implements AssimilationStrategy {

	/**
	 * Update.
	 * 
	 * @param fif
	 *            the fif
	 * @param digitalCard
	 *            the digital card
	 * @return the patch
	 */
	@Override
	public Patch update(final InformationFile fif, final DigitalCard digitalCard) {
		final Set<DigitalCard> digitalCards = fif.getDigitalCards();

		if (digitalCards.contains(digitalCard))
			throw new IllegalUpdateInPlaceException(
					digitalCard.getDigitalCardId());
		else
			return this.append(fif, digitalCard);
	}

	/*
	 * private Patch replace(InformationFile fif, DigitalCard digitalCard) {
	 * Set<DigitalCard> digitalCards = fif.getDigitalCards();
	 * 
	 * // remove old one boolean containedDC = digitalCards.remove(digitalCard);
	 * assert (containedDC == true);
	 * 
	 * // add new one digitalCards.add(digitalCard); }
	 */

	/**
	 * Append.
	 * 
	 * @param fif
	 *            the fif
	 * @param digitalCard
	 *            the digital card
	 * @return the patch
	 */
	private Patch append(final InformationFile fif,
			final DigitalCard digitalCard) {
		final Set<DigitalCard> digitalCards = fif.getDigitalCards();
		digitalCards.add(digitalCard);

		// create patch
		final AppendDigitalCardPatch patch = new AppendDigitalCardPatch(
				digitalCard.getDigitalCardId().getCpId());
		patch.setDigitalCardToAppend(digitalCard);
		return patch;
	}

}
