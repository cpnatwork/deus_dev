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
package deus.core.soul.accountadmin.rolesetup.impl;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.inject.Named;

import deus.core.soul.accountadmin.rolesetup.DistributionRoleSetup;
import deus.core.soul.accountadmin.rolesetup.DistributionRoleSetupObserver;
import deus.model.common.account.DistributionRole;
import deus.model.common.user.id.UserId;

/**
 * The Class DistributionRoleSetupImpl.
 */
@Named("distributionRoleSetup")
public class DistributionRoleSetupImpl implements DistributionRoleSetup {

	/** The observers. */
	private final Map<DistributionRole, List<DistributionRoleSetupObserver>> observers;


	/**
	 * Instantiates a new distribution role setup impl.
	 */
	public DistributionRoleSetupImpl() {
		observers = new HashMap<DistributionRole, List<DistributionRoleSetupObserver>>();
		for (DistributionRole distributionRole : DistributionRole.values())
			observers.put(distributionRole, new LinkedList<DistributionRoleSetupObserver>());
	}


	/* (non-Javadoc)
	 * @see deus.core.soul.accountadmin.rolesetup.DistributionRoleSetup#addRoleSetupObserver(deus.model.common.account.DistributionRole, deus.core.soul.accountadmin.rolesetup.DistributionRoleSetupObserver)
	 */
	@Override
	public void addRoleSetupObserver(DistributionRole distributionRole, DistributionRoleSetupObserver observer) {
		observers.get(distributionRole).add(observer);
	}


	/* (non-Javadoc)
	 * @see deus.core.soul.accountadmin.rolesetup.DistributionRoleSetup#removeRoleSetupObserver(deus.model.common.account.DistributionRole, deus.core.soul.accountadmin.rolesetup.DistributionRoleSetupObserver)
	 */
	@Override
	public void removeRoleSetupObserver(DistributionRole distributionRole, DistributionRoleSetupObserver observer) {
		List<DistributionRoleSetupObserver> list = observers.get(distributionRole);
		if (!list.contains(observer))
			throw new IllegalArgumentException("observer " + observer + " cannot be removed, it has not been added");

		observers.get(distributionRole).remove(observer);
	}


	/* (non-Javadoc)
	 * @see deus.core.soul.accountadmin.rolesetup.DistributionRoleSetup#setUpRole(deus.model.common.account.DistributionRole, deus.model.common.user.id.UserId)
	 */
	@Override
	public void setUpRole(DistributionRole distributionRole, UserId userId) {
		List<DistributionRoleSetupObserver> list = observers.get(distributionRole);
		for (DistributionRoleSetupObserver observer : list)
			observer.setUpRole(distributionRole, userId);
	}


	/* (non-Javadoc)
	 * @see deus.core.soul.accountadmin.rolesetup.DistributionRoleSetup#tearDownRole(deus.model.common.account.DistributionRole, deus.model.common.user.id.UserId)
	 */
	@Override
	public void tearDownRole(DistributionRole distributionRole, UserId userId) {
		List<DistributionRoleSetupObserver> list = observers.get(distributionRole);
		for (DistributionRoleSetupObserver observer : list)
			observer.tearDownRole(distributionRole, userId);
	}

}
