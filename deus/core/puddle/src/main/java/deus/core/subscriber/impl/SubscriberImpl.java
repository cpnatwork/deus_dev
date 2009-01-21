package deus.core.subscriber.impl;

import deus.core.subscriber.Subscriber;
import deus.model.depository.generic.DistributedInformationFolder;
import deus.model.pub.SubscriberMetadata;
import deus.model.user.id.UserId;

// TODO: add DIF
public class SubscriberImpl<Id extends UserId, DifType extends DistributedInformationFolder<Id, ?>, FifContentType>
		extends RemoteCalledSubscriberImpl<Id, DifType, FifContentType> implements Subscriber<Id, DifType, FifContentType> {

	private final SubscriberMetadata<Id> subscriberMetadata;


	public SubscriberImpl(SubscriberMetadata<Id> subscriberMetadata) {
		super();
		this.subscriberMetadata = subscriberMetadata;
	}


	@Override
	public SubscriberMetadata<Id> getSubscriberMetadata() {
		return subscriberMetadata;
	}


	@Override
	public DifType getDistributedInformationFolder() {
		// TODO Auto-generated method stub
		return null;
	}

}
