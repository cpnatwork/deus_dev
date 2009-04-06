package deus.core.soul.difgoverning;

import deus.model.difgoverning.ForeignInformationFile;
import deus.model.dossier.Patch;

public interface PatchStrategy {

	// FIXME: introduce Patch
	void patch(ForeignInformationFile fif, Patch patch);
	
}
