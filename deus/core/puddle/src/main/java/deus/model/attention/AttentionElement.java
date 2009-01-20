package deus.model.attention;

import java.util.Date;

public abstract class AttentionElement {

	private Date creationDate;


	public abstract boolean isProcessed();


	public final Date getCreationDate() {
		return creationDate;
	}


	public final void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

}
