package deus.core.access.transfer.core.messages.publication;

import deus.core.access.transfer.core.messages.TransferMessage;
import deus.model.dossier.DigitalCard;

/**
 * Command, issued by the publisher to inform registered subscribers about an update.
 * 
 * @author Florian Rampp (Florian.Rampp@informatik.stud.uni-erlangen.de)
 * 
 */
public class UpdateMessage extends TransferMessage {

	private final DigitalCard digitalCard;


	public UpdateMessage(DigitalCard digitalCard) {
		super();
		this.digitalCard = digitalCard;
	}


	public DigitalCard getDigitalCard() {
		return digitalCard;
	}

}
