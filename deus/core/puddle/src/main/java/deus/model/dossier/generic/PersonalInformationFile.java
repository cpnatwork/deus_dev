package deus.model.dossier.generic;

import java.util.List;

import deus.model.user.id.UserId;

public abstract class PersonalInformationFile<Id extends UserId, ContentType> {
	
	private List<ContentType> digitalCards;
	
}