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
package deus.core.soul.subscription;

import deus.core.access.transfer.core.receiving.soulcallback.subscription.SubscriberExportedToPeers;

/**
 * Central facade of the informationConsumer subsystem.
 * 
 * Methods from the interface <code>SubscriberExportedToPeers</code> are called
 * remotely on this informationConsumer. The other methods of this interface are
 * methods to retrieve information about the informationConsumer subsystem
 * locally.
 * 
 * @see SubscriberExportedToPeers
 * 
 * @author Florian Rampp (Florian.Rampp@informatik.stud.uni-erlangen.de)
 * 
 */
public interface Subscriber extends SubscriberExportedToPeers,
		SubscriberExportedToClient {

}