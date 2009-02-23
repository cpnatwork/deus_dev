package deus.model.attention.notice;

import deus.model.ifcontent.DigitalCard;
import deus.model.user.UserMetadata;

public class UpdateNotice extends Notice {

	private final UserMetadata publisherMetadata;

	private final DigitalCard newDigitalCard;


	public UpdateNotice(UserMetadata publisherMetadata, DigitalCard newDigitalCard) {
		super();
		this.publisherMetadata = publisherMetadata;
		this.newDigitalCard = newDigitalCard;
	}


	public UserMetadata getPublisherMetadata() {
		return publisherMetadata;
	}


	public DigitalCard getNewDigitalCard() {
		return newDigitalCard;
	}


	public String getCatchphare() {
		// TODO Auto-generated method stub
		return null;
	}

}
