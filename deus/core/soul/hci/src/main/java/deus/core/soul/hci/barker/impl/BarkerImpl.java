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

@Named("barker")
public class BarkerImpl implements Barker {

	private final Logger logger = LoggerFactory.getLogger(BarkerImpl.class);

	@Inject
	private AttentionElementDao attentionElementDao;

	@Inject
	private AttentionListDao attentionListDao;


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


	@Override
	public void noticeAttentionElement(UserId userId, AttentionElement attentionElement) {
		if (attentionElement.isNoticed())
			throw new BarkerRuntimeException("cannot notice attention element " + attentionElement
					+ ", it is already noticed");

		logger.trace("noticing attention element {}", attentionElement);

		attentionElement.setNoticed(true);

		attentionElementDao.updateEntity(userId, attentionElement);
	}


	@Override
	public AttentionList getUnnoticedAttentionList(UserId userId) {
		return attentionListDao.getUnnoticedAttentionList(userId);
	}


	@Override
	public AttentionList getNoticedAttentionList(UserId userId) {
		return attentionListDao.getNoticedAttentionList(userId);
	}

}
