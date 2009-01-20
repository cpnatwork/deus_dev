package deus.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;

import deus.core.barker.Barker;
import deus.core.lodother.LodOther;
import deus.core.lodself.LodSelf;
import deus.core.publisher.Publisher;
import deus.core.subscriber.Subscriber;
import deus.model.depository.generic.DistributedInformationFolder;
import deus.model.user.UserMetadata;
import deus.model.user.id.UserId;

@Configurable
public class User<Id extends UserId, PifContentType, DifContentType extends DistributedInformationFolder<Id, ?>> {

	@Autowired
	private UserMetadata<Id> userMetadata;
	
	@Autowired
	private Publisher<Id> publisher;
	@Autowired
	private Subscriber<Id, DifContentType> subscriber;
	
	@Autowired
	private LodSelf<Id, PifContentType> lodSelf;
	@Autowired
	private LodOther lodOther;
	
	@Autowired
	private Barker barker;
	
}
