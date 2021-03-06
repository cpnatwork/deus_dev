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
package deus.core.soul.pifgoverning.rolesetup;

import javax.inject.Named;

import deus.core.soul.accountadmin.rolesetup.AbstractDistributionRoleSetupObserver;
import deus.model.common.account.DistributionRole;
import deus.model.common.user.id.UserId;

/**
 * An asynchronous update interface for receiving notifications about
 * CpRoleSetupPifGovernor information as the CpRoleSetupPifGovernor is
 * constructed.
 */
@Named
public class CpRoleSetupPifGovernorObserver extends
		AbstractDistributionRoleSetupObserver {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * deus.core.soul.accountadmin.rolesetup.AbstractDistributionRoleSetupObserver
	 * #getDistributionRole()
	 */
	@Override
	protected DistributionRole getDistributionRole() {
		return DistributionRole.concernedPerson;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * deus.core.soul.accountadmin.rolesetup.AbstractDistributionRoleSetupObserver
	 * #setUpRole(deus.model.common.user.id.UserId)
	 */
	@Override
	protected void setUpRole(final UserId userId) {
		// FUTURE: init data objects in database for subsystem Subscriber here!
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * deus.core.soul.accountadmin.rolesetup.AbstractDistributionRoleSetupObserver
	 * #tearDownRole(deus.model.common.user.id.UserId)
	 */
	@Override
	protected void tearDownRole(final UserId userId) {
		// FUTURE: destroy data objects in database for subsystem Subscriber
		// here!
	}

}
