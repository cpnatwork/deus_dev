package deus.core.transport.messages;

import deus.model.dossier.generic.ForeignInformationFile;

/**
 * Command, issued by the publisher to inform registered subscribers about an update.
 * 
 * @author Florian Rampp (Florian.Rampp@informatik.stud.uni-erlangen.de)
 * 
 */
public class UpdateMessage extends TransportMessage {

	private final ForeignInformationFile foreignInformationFile;


	public UpdateMessage(ForeignInformationFile foreignInformationFile) {
		super();
		this.foreignInformationFile = foreignInformationFile;
	}


	public ForeignInformationFile getForeignInformationFile() {
		return foreignInformationFile;
	}

}
