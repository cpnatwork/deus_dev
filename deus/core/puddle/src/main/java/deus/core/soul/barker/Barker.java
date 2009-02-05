package deus.core.soul.barker;

import deus.core.soul.barker.decisionprocessors.DelegateDecisionProcessor;
import deus.model.attention.AttentionElement;
import deus.model.attention.AttentionList;
import deus.model.attention.decision.BinaryDecisionToMake;


public interface Barker {

	public abstract void addUnnoticedAttentionElement(AttentionElement attentionElement);


	public abstract void noticeAttentionElement(AttentionElement attentionElement);


	public abstract void processDecision(BinaryDecisionToMake decision);


	public abstract boolean isNoticed(AttentionElement attentionElement);


	public abstract boolean isUnnoticed(AttentionElement attentionElement);


	public abstract AttentionList getUnnoticedAttentionList();


	public abstract void setUnnoticedAttentionList(AttentionList unnoticedAttentionList);


	public abstract AttentionList getNoticedAttentionList();


	public abstract void setNoticedAttentionList(AttentionList noticedAttentionList);


	public abstract void setDecisionProcessor(DelegateDecisionProcessor decisionProcessor);

}