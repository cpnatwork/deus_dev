package deus.model.depository.generic.impl;

import java.util.Map;

import deus.model.depository.generic.DistributedInformationFolder;
import deus.model.dossier.generic.ForeignInformationFile;
import deus.model.user.id.UserId;

public abstract class DistributedInformationFolderImpl implements
		DistributedInformationFolder {

	protected Map<UserId, ForeignInformationFile> foreignInformationFiles;


	@Override
	public ForeignInformationFile getForeignInformationFile(UserId publisherId) {
		if (!foreignInformationFiles.containsKey(publisherId))
			throw new IllegalArgumentException("no FIF for publisher id " + publisherId);
		else
			return foreignInformationFiles.get(publisherId);
	}


	@Override
	public void updateForeignInformationFile(ForeignInformationFile foreignInformationFile) {
		if (!foreignInformationFiles.containsKey(foreignInformationFile.getPublisherId()))
			throw new IllegalArgumentException("cannot update FIF " + foreignInformationFile
					+ ", it is not contained in the DIF yet!");
		else
			foreignInformationFiles.put(foreignInformationFile.getPublisherId(),
					foreignInformationFile);
	}


	@Override
	public void addForeignInformationFile(ForeignInformationFile foreignInformationFile) {
		if (foreignInformationFiles.containsKey(foreignInformationFile.getPublisherId()))
			throw new IllegalArgumentException("cannot add FIF " + foreignInformationFile
					+ ", there already exists a FIF with the same publisher id!");
		else
			foreignInformationFiles.put(foreignInformationFile.getPublisherId(),
					foreignInformationFile);
	}

}
