package deus.model.dossier.deus;

import java.util.List;

import deus.model.dossier.DigitalCard;
import deus.model.dossier.generic.PersonalInformationFile;
import deus.model.user.id.UserId;

/**
 * The PIF in the context of DEUS. The content type stored is a list of digital cards.
 * 
 * Abbreviation: PPF
 * 
 * @see DigitalCard
 * 
 * @author Florian Rampp (Florian.Rampp@informatik.stud.uni-erlangen.de)
 *
 * @param <Id>
 */
public class PersonalPatientFile<Id extends UserId> extends PersonalInformationFile<Id, List<DigitalCard<Id>>> {

}
