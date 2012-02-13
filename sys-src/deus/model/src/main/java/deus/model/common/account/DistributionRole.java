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
package deus.model.common.account;

/**
 * Defines which roles a user can have (he can have multiple roles!)
 * 
 * concernedPerson means, the user owns a PIF, can edit this and publish changes of it to registered subscribers.
 * 
 * informationConsumer means, the user can subscribe to the PIF of other users and maintain a DIF of FPFs of other users.
 * 
 * informationProvider means, the user can contribute to the PPF of other users.
 * 
 * @author Florian Rampp (Florian.Rampp@informatik.stud.uni-erlangen.de)
 * 
 */
public enum DistributionRole {

	/** The concerned person. */
	concernedPerson, /** The information consumer. */
 informationConsumer, /** The information provider. */
 informationProvider;

}
