package deus.core.soul.publisher.impl;

import deus.core.soul.publisher.Publisher;
import deus.core.soul.publisher.RemoteCalledPublisher;
import deus.model.dossier.generic.ForeignInformationFile;
import deus.model.pub.ListOfSubscribers;
import deus.model.user.UserMetadata;
import deus.model.user.id.UserId;

/**
 * Delegates all methods of <code>RemoteCalledPublisher</code> to a delegate of type <code>RemoteCalledPublisher</code>,
 * the rest of the methods of <code>Publisher</code> are delegated to the second delegate, which is of type
 * <code>Publisher</code>.
 * 
 * @author Florian Rampp (Florian.Rampp@informatik.stud.uni-erlangen.de)
 * 
 */
public class RemoteCalledPublisherToPublisherAdapter implements Publisher {

	private final RemoteCalledPublisher remoteCalledPublisher;
	private final Publisher publisher;


	public RemoteCalledPublisherToPublisherAdapter(RemoteCalledPublisher remoteCalledPublisher, Publisher publisher) {
		super();
		this.remoteCalledPublisher = remoteCalledPublisher;
		this.publisher = publisher;
	}


//	+++ METHODS OF REMOTE CALLED PUBLISHER ++++++++++++++++++++++++++++++++++++++++++++++++++++++
	
	@Override
	public void addObserver(UserId subscriberId, UserMetadata subscriberMetadata) {
		remoteCalledPublisher.addObserver(subscriberId, subscriberMetadata);
	}


	@Override
	public void deleteObserver(UserId subscriberId) {
		remoteCalledPublisher.deleteObserver(subscriberId);
	}

//	+++ METHODS OF PUBLISHER ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	
	@Override
	public int countObservers() {
		return publisher.countObservers();
	}


	@Override
	public void deleteObservers() {
		publisher.deleteObservers();
	}


	@Override
	public ListOfSubscribers getListOfSubscribers() {
		return publisher.getListOfSubscribers();
	}


	@Override
	public UserId getPublisherId() {
		return publisher.getPublisherId();
	}


	@Override
	public void notifyObservers(ForeignInformationFile change) {
		publisher.notifyObservers(change);
	}

}
