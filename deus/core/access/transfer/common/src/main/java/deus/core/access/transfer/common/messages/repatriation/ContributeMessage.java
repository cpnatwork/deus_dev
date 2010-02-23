package deus.core.access.transfer.common.messages.repatriation;

import deus.core.access.transfer.common.messages.TransferMessage;
import deus.model.common.dossier.DigitalCard;

/**
 * Message that is sent in the repatriation phase, when a digital card is contributed.
 *  
 * @author Florian Rampp (Florian.Rampp@jambit.com)
 *
 */
public class ContributeMessage extends TransferMessage {

	private final DigitalCard dcToContribute;

	public ContributeMessage(DigitalCard dcToContribute) {
		super();
		this.dcToContribute = dcToContribute;
	}

	public DigitalCard getDcToContribute() {
		return dcToContribute;
	}

}
