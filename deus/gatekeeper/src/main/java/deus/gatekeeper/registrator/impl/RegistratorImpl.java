package deus.gatekeeper.registrator.impl;

import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import deus.core.access.storage.api.attention.AttentionDao;
import deus.core.access.storage.api.attention.AttentionListImpl;
import deus.core.access.storage.api.user.api.LocalUserDao;
import deus.gatekeeper.puddle.RegistrationInformation;
import deus.gatekeeper.registrator.Registrator;
import deus.gatekeeper.registrator.UserIdGenerator;
import deus.gatekeeper.registrator.UserRegistrationStateObserver;
import deus.gatekeeper.rolesetup.UserRoleSetup;
import deus.model.user.Account;
import deus.model.user.UserRole;
import deus.model.user.id.UserId;

@Component("registrator")
public class RegistratorImpl implements Registrator {

	private final List<UserRegistrationStateObserver> observers;

	@Autowired
	private LocalUserDao localUserDao;

	@Autowired
	private AttentionDao attentionDao;

	@Autowired
	private UserRoleSetup userRoleSetup;

	
	@Autowired
	private UserIdGenerator userIdGenerator;


	public RegistratorImpl() {
		this.observers = new Vector<UserRegistrationStateObserver>();
	}


	@Override
	public void register(RegistrationInformation registrationInformation) {
		UserId userId = userIdGenerator.generateUserId(registrationInformation.getDesiredUserIdType(),
				registrationInformation.getLocalUsername());

		Account account = new Account(registrationInformation.getLocalUsername(),
				registrationInformation.getPassword(), userId, registrationInformation.getUserRoles());

		createAccount(account);

		notifyObservers(userId, true);
	}


	private void createAccount(Account account) {
		localUserDao.createAccount(account);
		attentionDao.createAttentionList(new AttentionListImpl());

		// INITIALIZING ROLE DATA ELEMENTS
		for (UserRole userRole : account.getUserRoles())
			userRoleSetup.setUpRole(userRole, account.getUserId());
	}

	private void notifyObservers(UserId userId, boolean registered) {
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
			arrLocal = observers.toArray();
		}

		for (int i = arrLocal.length - 1; i >= 0; i--) {
			UserRegistrationStateObserver observer = (UserRegistrationStateObserver) arrLocal[i];

			if (registered)
				observer.registered(userId);
			else
				observer.unregistered(userId);

		}
	}


	@Override
	public void unregister(UserId userId) {
		// FIXME: implement unregistering a user (use case account closing!)
		

		
		Account account = localUserDao.getAccount(userId);
		
		destroyAccount(account);

		notifyObservers(userId, false);
	}

	
	
	
	
	private void destroyAccount(Account account) {
		UserId userId = account.getUserId();
		
		localUserDao.deleteAccount(userId);
		attentionDao.deleteAttentionList(userId);

		// INITIALIZING ROLE DATA ELEMENTS
		for (UserRole userRole : account.getUserRoles())
			userRoleSetup.tearDownRole(userRole, userId);
	}
	
	
	public boolean existsLocalUsername(String localUserName) {
		return localUserDao.existsLocalUsername(localUserName);
	}


	@Override
	public void addUserRegistrationStateObserver(UserRegistrationStateObserver observer) {
		observers.add(observer);
	}


	@Override
	public void removeUserRegistrationStateObserver(UserRegistrationStateObserver observer) {
		if (observers.remove(observer) == false)
			throw new IllegalArgumentException("observer was not added!");
	}


}
