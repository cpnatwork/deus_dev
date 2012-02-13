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
package deus.model.subscription.impl;

import java.util.HashMap;
import java.util.Map;

import deus.model.common.dossier.InformationFile;
import deus.model.common.user.id.UserId;
import deus.model.difgoverning.DistributedInformationFolder;
import deus.model.difgoverning.ForeignInformationFile;

/**
 * The Class DistributedInformationFolderImpl.
 */
public class DistributedInformationFolderImpl implements
		DistributedInformationFolder {

	/** The foreign information files. */
	protected Map<UserId, ForeignInformationFile> foreignInformationFiles;

	/**
	 * Instantiates a new distributed information folder impl.
	 */
	public DistributedInformationFolderImpl() {
		super();
		this.foreignInformationFiles = new HashMap<UserId, ForeignInformationFile>();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see deus.model.difgoverning.DistributedInformationFolder#
	 * getForeignInformationFile(deus.model.common.user.id.UserId)
	 */
	@Override
	public InformationFile getForeignInformationFile(final UserId publisherId) {
		if (!this.foreignInformationFiles.containsKey(publisherId))
			throw new IllegalArgumentException("no FIF for publisher id "
					+ publisherId);
		else
			return this.foreignInformationFiles.get(publisherId);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see deus.model.difgoverning.DistributedInformationFolder#
	 * updateForeignInformationFile
	 * (deus.model.difgoverning.ForeignInformationFile)
	 */
	@Override
	public void updateForeignInformationFile(
			final ForeignInformationFile foreignInformationFile) {
		if (!this.foreignInformationFiles.containsKey(foreignInformationFile
				.getPublisherId()))
			throw new IllegalArgumentException("cannot update FIF "
					+ foreignInformationFile
					+ ", it is not contained in the DIF yet!");
		else {
			this.foreignInformationFiles.put(
					foreignInformationFile.getPublisherId(),
					foreignInformationFile);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see deus.model.difgoverning.DistributedInformationFolder#
	 * addForeignInformationFile(deus.model.difgoverning.ForeignInformationFile)
	 */
	@Override
	public void addForeignInformationFile(
			final ForeignInformationFile foreignInformationFile) {
		if (this.foreignInformationFiles.containsKey(foreignInformationFile
				.getPublisherId()))
			throw new IllegalArgumentException(
					"cannot add FIF "
							+ foreignInformationFile
							+ ", there already exists a FIF with the same publisher id!");
		else {
			this.foreignInformationFiles.put(
					foreignInformationFile.getPublisherId(),
					foreignInformationFile);
		}
	}

}
