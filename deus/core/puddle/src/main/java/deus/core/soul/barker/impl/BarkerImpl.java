package deus.core.soul.barker.impl;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import deus.core.soul.barker.Barker;
import deus.core.soul.barker.decisionprocessors.DecisionProcessor;
import deus.model.attention.AttentionElement;
import deus.model.attention.AttentionList;
import deus.model.attention.decision.BinaryDecisionToMake;

public class BarkerImpl implements Barker {
	
	private final Logger logger = LoggerFactory.getLogger(BarkerImpl.class);
	
	private AttentionList unnoticedAttentionList;
	private AttentionList noticedAttentionList;
	private DecisionProcessor<BinaryDecisionToMake> decisionProcessor;


	/* (non-Javadoc)
	 * @see deus.core.soul.barker.impl.Barker#addUnnoticedAttentionElement(deus.model.attention.AttentionElement)
	 */
	public void addUnnoticedAttentionElement(AttentionElement attentionElement) {
		logger.trace("adding unnoticed attention element {}", attentionElement);
		
		unnoticedAttentionList.add(attentionElement);
		// set creation date
		attentionElement.setCreationDate(new Date());
	}


	/* (non-Javadoc)
	 * @see deus.core.soul.barker.impl.Barker#noticeAttentionElement(deus.model.attention.AttentionElement)
	 */
	public void noticeAttentionElement(AttentionElement attentionElement) {
		assertIsUnnoticed(attentionElement);
		
		logger.trace("noticing attention element {}", attentionElement);
		
		
		unnoticedAttentionList.remove(attentionElement);
		noticedAttentionList.add(attentionElement);
	}


	/* (non-Javadoc)
	 * @see deus.core.soul.barker.impl.Barker#processDecision(deus.model.attention.decision.BinaryDecisionToMake)
	 */
	public void processDecision(BinaryDecisionToMake decision) {
		logger.trace("processing decision {}", decision);
		
		noticeAttentionElement(decision);
		decisionProcessor.process(decision);
	}


	private void assertIsNoticed(AttentionElement attentionElement) {
		if (!isNoticed(attentionElement))
			throw new IllegalStateException("attention element (" + attentionElement
					+ " is not in 'processed' attention list!");
	}


	/* (non-Javadoc)
	 * @see deus.core.soul.barker.impl.Barker#isNoticed(deus.model.attention.AttentionElement)
	 */
	public boolean isNoticed(AttentionElement attentionElement) {
		return noticedAttentionList.contains(attentionElement);
	}


	private void assertIsUnnoticed(AttentionElement attentionElement) {
		if (!isUnnoticed(attentionElement))
			throw new IllegalStateException("attention element (" + attentionElement
					+ " is not in 'unprocessed' attention list!");
	}


	/* (non-Javadoc)
	 * @see deus.core.soul.barker.impl.Barker#isUnnoticed(deus.model.attention.AttentionElement)
	 */
	public boolean isUnnoticed(AttentionElement attentionElement) {
		return unnoticedAttentionList.contains(attentionElement);
	}


	/* (non-Javadoc)
	 * @see deus.core.soul.barker.impl.Barker#getUnnoticedAttentionList()
	 */
	public AttentionList getUnnoticedAttentionList() {
		return unnoticedAttentionList;
	}


	/* (non-Javadoc)
	 * @see deus.core.soul.barker.impl.Barker#setUnnoticedAttentionList(deus.model.attention.AttentionList)
	 */
	public void setUnnoticedAttentionList(AttentionList unnoticedAttentionList) {
		this.unnoticedAttentionList = unnoticedAttentionList;
	}


	/* (non-Javadoc)
	 * @see deus.core.soul.barker.impl.Barker#getNoticedAttentionList()
	 */
	public AttentionList getNoticedAttentionList() {
		return noticedAttentionList;
	}


	/* (non-Javadoc)
	 * @see deus.core.soul.barker.impl.Barker#setNoticedAttentionList(deus.model.attention.AttentionList)
	 */
	public void setNoticedAttentionList(AttentionList noticedAttentionList) {
		this.noticedAttentionList = noticedAttentionList;
	}


	/* (non-Javadoc)
	 * @see deus.core.soul.barker.impl.Barker#setDecisionProcessor(deus.core.soul.barker.decisionprocessors.DecisionProcessor)
	 */
	public void setDecisionProcessor(DecisionProcessor<BinaryDecisionToMake> decisionProcessor) {
		this.decisionProcessor = decisionProcessor;
	}

}
