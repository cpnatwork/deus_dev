package deus.core.soul.difgoverning;

import deus.model.common.dossier.Patch;
import deus.model.common.user.frids.PublisherId;
import deus.model.common.user.frids.SubscriberId;

public interface DifGovernor extends DifGovernorExportedToClient {

	// FIXME: think about whether this goes to its own interface DifGovernorExportedToSubsystems
	public void applyPatch(SubscriberId subscriberId, PublisherId publisherId, Patch patch);
	
}
