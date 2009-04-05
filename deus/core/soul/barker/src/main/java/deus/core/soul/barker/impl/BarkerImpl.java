package deus.core.soul.barker.impl;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import deus.core.access.storage.api.attention.AttentionElementDoRep;
import deus.core.access.storage.api.attention.AttentionListDoRep;
import deus.core.soul.barker.Barker;
import deus.model.attention.AttentionElement;
import deus.model.attention.AttentionList;
import deus.model.user.id.UserId;

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
		// FIXME: do check
		// assertIsUnnoticed(attentionElement);

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
