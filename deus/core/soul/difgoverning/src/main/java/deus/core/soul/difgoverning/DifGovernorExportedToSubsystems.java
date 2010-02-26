package deus.core.soul.difgoverning;

import deus.model.common.dossier.Patch;
import deus.model.common.user.frids.PublisherId;
import deus.model.common.user.frids.SubscriberId;

public interface DifGovernorExportedToSubsystems {

	public void applyPatch(SubscriberId subscriberId, PublisherId publisherId, Patch patch);

}