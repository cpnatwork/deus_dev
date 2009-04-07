package deus.core.soul.pifgoverning;

import java.util.Set;

import deus.model.dc.DigitalCard;
import deus.model.dossier.AppendDigitalCardPatch;
import deus.model.dossier.InformationFile;
import deus.model.dossier.Patch;

public class SimpleAppendAssimilationStrategy implements AssimilationStrategy {

	@Override
	public Patch update(InformationFile fif, DigitalCard digitalCard) {
		Set<DigitalCard> digitalCards = fif.getDigitalCards();

		if (digitalCards.contains(digitalCard))
			// FIXME: which exception to throw here?
			throw new RuntimeException();
		else
			return append(fif, digitalCard);
	}
	

/*	private Patch replace(InformationFile fif, DigitalCard digitalCard) {
		Set<DigitalCard> digitalCards = fif.getDigitalCards();

		// remove old one
		boolean containedDC = digitalCards.remove(digitalCard);
		assert (containedDC == true);

		// add new one
		digitalCards.add(digitalCard);
	}*/
	
	

	private Patch append(InformationFile fif, DigitalCard digitalCard) {
		Set<DigitalCard> digitalCards = fif.getDigitalCards();
		digitalCards.add(digitalCard);

		// create patch
		AppendDigitalCardPatch patch = new AppendDigitalCardPatch(digitalCard.getDigitalCardId().getCpId());
		patch.setDigitalCardToAppend(digitalCard);
		return patch;
	}
	
}
