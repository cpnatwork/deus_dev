package deus.model.pub.impl;

import java.util.Vector;

import deus.model.pub.ListOfSubscribers;
import deus.model.user.UserMetadata;

public class ThreadSafeListOfSubscribers extends Vector<UserMetadata> implements ListOfSubscribers {

	private static final long serialVersionUID = -5115372700101022103L;

}
