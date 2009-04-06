package deus.model.attention.publication;

import deus.model.attention.Notice;
import deus.model.dossier.Patch;
import deus.model.user.UserMetadata;

public class UpdateNotice extends Notice {

	private final UserMetadata publisherMetadata;

	private final Patch patch;


	public UpdateNotice(UserMetadata publisherMetadata, Patch patch) {
		super();
		this.publisherMetadata = publisherMetadata;
		this.patch = patch;
	}


	public UserMetadata getPublisherMetadata() {
		return publisherMetadata;
	}


	public Patch getPatch() {
		return patch;
	}


	public String getCatchphare() {
		// TODO Auto-generated method stub
		return null;
	}

}
