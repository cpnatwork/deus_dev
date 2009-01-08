package deus.model.dossier.deus;

import deus.model.dossier.DigitalCard;
import deus.model.dossier.ForeignInformationFile;
import deus.model.dossier.proj.party.PartyId;

public class ForeignPatientFile<Id extends PartyId> extends ForeignInformationFile<Id, DigitalCard<Id>> {

}
