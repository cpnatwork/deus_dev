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
package deus.core.soul.publication;

import deus.core.access.transfer.core.receiving.soulcallback.publication.PublisherExportedToPeers;

/**
 * Central facade of the publisher subsystem.
 * 
 * Methods from <code>PublisherExportedToPeers</code> are called remotely on
 * this publisher. Methods from <code>PublisherExportedToClient</code> are
 * called locally and result in a remote call on a informationConsumer stub. The
 * other methods specified in this interface are methods, that currently aren't
 * called remotely and are deprecated, or return information about the publisher
 * subsystem for local usage.
 * 
 * @see PublisherExportedToPeers
 * @see PublisherExportedToClient
 * 
 * @author Florian Rampp (Florian.Rampp@informatik.stud.uni-erlangen.de)
 */
public interface Publisher extends PublisherExportedToPeers,
		PublisherExportedToClient {

}