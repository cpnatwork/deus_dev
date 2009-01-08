package deus.model.dossier.deus;

import deus.model.dossier.DigitalCard;
import deus.model.dossier.ForeignInformationFile;
import deus.model.user.id.UserId;

public class ForeignPatientFile<Id extends UserId> extends ForeignInformationFile<Id, DigitalCard<Id>> {

}
