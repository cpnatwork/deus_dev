package deus.core.soul.hci.barker.impl;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import deus.core.access.storage.api.attention.AttentionElementDoRep;
import deus.core.access.storage.api.attention.AttentionListDoRep;
import deus.core.soul.hci.barker.Barker;
import deus.model.common.user.id.UserId;
import deus.model.hci.attention.AttentionElement;
import deus.model.hci.attention.AttentionList;

@Component("barker")
public class BarkerImpl implements Barker {

	private final Logger logger = LoggerFactory.getLogger(BarkerImpl.class);

	@Autowired
	private AttentionElementDoRep attentionElementDoRep;

	@Autowired
	private AttentionListDoRep attentionListDoRep;


	@Override
	public void addUnnoticedAttentionElement(UserId userId, AttentionElement attentionElement) {
		logger.trace("adding unnoticed attention element {}", attentionElement);

		// set creation date
		attentionElement.setCreationDate(new Date());

		attentionElementDoRep.addNewEntity(userId, attentionElement);
	}


	@Override
	public void noticeAttentionElement(UserId userId, AttentionElement attentionElement) {
		if(attentionElement.isNoticed())
			throw new RuntimeException("cannot notice attention element " + attentionElement + ", it is already noticed");			

		logger.trace("noticing attention element {}", attentionElement);

		attentionElement.setNoticed(true);

		attentionElementDoRep.updateEntity(userId, attentionElement);
	}


	@Override
	public AttentionList getUnnoticedAttentionList(UserId userId) {
		return attentionListDoRep.getUnnoticedAttentionList(userId);
	}


	@Override
	public AttentionList getNoticedAttentionList(UserId userId) {
		return attentionListDoRep.getUnnoticedAttentionList(userId);
	}

}
