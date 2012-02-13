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
package deus.nsi.rest.pifgoverning;

import java.util.Set;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import deus.core.soul.pifgoverning.PifGovernorExportedToClient;
import deus.model.common.dossier.DigitalCard;
import deus.model.common.user.frids.RepatriationAuthorityId;
import deus.model.common.user.id.UserUrl;

// FIXME: use MarshallingHttpMessageConverter to marshal model elements to XML
/**
 * The Class PifGoverningController.
 */
@Controller
@RequestMapping("/users/{userId}/cp/pif")
public class PifGoverningController {

	/** The Constant logger. */
	private final static Logger logger = LoggerFactory
			.getLogger(PifGoverningController.class);

	/**
	 * Output.
	 */
	@PostConstruct
	private void output() {
		System.out
				.println("HALLOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO");
		PifGoverningController.logger
				.error("HALLOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO");
	}

	/** The pif governor. */
	@Autowired
	private PifGovernorExportedToClient pifGovernor;

	/**
	 * Gets the pif.
	 * 
	 * @param userId
	 *            the user id
	 * @return the pif
	 */
	@RequestMapping("/")
	@ResponseBody
	public String getPif(@PathVariable("userId") final String userId) {
		return "TEST";
		// FIXME: what to do if user does not exist?

		// return pifGovernor.getPersonalInformationFile(new
		// RepatriationAuthorityId(new UserUrl(userId,
		// "http://localhost"))).toString();
	}

	/**
	 * Gets the dcs.
	 * 
	 * @param userId
	 *            the user id
	 * @return the dcs
	 */
	@RequestMapping("/dcs")
	@ResponseBody
	public String getDcs(@PathVariable("userId") final String userId) {
		// FIXME: what to do if user does not exist?

		return this.pifGovernor
				.getPersonalInformationFile(
						new RepatriationAuthorityId(new UserUrl(userId,
								"http://localhost"))).getDigitalCards()
				.toString();
	}

	/**
	 * Gets the dc.
	 * 
	 * @param userId
	 *            the user id
	 * @param discriminator
	 *            the discriminator
	 * @return the dc
	 */
	@RequestMapping("/dcs/{discriminator}")
	@ResponseBody
	public String getDc(@PathVariable("userId") final String userId,
			@PathVariable("discriminator") final String discriminator) {
		final Set<DigitalCard> dcs = this.pifGovernor
				.getPersonalInformationFile(
						new RepatriationAuthorityId(new UserUrl(userId,
								"http://localhost"))).getDigitalCards();

		// FIXME: this is not correct! when there are multiple DCs with the same
		// discriminator, only the first
		// one is returned. DCs have a primary key composed of three parts. Only
		// CP ID and the discriminator are
		// used here, Contributor ID is omitted. See page 16 of diploma thesis!

		for (final DigitalCard dc : dcs) {
			if (dc.getDigitalCardId().getContributorProvidedDiscriminator()
					.equals(discriminator))
				return dc.toString();
		}

		// FIXME: what to do in this case?
		return null;
	}
}
