package deus.model.attention;

import java.io.Serializable;
import java.util.Date;

public abstract class AttentionElement implements Serializable {

	private static final long serialVersionUID = 8703358479824099313L;
	
	private Date creationDate;


	public final Date getCreationDate() {
		return creationDate;
	}


	public final void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	
	public abstract AttentionElementType getAttentionElementType();
	public abstract String getCatchphare();

}
