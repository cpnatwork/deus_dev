package deus.model.attention;

import java.util.Date;

public abstract class AttentionElement {

//	private boolean processed;

	private Date creationDate;

//	public final boolean isProcessed() {
//		return processed;
//	}
//
//
//	public final void setProcessed(boolean processed) {
//		this.processed = processed;
//	}

	public final Date getCreationDate() {
		return creationDate;
	}


	public final void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	
	public abstract AttentionElementType getAttentionElementType();
	public abstract String getCatchphare();

}
