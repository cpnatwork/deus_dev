package deus.core.soul.accountadmin.registrator.impl;

import java.util.List;
import java.util.Vector;

import javax.inject.Inject;
import javax.inject.Named;

import deus.core.access.storage.api.common.account.AccountDao;
import deus.core.access.storage.api.common.user.UserMetadataDao;
import deus.core.soul.accountadmin.registrator.UserIdGenerator;
import deus.core.soul.accountadmin.registrator.UserRegistrationStateObserver;
import deus.core.soul.accountadmin.rolesetup.DistributionRoleSetup;
import deus.model.accountadmin.RegistrationInformation;
import deus.model.common.account.Account;
import deus.model.common.account.DistributionRole;
import deus.model.common.user.id.UserId;

@Named("registrator")
public class RegistratorImpl implements Registrator {

	private final List<UserRegistrationStateObserver> observers;

	@Inject
	private AccountDao accountDao;

	@Inject
	private UserMetadataDao userMetadataDao;
	
	@Inject
	private DistributionRoleSetup distributionRoleSetup;


	@Inject
	private UserIdGenerator userIdGenerator;


	public RegistratorImpl() {
		this.observers = new Vector<UserRegistrationStateObserver>();
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
	public void register(RegistrationInformation registrationInformation) {
		UserId userId = userIdGenerator.generateUserId(registrationInformation.getDesiredUserIdType(),
				registrationInformation.getLocalUsername());

		Account account = new Account(registrationInformation.getLocalUsername(),
				registrationInformation.getPassword(), userId, registrationInformation.getUserRoles());

		userMetadataDao.addNewEntity(userId, registrationInformation.getUserMetadata());
		
		createAccount(account);

		notifyObservers(userId, true);
	}


	private void createAccount(Account account) {
		accountDao.addNewEntity(account);
		// FUTURE: init data objects in database for subsystem Barker here!
		
		// INITIALIZING ROLE DATA ELEMENTS
		for (DistributionRole distributionRole : account.getUserRoles())
			distributionRoleSetup.setUpRole(distributionRole, account.getUserId());
	}


	@Override
	public void unregister(String localUsername) {
		Account account = accountDao.getByNaturalId(localUsername);

		destroyAccount(account);

		notifyObservers(account.getUserId(), false);
	}


	private void destroyAccount(Account account) {
		UserId userId = account.getUserId();

		accountDao.deleteByNaturalId(account.getLocalUsername());
		// FUTURE: destroy data objects in database for subsystem Barker here!
		
		// DESTROYING ROLE DATA ELEMENTS
		for (DistributionRole distributionRole : account.getUserRoles())
			distributionRoleSetup.tearDownRole(distributionRole, userId);
	}


	public boolean existsLocalUsername(String localUserName) {
		return accountDao.existsByNaturalId(localUserName);
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
