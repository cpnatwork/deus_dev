package deus.core.barker;

import deus.model.attention.AttentionElement;
import deus.model.attention.AttentionList;
import deus.model.attention.decision.BinaryDecisionToMake;

public class Barker {


	private AttentionList unnoticedAttentionList;
	private AttentionList noticedAttentionList;
	private DecisionProcessor<BinaryDecisionToMake> decisionProcessor;


	public void addUnnoticedAttentionElement(AttentionElement attentionElement) {
		unnoticedAttentionList.add(attentionElement);
	}


	public void noticeAttentionElement(AttentionElement attentionElement) {
		assertIsUnnoticed(attentionElement);
		unnoticedAttentionList.remove(attentionElement);
		noticedAttentionList.add(attentionElement);
	}

	
	public void processDecision(BinaryDecisionToMake decision) {
		decisionProcessor.process(decision);
	}
	
	
	private void assertIsNoticed(AttentionElement attentionElement) {
		if (!isNoticed(attentionElement))
			throw new IllegalStateException("attention element (" + attentionElement
					+ " is not in 'processed' attention list!");
	}


	public boolean isNoticed(AttentionElement attentionElement) {
		return noticedAttentionList.contains(attentionElement);
	}


	private void assertIsUnnoticed(AttentionElement attentionElement) {
		if (!isUnnoticed(attentionElement))
			throw new IllegalStateException("attention element (" + attentionElement
					+ " is not in 'unprocessed' attention list!");
	}
	

	public boolean isUnnoticed(AttentionElement attentionElement) {
		return unnoticedAttentionList.contains(attentionElement);
	}

	
	

	public AttentionList getUnnoticedAttentionList() {
		return unnoticedAttentionList;
	}


	public void setUnnoticedAttentionList(AttentionList unnoticedAttentionList) {
		this.unnoticedAttentionList = unnoticedAttentionList;
	}


	public AttentionList getNoticedAttentionList() {
		return noticedAttentionList;
	}


	public void setNoticedAttentionList(AttentionList noticedAttentionList) {
		this.noticedAttentionList = noticedAttentionList;
	}


	public void setDecisionProcessor(DecisionProcessor<BinaryDecisionToMake> decisionProcessor) {
		this.decisionProcessor = decisionProcessor;
	}




	// TODO: operations

}
