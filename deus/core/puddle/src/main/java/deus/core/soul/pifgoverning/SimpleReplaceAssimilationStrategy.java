package deus.core.soul.pifgoverning;

import java.util.Set;

import deus.model.dossier.DigitalCard;
import deus.model.dossier.InformationFile;

// FIXME: rename to SimpleAppend...
public class SimpleReplaceAssimilationStrategy implements AssimilationStrategy {

	
	@Override
	public void update(InformationFile fif, DigitalCard digitalCard) {
		Set<DigitalCard> digitalCards = fif.getDigitalCards();
		
		if(digitalCards.contains(digitalCard))
			// FIXME: rather throw an exception here? => should result in calling contrib.Denied of Contributor!
			replace(fif, digitalCard);
		else
			append(fif, digitalCard);
	}


	private void replace(InformationFile fif, DigitalCard digitalCard) {
		Set<DigitalCard> digitalCards = fif.getDigitalCards();
		
		// remove old one
		boolean containedDC = digitalCards.remove(digitalCard);
		assert(containedDC == true);
		
		// add new one
		digitalCards.add(digitalCard);
	}
	

	private void append(InformationFile fif, DigitalCard digitalCard) {
		Set<DigitalCard> digitalCards = fif.getDigitalCards();
		digitalCards.add(digitalCard);
	}

}
