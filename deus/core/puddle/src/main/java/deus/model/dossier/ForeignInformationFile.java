package deus.model.dossier;

import java.util.List;

import deus.model.user.id.UserId;

public abstract class ForeignInformationFile<Id extends UserId, ContentType> extends InformationFile<Id> {
	
	private List<ContentType> digitalCards;
	
}
