package deus.model.common.account;

/**
 * Defines which roles a user can have (he can have multiple roles!)
 * 
 * concernedPerson means, the user owns a PIF, can edit this and publish changes of it to registered subscribers.
 * 
 * informationConsumer means, the user can subscribe to the PIF of other users and maintain a DIF of FPFs of other users.
 * 
 * informationProvider means, the user can contribute to the PPF of other users.
 * 
 * @author Florian Rampp (Florian.Rampp@informatik.stud.uni-erlangen.de)
 * 
 */
public enum DistributionRole {

	concernedPerson, informationConsumer, informationProvider;

}
