package deus.model.account;

import deus.model.dossier.generic.PersonalInformationFile;
import deus.model.user.id.UserId;

public class Account<Id extends UserId, ContentType> {
	
	private Id id;
	
	private String password;
	
	private PersonalInformationFile<Id, ContentType> personalInformationFile;

}
