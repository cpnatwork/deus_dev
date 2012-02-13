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
package deus.core.soul.repatriationhub;

import deus.core.access.transfer.core.receiving.soulcallback.repatriationhub.RepatriationHubExportedToPeers;

// FIXME: edit javadoc
/**
 * This system interface is responsible for receiving contributed digital cards
 * (either from the user itself or from another user) to be committed into the
 * PIF.
 * 
 * The passed ID of the informationProvider must match the ID of the
 * informationProvider in the digital card!
 * 
 * The ID of the user, to which this repatriation hub belongs must match the ID
 * of the CP in the digital card!
 * 
 * @author Florian Rampp (Florian.Rampp@informatik.stud.uni-erlangen.de)
 * 
 */
public interface RepatriationHub extends RepatriationHubExportedToClient,
		RepatriationHubExportedToPeers {

}
