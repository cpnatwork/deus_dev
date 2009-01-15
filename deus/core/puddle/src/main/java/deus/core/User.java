package deus.core;

import deus.core.barker.Barker;
import deus.core.lodother.LodOther;
import deus.core.lodself.LodSelf;
import deus.core.publisher.Publisher;
import deus.core.subscriber.Subscriber;
import deus.model.user.id.UserId;

public class User<Id extends UserId, PifContentType, DifContentType> {

	private Publisher<Id> publisher;
	private Subscriber<Id, DifContentType> subscriber;
	
	private LodSelf<Id, PifContentType> lodSelf;
	private LodOther lodOther;
	
	private Barker attentionList;
	
}
