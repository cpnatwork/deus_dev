package deus.core.soul.difgoverning.impl;

import deus.model.difgoverning.ForeignInformationFile;
import deus.model.dossier.Patch;

public interface PatchStrategy {

	void patch(ForeignInformationFile fif, Patch patch);
	
}
