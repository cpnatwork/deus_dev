package deus.core;

import deus.core.barker.Barker;
import deus.core.lodother.LodOther;
import deus.core.lodself.LodSelf;
import deus.core.publisher.Publisher;
import deus.core.subscriber.Subscriber;
import deus.model.pub.ListOfSubscribers;
import deus.model.sub.ListOfPublishers;
import deus.model.user.UserMetadata;
import deus.remoting.command.RemoteCommandExecutor;
import deus.remoting.state.RemotingStateRegistry;

public class User {

	UserMetadata userMetadata;

	Publisher publisher;
	Subscriber subscriber;

	LodSelf lodSelf;
	LodOther lodOther;

	Barker barker;

	// TODO: think about how to fill this map. Or add RemotingState, when remoting is started??
	RemoteCommandExecutor remoteCommandExecutor;

	RemotingStateRegistry remotingStateRegistry;
	
	boolean loggedIn;
	

	
	
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


	public RemotingStateRegistry getRemotingStateRegistry() {
		return remotingStateRegistry;
	}

}
