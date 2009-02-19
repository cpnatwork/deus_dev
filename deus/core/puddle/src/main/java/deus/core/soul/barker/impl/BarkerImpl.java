package deus.core.soul.barker.impl;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import deus.core.access.storage.attention.api.AttentionDao;
import deus.core.soul.barker.Barker;
import deus.model.attention.AttentionElement;
import deus.model.attention.AttentionList;
import deus.model.user.id.UserId;

@Component("barker")
public class BarkerImpl implements Barker {

	private final Logger logger = LoggerFactory.getLogger(BarkerImpl.class);

	@Autowired
	private AttentionDao attentionDao;


	/*
	 * (non-Javadoc)
	 * 
	 * @see deus.core.soul.barker.impl.Barker#addUnnoticedAttentionElement(deus.model.attention.AttentionElement)
	 */
	public void addUnnoticedAttentionElement(AttentionElement attentionElement) {
		logger.trace("adding unnoticed attention element {}", attentionElement);

		// set creation date
		attentionElement.setCreationDate(new Date());

		attentionDao.addNewEntity(attentionElement);
	}


	/*
	 * (non-Javadoc)
	 * 
	 * @see deus.core.soul.barker.impl.Barker#noticeAttentionElement(deus.model.attention.AttentionElement)
	 */
	public void noticeAttentionElement(AttentionElement attentionElement) {
		// FIXME: do check
		// assertIsUnnoticed(attentionElement);

		logger.trace("noticing attention element {}", attentionElement);

		attentionDao.noticeAttentionElement(attentionElement);
	}


	/*
	 * (non-Javadoc)
	 * 
	 * @see deus.core.soul.barker.impl.Barker#getUnnoticedAttentionList()
	 */
	public AttentionList getUnnoticedAttentionList(UserId userId) {
		return attentionDao.getUnnoticedAttentionList(userId);
	}


	/*
	 * (non-Javadoc)
	 * 
	 * @see deus.core.soul.barker.impl.Barker#getUnnoticedAttentionList()
	 */
	public AttentionList getNoticedAttentionList(UserId userId) {
		return attentionDao.getNoticedAttentionList(userId);
	}

}
