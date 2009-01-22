package deus.core.subscriber.impl;

import deus.core.subscriber.Subscriber;
import deus.model.depository.generic.DistributedInformationFolder;
import deus.model.pub.SubscriberMetadata;

// TODO: add DIF
public class SubscriberImpl extends RemoteCalledSubscriberImpl implements Subscriber {

	private final SubscriberMetadata subscriberMetadata;


	public SubscriberImpl(SubscriberMetadata subscriberMetadata) {
		super();
		this.subscriberMetadata = subscriberMetadata;
	}


	@Override
	public SubscriberMetadata getSubscriberMetadata() {
		return subscriberMetadata;
	}


	@Override
	public DistributedInformationFolder getDistributedInformationFolder() {
		// TODO Auto-generated method stub
		return null;
	}

}
