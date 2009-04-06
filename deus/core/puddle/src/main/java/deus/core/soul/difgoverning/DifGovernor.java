package deus.core.soul.difgoverning;

import deus.model.dossier.Patch;
import deus.model.user.id.UserId;

public interface DifGovernor extends DifGovernorExportedToClient {

	// FIXME: think about whether this goes to its own interface DifGovernorExportedToSubsystems
	public void applyPatch(UserId residentId, UserId cpId, Patch patch);
	
}
