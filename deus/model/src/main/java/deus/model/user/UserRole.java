package deus.model.user;

/**
 * Defines which roles a user can have (he can have multiple roles!)
 * 
 * cp means, the user owns a PIF, can edit this and publish changes of it to registered subscribers.
 * 
 * subscriber means, the user can subscribe to the PIF of other users and maintain a DIF of FPFs of other users.
 * 
 * contributorOther means, the user can contribute to the PPF of other users.
 * 
 * @author Florian Rampp (Florian.Rampp@informatik.stud.uni-erlangen.de)
 * 
 */
// FIXME: think about whether accepting changes from other contributors should be an extra role or if it is included in
// the role cp
public enum UserRole {

	cp, subscriber, contributorOther;

}
