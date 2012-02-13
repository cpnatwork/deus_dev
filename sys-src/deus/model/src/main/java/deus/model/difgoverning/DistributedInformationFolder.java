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
package deus.model.difgoverning;

import deus.model.common.dossier.InformationFile;
import deus.model.common.user.id.UserId;

/**
 * <code>DistributedInformationFolder</code> (DIF) represents a collection of
 * Foreign Information Files (FIFs).
 * 
 * A FIF can be updated by calling the method
 * <code>updateForeignInformationFile</code>, if this FIF is already in the DIF.
 * 
 * A FIF can be added to the DIF by calling the method
 * <code>addForeignInformationFile</code>. In this case, the FIF must not exist
 * in the DIF yet.
 * 
 * @see deus.model.dossier.ForeignInformationFile.
 * @author Florian Rampp (Florian.Rampp@informatik.stud.uni-erlangen.de)
 */
public interface DistributedInformationFolder {

	/**
	 * Gets the foreign information file.
	 * 
	 * @param publisherId
	 *            the publisher id
	 * @return the foreign information file
	 */
	public InformationFile getForeignInformationFile(UserId publisherId);


	/**
	 * Update foreign information file.
	 * 
	 * @param foreignInformationFile
	 *            the foreign information file
	 */
	public void updateForeignInformationFile(ForeignInformationFile foreignInformationFile);


	/**
	 * Adds the foreign information file.
	 * 
	 * @param foreignInformationFile
	 *            the foreign information file
	 */
	public void addForeignInformationFile(ForeignInformationFile foreignInformationFile);

}
