package deus.model.attention;

import java.io.Serializable;
import java.util.Date;

import deus.model.user.id.UserId;

public abstract class AttentionElement implements Serializable {

	private static final long serialVersionUID = 8703358479824099313L;


	private Integer id;
	private UserId userId;

	private Date creationDate;


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public UserId getUserId() {
		return userId;
	}


	public void setUserId(UserId userId) {
		this.userId = userId;
	}

	

	public final Date getCreationDate() {
		return creationDate;
	}


	public final void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}


	public abstract String getCatchphare();

}
