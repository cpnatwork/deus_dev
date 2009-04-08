package deus.core.soul.difgoverning.impl;

import deus.model.common.dossier.Patch;
import deus.model.difgoverning.ForeignInformationFile;

public interface PatchStrategy {

	void patch(ForeignInformationFile fif, Patch patch);
	
}
