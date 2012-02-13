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
package deus.core.soul.hci.barker.impl;

import java.util.Date;

import javax.inject.Inject;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import deus.core.access.storage.api.hci.attention.AttentionElementDao;
import deus.core.access.storage.api.hci.attention.AttentionListDao;
import deus.core.soul.hci.barker.BarkerRuntimeException;
import deus.model.common.user.id.UserId;
import deus.model.hci.attention.AttentionElement;
import deus.model.hci.attention.AttentionList;

/**
 * The Class BarkerImpl.
 */
@Named("barker")
public class BarkerImpl implements Barker {

	/** The logger. */
	private final Logger logger = LoggerFactory.getLogger(BarkerImpl.class);

	/** The attention element dao. */
	@Inject
	private AttentionElementDao attentionElementDao;

	/** The attention list dao. */
	@Inject
	private AttentionListDao attentionListDao;


	/* (non-Javadoc)
	 * @see deus.core.soul.hci.barker.BarkerExportedToSubsystems#addUnnoticedAttentionElement(deus.model.common.user.id.UserId, deus.model.hci.attention.AttentionElement)
	 */
	@Override
	public void addUnnoticedAttentionElement(UserId userId, AttentionElement attentionElement) {
		if (attentionElement.isNoticed())
			throw new BarkerRuntimeException("cannot add unnoticed attention element " + attentionElement
					+ ", it is already noticed");
		
		logger.trace("adding unnoticed attention element {}", attentionElement);
		
		// set creation date
		attentionElement.setCreationDate(new Date());

		attentionElementDao.addNewEntity(userId, attentionElement);
	}


	/* (non-Javadoc)
	 * @see deus.core.soul.hci.barker.BarkerExportedToClient#noticeAttentionElement(deus.model.common.user.id.UserId, deus.model.hci.attention.AttentionElement)
	 */
	@Override
	public void noticeAttentionElement(UserId userId, AttentionElement attentionElement) {
		if (attentionElement.isNoticed())
			throw new BarkerRuntimeException("cannot notice attention element " + attentionElement
					+ ", it is already noticed");

		logger.trace("noticing attention element {}", attentionElement);

		attentionElement.setNoticed(true);

		attentionElementDao.updateEntity(userId, attentionElement);
	}


	/* (non-Javadoc)
	 * @see deus.core.soul.hci.barker.BarkerExportedToClient#getUnnoticedAttentionList(deus.model.common.user.id.UserId)
	 */
	@Override
	public AttentionList getUnnoticedAttentionList(UserId userId) {
		return attentionListDao.getUnnoticedAttentionList(userId);
	}


	/* (non-Javadoc)
	 * @see deus.core.soul.hci.barker.BarkerExportedToClient#getNoticedAttentionList(deus.model.common.user.id.UserId)
	 */
	@Override
	public AttentionList getNoticedAttentionList(UserId userId) {
		return attentionListDao.getNoticedAttentionList(userId);
	}

}
