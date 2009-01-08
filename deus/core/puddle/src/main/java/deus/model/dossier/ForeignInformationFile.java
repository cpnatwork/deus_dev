package deus.model.dossier;

import java.util.List;

import deus.model.dossier.proj.party.PartyId;

public abstract class ForeignInformationFile<Id extends PartyId, ContentType> extends InformationFile<Id> {
	
	private List<ContentType> digitalCards;
	
}
