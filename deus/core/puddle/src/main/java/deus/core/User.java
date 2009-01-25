package deus.core;

import java.util.HashMap;
import java.util.Map;

import deus.core.barker.Barker;
import deus.core.lodother.LodOther;
import deus.core.lodself.LodSelf;
import deus.core.publisher.Publisher;
import deus.core.subscriber.Subscriber;
import deus.model.pub.ListOfSubscribers;
import deus.model.sub.ListOfPublishers;
import deus.model.user.UserMetadata;
import deus.model.user.transportid.TransportIdType;
import deus.remoting.initializerdestroyer.RemotingState;

public class User {

	UserMetadata userMetadata;

	Publisher publisher;
	Subscriber subscriber;

	LodSelf lodSelf;
	LodOther lodOther;

	Barker barker;

	// TODO: think about how to fill this map. Or add RemotingState, when remoting is started??
	Map<TransportIdType, RemotingState> remotingStates;

	boolean loggedIn;
	

	public boolean hasRemotingState(TransportIdType transportIdType) {
		// TODO: change implementation
		if(remotingStates == null)
			remotingStates = new HashMap<TransportIdType, RemotingState>();
		return remotingStates.containsKey(transportIdType);
	}
	
	public void addRemotingState(TransportIdType transportIdType, RemotingState remotingState) {
		// TODO: change implementation
		if(remotingStates == null)
			remotingStates = new HashMap<TransportIdType, RemotingState>();
		remotingStates.put(transportIdType, remotingState);
	}
	
	public RemotingState getRemotingState(TransportIdType transportIdType) {
		return remotingStates.get(transportIdType);
	}


	public void removeRemotingState(TransportIdType transportIdType) {
		remotingStates.remove(transportIdType);
	}

	
	
	public UserMetadata getUserMetadata() {
		return userMetadata;
	}


	public String toString() {
		return userMetadata.getUserId().toString();
	}


	public ListOfSubscribers getListOfSubscribers() {
		return publisher.getListOfSubscribers();
	}


	public ListOfPublishers getListOfPublishers() {
		// FIXME: implement!
		// return subscriber.getListOfPublishers();
		return null;
	}


	public boolean isLoggedIn() {
		return loggedIn;
	}
	
	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
	}

	public void setUserMetadata(UserMetadata userMetadata) {
		this.userMetadata = userMetadata;
	}

	public Publisher getPublisher() {
		return publisher;
	}

	public Subscriber getSubscriber() {
		return subscriber;
	}

}
