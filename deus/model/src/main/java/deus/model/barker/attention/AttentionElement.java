package deus.model.barker.attention;

import java.io.Serializable;
import java.util.Date;

public abstract class AttentionElement implements Serializable {

	private static final long serialVersionUID = 8703358479824099313L;

	private Integer id;

	private Date creationDate;

	private boolean noticed;
	

	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}

	

	public final Date getCreationDate() {
		return creationDate;
	}


	public final void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	

	public boolean isNoticed() {
		return noticed;
	}


	public void setNoticed(boolean noticed) {
		this.noticed = noticed;
	}


	public abstract String getCatchphare();

}
