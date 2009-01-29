package deus.core.soul.publisher.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;

import deus.core.soul.publisher.Publisher;
import deus.core.transport.command.Command;
import deus.core.transport.command.UpdateCommand;
import deus.core.transport.commandexecutor.CommandExecutor;
import deus.model.dossier.generic.ForeignInformationFile;
import deus.model.pub.ListOfSubscribers;
import deus.model.user.UserMetadata;

@Configurable
public class PublisherImpl implements Publisher {

	private final UserMetadata publisherMetadata;
	
	@Autowired
	private CommandExecutor commandExecutor;

	protected final ListOfSubscribers listOfSubscribers;


	public PublisherImpl(ListOfSubscribers listOfSubscribers, UserMetadata publisherMetadata) {
		super();
		this.listOfSubscribers = listOfSubscribers;

		this.publisherMetadata = publisherMetadata;
	}


	public synchronized void addObserver(UserMetadata subscriberMetadata) {
		if (subscriberMetadata == null)
			throw new NullPointerException();
		if (!listOfSubscribers.contains(subscriberMetadata))
			listOfSubscribers.add(subscriberMetadata);
		else
			throw new IllegalArgumentException("cannot add subscriber, it has already been added!");
	}


	public synchronized void deleteObserver(UserMetadata subscriberMetadata) {
		if(!listOfSubscribers.contains(subscriberMetadata))
			throw new IllegalArgumentException("cannot remove subscriber, that has not been added yet!");
		listOfSubscribers.remove(subscriberMetadata);
	}


	public synchronized void deleteObservers() {
		listOfSubscribers.clear();
	}


	public synchronized int countObservers() {
		return listOfSubscribers.size();
	}


	public void notifyObservers() {
		notifyObservers(null);
	}


	public void notifyObservers(ForeignInformationFile change) {
		/*
		 * a temporary array buffer, used as a snapshot of the state of current Observers.
		 */
		Object[] arrLocal;

		synchronized (this) {
			/*
			 * We don't want the Observer doing callbacks into arbitrary code while holding its own Monitor. The code
			 * where we extract each Observable from the Vector and store the state of the Observer needs
			 * synchronization, but notifying observers does not (should not). The worst result of any potential
			 * race-condition here is that: 1) a newly-added Observer will miss a notification in progress 2) a recently
			 * unregistered Observer will be wrongly notified when it doesn't care
			 */
			arrLocal = listOfSubscribers.toArray();
		}

		for (int i = arrLocal.length - 1; i >= 0; i--) {
			// TODO: think about publishing using multiple threads
			UserMetadata subscriberMetadata = (UserMetadata) arrLocal[i];
			
			Command command;
			command = new UpdateCommand(change);
			
			command.setReceiverId(subscriberMetadata.getUserId());
			command.setSenderMetadata(getPublisherMetadata());
			
			commandExecutor.execute(command);
		}
	}


	@Override
	public ListOfSubscribers getListOfSubscribers() {
		return listOfSubscribers;
	}


	@Override
	public UserMetadata getPublisherMetadata() {
		return publisherMetadata;
	}

}
