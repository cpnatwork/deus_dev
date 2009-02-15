package deus.model.dossier.deus;

import java.util.Set;

import deus.model.dossier.DigitalCard;
import deus.model.dossier.generic.ForeignInformationFile;
import deus.model.user.UserMetadata;
import deus.model.user.id.UserId;

/**
 * The FIF in the context of DEUS. The type of the content stored is a list of digital cards.
 * 
 * Abbreviation: FPF
 * 
 * @see DigitalCard
 * 
 * @author Florian Rampp (Florian.Rampp@informatik.stud.uni-erlangen.de)
 */
public class ForeignPatientFile extends ForeignInformationFile {

	public ForeignPatientFile(UserId publisherId, UserMetadata publisherMetadata, Set<DigitalCard> digitalCards) {
		super(publisherId, publisherMetadata, digitalCards);
	}

}
