package deus.core.transport.command;

import deus.model.dossier.generic.ForeignInformationFile;

/**
 * Command, issued by the publisher to inform registered subscribers about an update.
 * 
 * @author Florian Rampp (Florian.Rampp@informatik.stud.uni-erlangen.de)
 * 
 */
public class UpdateCommand extends Command {

	private final ForeignInformationFile foreignInformationFile;


	public UpdateCommand(ForeignInformationFile foreignInformationFile) {
		super();
		this.foreignInformationFile = foreignInformationFile;
	}


	public ForeignInformationFile getForeignInformationFile() {
		return foreignInformationFile;
	}

}
