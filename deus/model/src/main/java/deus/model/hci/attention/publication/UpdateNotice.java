package deus.model.hci.attention.publication;

import deus.model.common.dossier.Patch;
import deus.model.common.user.UserMetadata;
import deus.model.hci.attention.Notice;

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
