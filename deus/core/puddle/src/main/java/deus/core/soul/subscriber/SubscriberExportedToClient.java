package deus.core.soul.subscriber;

import java.util.List;

import deus.model.dossier.DigitalCard;
import deus.model.dossier.DigitalCardId;
import deus.model.sub.ListOfPublishers;
import deus.model.user.UserMetadata;
import deus.model.user.id.UserId;

/**
 * Groups methods of the interface <code>Subscriber</code> that trigger remote calls. These methods are implemented
 * using a <code>RemoteCommand</code>, that encapsulates the remote action. The calls are delegated to a
 * <code>PublisherStub</code>, that implements the remote call.
 * 
 * @author Florian Rampp (Florian.Rampp@informatik.stud.uni-erlangen.de)
 * 
 */
public interface SubscriberExportedToClient {

	// USE CASE: subscriber initiated connection/termination
	
	public void subscribe(UserId subscriberId, UserId publisherId, UserMetadata publisherMetadata);


	public void unsubscribe(UserId subscriberId, UserId publisherId);

	
	// DATA MODEL RETRIEVING (TO BE MOVED TO ANOTHER SUBSYSTEM)
	
	public List<UserId> getPublishersInDif(UserId subscriberId);
	

	public List<DigitalCardId> getDigitalCardIdsInFif(UserId subscriberId, UserId publisherId);

	
	public DigitalCard getDigitalCardInFif(UserId subscriberId, DigitalCardId digitalCardId);


	// DATA MODEL RETRIEVING
	
	public ListOfPublishers getListOfPublishers(UserId subscriberId);

}
